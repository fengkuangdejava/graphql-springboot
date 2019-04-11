package com.osp.nova.cqsdc.graphql.service.graphql.resolver;

import com.alibaba.fastjson.JSONObject;
import com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo.StdsEvent;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import com.osp.nova.cqsdc.graphql.service.graphql.GraplQlBaseMethod;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-10 12:01
 **/
public class BaseResolver extends GraplQlBaseMethod {

    protected ConditionPojo getESConditionFromSrcIp(SrcIp srcIp){
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","srcip");
        jsonObject.put("value",srcIp.getAttackSrcIp());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }
    protected ConditionPojo getESConditionFromDstIp(DstIp dstIp) {
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","dstip");
        jsonObject.put("value",dstIp.getAttackDstIp());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }

    protected ConditionPojo getESConditionFromWebShell(WebShell webShell) {
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","baseurl");
        jsonObject.put("value",webShell.getBaseurl());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }

    protected ConditionPojo getSrcIpJPAConditionFromStdsEvent(StdsEvent stdsEvent) {
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","attackSrcIp");
        jsonObject.put("value",stdsEvent.getSrcip());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }

    protected ConditionPojo getDstIpJPAConditionFromStdsEvent(StdsEvent stdsEvent) {
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","attackDstIp");
        jsonObject.put("value",stdsEvent.getDstip());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }

    protected ConditionPojo getWebShellJPAConditionFromStdsEvent(StdsEvent stdsEvent) {
        ConditionPojo conditionPojo = new ConditionPojo();
        conditionPojo.setType("eq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","baseurl");
        jsonObject.put("value",stdsEvent.getBaseurl());
        conditionPojo.setCondition(jsonObject.toJSONString());
        return conditionPojo;
    }
}
