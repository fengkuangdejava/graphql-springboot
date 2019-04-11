package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.alibaba.fastjson.JSONObject;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.Lists;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.pojo.Host;
import com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.repository.HostRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-10 17:54
 **/
@Service
public class DstIpResolver extends BaseResolver implements GraphQLResolver<DstIp> {
    @Autowired
    StdsEventRepository stdsEventRepository;
    @Autowired
    HostRepository hostRepository;
    public List<StdsEvent> dstIpStdsEvents(DstIp dstIp, List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromDstIp(dstIp));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return Lists.newArrayList(results);
    }



    public long dstIpEventsCount(DstIp dstIp,List<ConditionPojo> lcs) throws NoSuchFieldException, ClassNotFoundException {
        lcs=lcs==null ? new ArrayList<ConditionPojo>() : lcs;
        lcs.add(getESConditionFromDstIp(dstIp));
        Iterable<StdsEvent> results= stdsEventRepository.search(getJPAESQuery(lcs,StdsEvent.class));
        return  Lists.newArrayList(results).size();
    }

    public Host hostInfo(DstIp dstIp){
        return  hostRepository.findByIp(dstIp.getAttackDstIp());
    }
}
