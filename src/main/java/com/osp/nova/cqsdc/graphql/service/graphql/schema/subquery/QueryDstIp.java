package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.DstIpRepository;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-08 10:18
 **/
@Service
public class QueryDstIp extends BaseQuery implements GraphQLQueryResolver {
    @Autowired
    DstIpRepository dstIpRepository;

    public DstIp dstIp(String id){
        return dstIpRepository.findById(id).get();
    }
    public List<DstIp> dstIps(List<ConditionPojo> lcs, GraphQlPage page){
        List<DstIp> DstIps ;
        if(lcs==null&&page==null){
            DstIps=dstIpRepository.findAll();
        }else if(lcs==null&&page!=null){
            DstIps=dstIpRepository.findAll(page.getJPAPage()).getContent();
        }else if(lcs!=null&&page!=null){
            DstIps=dstIpRepository.findAll(getJPASpecification(lcs,DstIp.class),page.getJPAPage()).getContent();
        }else{
            DstIps=dstIpRepository.findAll(getJPASpecification(lcs,DstIp.class));
        }
        return DstIps;
    }



}
