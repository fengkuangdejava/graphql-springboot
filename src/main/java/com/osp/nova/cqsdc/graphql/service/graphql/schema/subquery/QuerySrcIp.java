package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.SrcIpRepository;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-04 18:56
 **/
@Service
public class QuerySrcIp extends BaseQuery implements GraphQLQueryResolver {
    @Autowired
    SrcIpRepository srcIpRepository;
    public SrcIp srcIp(String id){
        return srcIpRepository.findById(id).get();
    }
    public List<SrcIp> srcIps(List<ConditionPojo> lcs,GraphQlPage page){
        List<SrcIp> srcIps ;
        if(lcs==null&&page==null){
            srcIps=srcIpRepository.findAll();
        }else if(lcs==null&&page!=null){
            srcIps=srcIpRepository.findAll(page.getJPAPage()).getContent();
        }else if(lcs!=null&&page!=null){
            srcIps=srcIpRepository.findAll(getJPASpecification(lcs,SrcIp.class),page.getJPAPage()).getContent();
        }else{
            srcIps=srcIpRepository.findAll(getJPASpecification(lcs,SrcIp.class));
        }
        return srcIps;
    }
}
