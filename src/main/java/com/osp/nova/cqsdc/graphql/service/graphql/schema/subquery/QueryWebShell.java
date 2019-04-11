package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.WebShellRepository;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
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
public class QueryWebShell extends BaseQuery implements GraphQLQueryResolver {
    @Autowired
    WebShellRepository webShellRepository;

    public WebShell webShell(String id){
        return webShellRepository.findById(id).get();
    }
    public List<WebShell> webshells(List<ConditionPojo> lcs, GraphQlPage page){
        List<WebShell> webShells ;
        if(lcs==null&&page==null){
            webShells=webShellRepository.findAll();
        }else if(lcs==null&&page!=null){
            webShells=webShellRepository.findAll(page.getJPAPage()).getContent();
        }else if(lcs!=null&&page!=null){
            webShells=webShellRepository.findAll(getJPASpecification(lcs,WebShell.class),page.getJPAPage()).getContent();
        }else{
            webShells=webShellRepository.findAll(getJPASpecification(lcs,WebShell.class));
        }
        return webShells;
    }
}
