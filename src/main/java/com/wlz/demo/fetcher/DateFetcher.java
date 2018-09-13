package com.wlz.demo.fetcher;

import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * @author wlz
 * @date 9/11/18 17:20
 */
//@Slf4j
@Component
public class DateFetcher extends GraphQLScalarType{

    public DateFetcher() {
        super("Wlz", "date", new Coercing() {
            @Override
            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                return LocalDateTime.ofInstant(((Date) dataFetcherResult).toInstant(), ZoneId.of("Asia/Shanghai"))
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }

            @Override
            public Object parseValue(Object input) throws CoercingParseValueException {
                return serialize(input);
            }

            @Override
            public ZonedDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof String) {
                    return ZonedDateTime.parse(((StringValue) input).getValue());
                } else if (input instanceof Integer) {
                    return Instant.ofEpochMilli(((IntValue) input).getValue().longValue()).atZone(ZoneOffset.UTC);
                } else {
                    return null;
                }
            }
        });
    }
}
