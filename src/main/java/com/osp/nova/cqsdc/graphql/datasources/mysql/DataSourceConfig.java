package com.osp.nova.cqsdc.graphql.datasources.mysql;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

/**
 * @program: graphql-mudule
 * @description: mysql数据源配置类
 * @author: liting
 * @create: 2019-04-02 14:05
 **/
@Configuration
public class DataSourceConfig{


    @Bean
    @Qualifier("novaDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.nova.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @Qualifier("stateDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.state.datasource")
    public DataSourceProperties stateDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("nssaDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.nssa.datasource")
    public DataSourceProperties nssaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "novaDataSource")
    @Qualifier("novaDataSource")
    public DataSource novaDataSource(@Qualifier("novaDataSourceProperties") DataSourceProperties novaDataSourceProperties) {
        return novaDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "stateDataSource")
    @Qualifier("stateDataSource")
    @Primary
    public DataSource stateDataSource(@Qualifier("stateDataSourceProperties") DataSourceProperties stateDataSourceProperties) {
        return stateDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "nssaDataSource")
    @Qualifier("nssaDataSource")
    public DataSource nssaDataSource(@Qualifier("nssaDataSourceProperties") DataSourceProperties nssaDataSourceProperties) {
        return nssaDataSourceProperties.initializeDataSourceBuilder().build();
    }
}
