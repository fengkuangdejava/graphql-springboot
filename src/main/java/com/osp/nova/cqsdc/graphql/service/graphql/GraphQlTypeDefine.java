package com.osp.nova.cqsdc.graphql.service.graphql;

import graphql.language.IntValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

/**
 * @program: graphql
 * @description: springBean注册中心
 * @author: liting
 * @create: 2019-04-01 17:41
 **/
@Configuration
public class GraphQlTypeDefine {
    @Bean
    public GraphQLScalarType DateTime() {
        GraphQLScalarType dateTime = new GraphQLScalarType("DateTime", "DataTime scalar",  new Coercing() {
            @Override
            public Long serialize(Object input) {
                if (input instanceof Date) {
                    return ((Date) input).getTime();
                }
                return null;
            }

            @Override
            public Date parseValue(Object input) {
                if (input instanceof Long) {
                    return new Date((Long) input);
                }
                return null;
            }

            @Override
            public Date parseLiteral(Object input) {
                if (input instanceof IntValue) {
                    return new Date(((IntValue) input).getValue().longValue());
                }
                return null;
            }
        });
        return dateTime;
    }
}
