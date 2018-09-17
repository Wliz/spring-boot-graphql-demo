package com.wlz.demo.enumeration;

/**
 * 公司类型
 *
 * @author wlz
 * @date 9/6/18 17:29
 */
public enum CompanyType implements BaseEnum {
    SERVICE("服务公司", 1),     //
    OPERATION("运营公司", 2),   //
    AGENT("中介公司", 3),   //
    SELF_OPERATION("自营公司", 4);      //

    private String msg;

    private Integer value;

    CompanyType(String msg, Integer value) {
        this.msg = msg;
        this.value = value;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
