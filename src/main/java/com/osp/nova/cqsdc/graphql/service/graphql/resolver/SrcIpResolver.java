package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.alibaba.fastjson.JSONObject;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-04 11:10
 **/
@Component
public class SrcIpResolver extends BaseResolver implements GraphQLResolver<SrcIp> {

    @Autowired
    StdsEventRepository stdsEventRepository;

    public List<StdsEvent> srcIpStdsEvents(SrcIp srcIp,List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromSrcIp(srcIp));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return Lists.newArrayList(results);
    }

    public long srcIpEventsCount(SrcIp srcIp,List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromSrcIp(srcIp));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return  Lists.newArrayList(results).size();
    }
}
