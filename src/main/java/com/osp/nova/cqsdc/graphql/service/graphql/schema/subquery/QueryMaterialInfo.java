package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.MaterialInfo;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.MaterialInfoRepository;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
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
public class QueryMaterialInfo extends BaseQuery implements GraphQLQueryResolver {
    @Autowired
    MaterialInfoRepository materialInfoRepository;
    public MaterialInfo materialInfo(String id){
        return materialInfoRepository.findById(id).get();
    }
    public List<MaterialInfo> materialInfos(List<ConditionPojo> lcs, GraphQlPage page){
        List<MaterialInfo> materialInfos ;
        if(lcs==null&&page==null){
            materialInfos=materialInfoRepository.findAll();
        }else if(lcs==null&&page!=null){
            materialInfos=materialInfoRepository.findAll(page.getJPAPage()).getContent();
        }else if(lcs!=null&&page!=null){
            materialInfos=materialInfoRepository.findAll(getJPASpecification(lcs,MaterialInfo.class),page.getJPAPage()).getContent();
        }else{
            materialInfos=materialInfoRepository.findAll(getJPASpecification(lcs,MaterialInfo.class));
        }
        return materialInfos;
    }
}
