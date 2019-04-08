package com.osp.nova.cqsdc.graphql.datasources.es.primary.repository;

import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: graphql-mudule
 * @description: aa
 * @author: liting
 * @create: 2019-04-02 18:19
 **/
@Repository
public interface StdsEventRepository extends ElasticsearchRepository<StdsEvent, String> {
    List<StdsEvent>  findBySrcip(String ip);
    long countBySrcip(String ip);
}
