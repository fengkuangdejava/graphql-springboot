package com.osp.nova.cqsdc.graphql.service.graphql.schema;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.osp.nova.cqsdc.graphql.service.graphql.schema.subquery.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Getter
public class Query implements GraphQLQueryResolver {

    @Autowired
    QuerySrcIp querySrcIp;
    @Autowired
    QueryDstIp queryDstIp;
    @Autowired
    QueryWebShell queryWebShell;
    @Autowired
    QueryMaterialInfo queryMaterialInfo;
    @Autowired
    QueryStdsEvent queryStdsEvent;
}
