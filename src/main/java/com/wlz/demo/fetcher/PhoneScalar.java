package com.wlz.demo.fetcher;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * 手机号验证
 * @author wlz
 * @date 9/14/18 10:15
 */
@Component
public class PhoneScalar extends GraphQLScalarType {
    public PhoneScalar() {
        super("PhoneScalar", "Phone style", new Coercing() {
            @Override
            public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
                // 手机号输出output
                return dataFetcherResult;
            }

            @Override
            public Object parseValue(Object input) throws CoercingParseValueException {
                return serialize(input);
            }

            @Override
            public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof StringValue) {
                    String mobile = ((StringValue) input).getValue();
                    String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
                    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(mobile);
                    if (matcher.matches()) {
                        return mobile;
                    } else {
                        // 异常例子
                        throw new CoercingParseLiteralException("手机号格式错误！");
                    }
                }
                throw new CoercingParseLiteralException("手机号格式错误！");
            }
        });
    }
}
