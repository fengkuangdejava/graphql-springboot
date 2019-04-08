package com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.DstIpRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.GraphQlPage;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-08 10:18
 **/
@Service
public class QueryDstIp implements GraphQLQueryResolver {
    @Autowired
    DstIpRepository dstIpRepository;

    public DstIp getDstIpByIp(String id){
        return dstIpRepository.findById(id).get();
    }
    public List<DstIp> getAllDstIps(GraphQlPage page){
        if(page!=null){
            return dstIpRepository.findAll(page.getJPAPage()).getContent();
        }
        return dstIpRepository.findAll();
    }


    /*private boolean haveMethod(Class clazz,String methodName){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(clazz.getName());
            CtMethod[] cms = cc.getMethods();
            for(int i=0;i<cms.length;i++){
                ifcms[i].getName()
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DstIp custemFind(String method,Object... objects) throws CannotCompileException, NotFoundException, ClassNotFoundException {
        String className = DstIp.class.toString();
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(className);
        CtMethod mthd = CtNewMethod.make("public DstIp "+method, cc);
        cc.addMethod(mthd);


    }*/


}
