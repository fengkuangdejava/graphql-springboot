package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-04 11:10
 **/
@Component
public class SrcIpResolver implements GraphQLResolver<SrcIp> {

    @Autowired
    StdsEventRepository stdsEventRepository;

    public List<StdsEvent> srcIpStdsEvents(SrcIp srcIp){
        Iterable<StdsEvent> results= stdsEventRepository.search(QueryBuilders.termQuery("srcip",srcIp.getAttackSrcIp()));
        return Lists.newArrayList(results);
    }

    public long srcIpEventsCount(SrcIp srcIp){
        return stdsEventRepository.countBySrcip(srcIp.getAttackSrcIp());
    }
}
