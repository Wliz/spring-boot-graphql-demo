package com.wlz.demo.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解自定义以及反射注解处理（构建sql语句示例）
 *
 * @author wlz
 * @date 9/25/18 16:00
 */
public class AnnotationDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String classPath = "com.wlz.demo.annotations.Member";
        String buildSql = createTableSql(classPath);
        System.out.println("路径" + classPath + "构建的create sql 语句是: \n" +
            buildSql);
    }

    /**
     * 反射获取类注解构建对应sql语句
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        DBTable dbTable = clazz.getAnnotation(DBTable.class);

        if (dbTable == null) {
            System.out.println("未发现DBTable注解在类名" + className);
            return null;
        }

        String tableName = dbTable.value();
        // 是否填写
        if (tableName.length() < 1) {
            System.out.println("注解未配置表名，自动获取类名作为表名");
            tableName = clazz.getName().toUpperCase();
        }

        List<String> fields = new ArrayList<>();
        // 获取自身所有字段
        for (Field field : clazz.getDeclaredFields()) {
            // 判断字段类型（通过获取注解反射）
            String columnName = null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1) {
                continue;
            }
            // 处理字段注解配置
            if (annotations[0] instanceof SQLInteger) {
                // 字段类型为SQLInteger类型
                SQLInteger sqlInteger = (SQLInteger) annotations[0];

                if (sqlInteger.name().length() < 1) {
                    columnName = field.getName();
                } else {
                    columnName = sqlInteger.name();
                }
                fields.add(columnName + " INT " + getConstraints(sqlInteger.constraint()));
            }

            if (annotations[0] instanceof SQLString) {
                SQLString sqlString = (SQLString) annotations[0];
                if (sqlString.name().length() < 1) {
                    columnName = field.getName();
                } else {
                    columnName = sqlString.name();
                }
                fields.add(columnName + " VARCHAR(" + sqlString.value() + ") " + getConstraints(sqlString.constraint()));
            }
        }

        // 构建sql语句
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (");
        fields.forEach(field -> sql.append("\n " + field + ","));
        String finalSql = sql.substring(0, sql.length() - 1) + " );";

        return finalSql;
    }

    /**
     * 判断是否包含constraint约束
     * @param contains
     * @return
     */
    public static String getConstraints(Contains contains) {
        String constraint = "";
        if (contains.primaryKey()) {
            constraint += " PRIMARY KEY";
        }
        if (!contains.allowNull()) {
            constraint += " NOT NULL";
        }
        if (contains.unique()) {
            constraint += " UNIQUE";
        }
        return constraint;
    }
}

@DBTable("memeber")
class Member {

    @SQLInteger(name = "id", constraint = @Contains(primaryKey = true, unique = true))
    private Long id;

    @SQLString(name = "username", value = 50)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DBTable {
    // 只有一个值时，可以使用value方法，在使用注解时可以不用写key
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Contains {
    boolean primaryKey() default false;
    boolean allowNull() default false;
    boolean unique() default false;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLInteger {
    String name() default "";

    /**
     * 嵌套注解
     * @return
     */
    Contains constraint() default @Contains;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {
    String name() default "";

    /**
     * 字段长度限制
     * @return
     */
    int value() default 0;
    /**
     * 嵌套注解
     */
    Contains constraint() default @Contains;
}
