package com.osp.nova.cqsdc.graphql;

import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.repository.StdsEventRepository;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository.SrcIpRepository;
import com.osp.nova.cqsdc.graphql.service.graphql.schema.Query;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphqlApplicationTests {

    @Autowired
    private SrcIpRepository srcIpRepository;
    @Autowired
    StdsEventRepository stdsEventRepository;
    @Autowired
    Query query;
    @Test
    public void contextLoads() throws IllegalAccessException, InvocationTargetException, CannotCompileException, NotFoundException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IOException {
      /*  System.out.println("size="+srcIpRepository.findAll().size());
        Iterator<StdsEvent> is = stdsEventRepository.findAll().iterator();
        while (is.hasNext()){
            StdsEvent se = is.next();
            System.out.println(se.toString());
        }*/
      /*  cc.doInvoke();*/
//        System.out.println("---------------------------------------------------------");
//        System.out.println("size="+query.getAllDstIps().size());
//        System.out.println("size="+query.getAllMaterialInfos().size());
        //System.out.println("size="+query.getAllSrcIps().size());
        //System.out.println("size="+query.getAllStdsEvents().size());
//        System.out.println("size="+query.getAllWebShells().size());
        System.out.println("11");
    }

}
