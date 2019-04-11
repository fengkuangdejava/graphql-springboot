package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.DstIpRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.SrcIpRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.WebShellRepository;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-04 14:13
 **/
@Component
public class StdsEventResolver extends BaseResolver implements GraphQLResolver<StdsEvent> {
    @Autowired
    SrcIpRepository srcIpRepository;
    @Autowired
    DstIpRepository dstIpRepository;
    @Autowired
    WebShellRepository webShellRepository;
    public SrcIp srcIpObject(StdsEvent stdsEvent){
        return srcIpRepository.findById(stdsEvent.getSrcip()).get();
    }
    public DstIp dstIpObject(StdsEvent stdsEvent){
        return  dstIpRepository.findById(stdsEvent.getDstip()).get();
    }
    public WebShell webShellObject(StdsEvent stdsEvent){
        WebShell ws=null;
        ws =webShellRepository.findById(stdsEvent.getBaseurl()).get();
        return ws;
    }
}
