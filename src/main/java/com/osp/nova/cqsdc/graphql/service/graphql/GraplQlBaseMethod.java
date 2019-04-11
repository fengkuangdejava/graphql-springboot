package com.osp.nova.cqsdc.graphql.service.graphql;

import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import com.osp.nova.cqsdc.graphql.pojo.ConditionPojo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-10 11:40
 **/
public class GraplQlBaseMethod {
    protected Specification getJPASpecification(List<ConditionPojo> lcs, Class clazz) {
        Specification<SrcIp> example = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (lcs != null) {
                    for (ConditionPojo cs : lcs) {
                        try {
                            predicates.add(cs.getMysqlPredicate(root, criteriaBuilder, clazz));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return example;
    }

    protected BoolQueryBuilder getJPAESQuery(List<ConditionPojo> lcs, Class clazz) throws NoSuchFieldException, ClassNotFoundException {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (lcs != null) {
            for (ConditionPojo cs : lcs) {
                boolQueryBuilder.must(cs.getESQuery(clazz));
            }
        }
        return boolQueryBuilder;
    }
}
