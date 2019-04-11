package com.osp.nova.cqsdc.graphql.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import lombok.Data;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @program: graphql-module
 * @description: a
 * @author: liting
 * @create: 2019-04-09 16:03
 **/
@Data
public class ConditionPojo {
    private String type;
    private String condition;

    public Predicate getMysqlPredicate(Root root,CriteriaBuilder criteriaBuilder,Class clazz) throws ClassNotFoundException, NoSuchFieldException {
        Predicate predicate= null;
       String type = this.getType();
       JSONObject condition = JSONObject.parseObject(this.getCondition());
       String key =condition.getString("key");
       Class keyClass = getKeyClass(clazz,key);
        if(type.equals("like")){
            Object value = condition.get("value");
            predicate = criteriaBuilder.like(root.get(key).as(keyClass), "%"+value + "%");
        }else if(type.equals("eq")){
            Object value = condition.get("value");
            predicate = criteriaBuilder.equal(root.get(key).as(keyClass),value);
        }else if(type.equals("big")){
            Object value = condition.get("value");
            String s = String.valueOf(value);
            predicate = criteriaBuilder.greaterThan(root.get(key).as(keyClass),Double.valueOf(s));
        }else if(type.equals("small")){
            Object value = condition.get("value");
            String s = String.valueOf(value);
            predicate = criteriaBuilder.lessThan(root.get(key).as(keyClass),Double.valueOf(s));
        }else if(type.equals("in")){
            JSONArray jsonArray = condition.getJSONArray("list");
            List list = jsonArray.toJavaList(keyClass);
            predicate =  criteriaBuilder.isTrue(root.get(key).as(keyClass).in(list));
        }else if(type.equals("notIn")){
            JSONArray jsonArray = condition.getJSONArray("list");
            List list = jsonArray.toJavaList(keyClass);
            predicate = criteriaBuilder.isFalse(root.get(key).as(keyClass).in(list));
        }else if(type.equals("between")){
            Object lowValue = condition.get("lowValue");
            String s1 = String.valueOf(lowValue);
            Object highValue = condition.get("highValue");
            String s2 = String.valueOf(highValue);
            predicate = criteriaBuilder.between(root.get(key).as(keyClass),Double.valueOf(s1),Double.valueOf(s2));
        }
        return predicate;
    }


    public Class getKeyClass(Class clazz,String key) throws  NoSuchFieldException {
       Field fd = clazz.getDeclaredField(key);
       return fd.getType();
    }

    public QueryBuilder getESQuery(Class clazz) throws NoSuchFieldException {
        String type = this.getType();
        JSONObject condition = JSONObject.parseObject(this.getCondition());
        String key =condition.getString("key");
        Class keyClass = getKeyClass(clazz,key);
        QueryBuilder q = null;
        if(type.equals("like")){
            String value = condition.getString("value");
            q=QueryBuilders.wildcardQuery(key,"*"+value+"*");
        }else if(type.equals("eq")){
             Object value = condition.get("value");
             q=QueryBuilders.termQuery(key,value);
        }else if(type.equals("big")){
            Object value = condition.get("value");
            q=QueryBuilders.rangeQuery(key).gte(value);
        }else if(type.equals("small")){
            Object value = condition.get("value");
            q=QueryBuilders.rangeQuery(key).lte(value);
        }else if(type.equals("in")){
            JSONArray jsonArray = condition.getJSONArray("list");
            List list = jsonArray.toJavaList(keyClass);
            Object[] oa = list.toArray();
            QueryBuilders.termQuery(key,oa);
        }else if(type.equals("notIn")){
            JSONArray jsonArray = condition.getJSONArray("list");
            List list = jsonArray.toJavaList(keyClass);
            Object[] oa = list.toArray();
            q=QueryBuilders.boolQuery().mustNot( QueryBuilders.termQuery(key,oa));
        }else if(type.equals("between")){
            Object lowValue = condition.get("lowValue");
            Object highValue = condition.get("highValue");
            q=QueryBuilders.rangeQuery(key).gt(lowValue).lt(highValue);
        }
        return q;
    }
}
