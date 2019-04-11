package com.osp.nova.cqsdc.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {ElasticsearchDataAutoConfiguration.class})
@PropertySource(value = {"classpath:application.properties", "classpath:datasource.properties"})
public class GraphqlApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraphqlApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }
}
