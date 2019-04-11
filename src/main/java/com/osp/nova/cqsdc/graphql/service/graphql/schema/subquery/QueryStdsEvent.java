package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.MaterialInfo;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
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
public class QueryStdsEvent extends BaseQuery implements GraphQLQueryResolver {
    @Autowired
    StdsEventRepository stdsEventRepository;
    public StdsEvent stdsEvent(String id){
        return stdsEventRepository.findById(id).get();
    }
    public List<StdsEvent> stdsEvents(List<ConditionPojo> lcs, GraphQlPage page) throws NoSuchFieldException, ClassNotFoundException {
        List<StdsEvent> stdsEvents ;
        if(lcs==null&&page==null){
            stdsEvents=Lists.newArrayList(stdsEventRepository.findAll());
        }else if(lcs==null&&page!=null){
            stdsEvents=stdsEventRepository.findAll(page.getJPAPage()).getContent();
        }else if(lcs!=null&&page!=null){
            stdsEvents=stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class),page.getJPAPage()).getContent();
        }else{
            stdsEvents=Lists.newArrayList(stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class)));
        }
        return stdsEvents;
    }
}
