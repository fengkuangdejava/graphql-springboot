package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.pojo.Host;
import com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.repository.HostRepository;
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
public class QueryHost implements GraphQLQueryResolver {
    @Autowired
    HostRepository hostRepository;

    public Host getHostByIp(String ip){
        return hostRepository.findByIp(ip);
    }

    public List<Host> getAllHosts(GraphQlPage page){
        if(page!=null){
            return hostRepository.findAll(page.getJPAPage()).getContent();
        }
        return hostRepository.findAll();
    }
}
