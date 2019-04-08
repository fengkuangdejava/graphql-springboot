package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.MaterialInfo;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.MaterialInfoRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 10:20
 **/
@Service
public class QueryMaterialInfo implements GraphQLQueryResolver {
    @Autowired
    MaterialInfoRepository materialInfoRepository;
    public MaterialInfo getMaterialInfoByUrl(String id){
        return materialInfoRepository.findById(id).get();
    }
    public List<MaterialInfo> getAllMaterialInfos(GraphQlPage page){
        if(page!=null){
            return materialInfoRepository.findAll(page.getJPAPage()).getContent();
        }
        return materialInfoRepository.findAll();
    }
}
