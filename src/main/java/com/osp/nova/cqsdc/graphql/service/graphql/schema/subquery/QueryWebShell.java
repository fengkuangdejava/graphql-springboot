package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.WebShellRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 10:19
 **/
@Service
public class QueryWebShell implements GraphQLQueryResolver {
    @Autowired
    WebShellRepository webShellRepository;

    public WebShell getWebShellByDomain(String id){
        return webShellRepository.findById(id).get();
    }
    public List<WebShell> getAllWebShells(GraphQlPage page,long from,long to){
        if(page!=null){
            webShellRepository.findAll(page.getJPAPage()).getContent();
        }
        return webShellRepository.findAll();
    }
}
