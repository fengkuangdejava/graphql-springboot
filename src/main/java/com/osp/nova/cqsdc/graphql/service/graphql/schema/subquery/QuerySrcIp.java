package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.SrcIpRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-04 18:56
 **/
@Service
public class QuerySrcIp implements GraphQLQueryResolver {
    @Autowired
    SrcIpRepository srcIpRepository;
    public SrcIp getSrcIpByIp(String id){
        return srcIpRepository.findById(id).get();
    }
    public List<SrcIp> getAllSrcIps(GraphQlPage page){
        if(page!=null) {
            return srcIpRepository.findAll(page.getJPAPage()).getContent();
        }else {
           return srcIpRepository.findAll();
        }
    }
}
