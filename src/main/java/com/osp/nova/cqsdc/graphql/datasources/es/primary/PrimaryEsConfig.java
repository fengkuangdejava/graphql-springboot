package com.osp.nova.cqsdc.graphql.datasources.es.primary;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.osp.nova.cqsdc.graphql.datasources.es.primary.repository")
public class PrimaryEsConfig {

   @Autowired
    PrimaryEsProperty primaryEsProperty;

    @Bean
    @Primary
    public Client client() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", primaryEsProperty.getClusterName()).build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(primaryEsProperty.getHost()), primaryEsProperty.getPort()));
        return client;
    }

    @Bean
    @Primary
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
