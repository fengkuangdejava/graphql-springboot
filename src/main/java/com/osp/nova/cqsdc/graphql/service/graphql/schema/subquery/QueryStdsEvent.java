package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 10:22
 **/
@Service
public class QueryStdsEvent {
    @Autowired
    StdsEventRepository stdsEventRepository;
    public StdsEvent stdsEventById(String id){
        return stdsEventRepository.findById(id).get();
    }
    public List<StdsEvent> getAllStdsEvents(GraphQlPage page){
        if(page!=null) {
           return stdsEventRepository.findAll(page.getJPAPage()).getContent();
        }else{
           return Lists.newArrayList(stdsEventRepository.findAll());
        }
    }
}
