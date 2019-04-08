package com.osp.nova.cqsdc.graphql.datasources.es.primary;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: graphql-mudule
 * @description: aa
 * @author: liting
 * @create: 2019-04-03 11:08
 **/
@Data
@Component
@PropertySource("classpath:datasource.properties")
@ConfigurationProperties(prefix = "elasticsearch.primary")
public class PrimaryEsProperty {
    private String host;
    private int port;
    private String clusterName;
}
