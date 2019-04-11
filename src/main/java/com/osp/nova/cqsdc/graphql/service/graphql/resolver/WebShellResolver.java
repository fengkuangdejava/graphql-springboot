package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.alibaba.fastjson.JSONObject;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-10 18:00
 **/
@Service
public class WebShellResolver extends BaseResolver implements GraphQLResolver<WebShell> {
    @Autowired
    StdsEventRepository stdsEventRepository;

    public List<StdsEvent> webShellStdsEvents(WebShell webShell, List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromWebShell(webShell));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return Lists.newArrayList(results);
    }



    public long webShellEventsCount(WebShell webShell,List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromWebShell(webShell));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return  Lists.newArrayList(results).size();
    }
}
