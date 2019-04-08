package com.osp.nova.cqsdc.graphql.service.graphql;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-08 10:48
 **/
@Data
public class GraphQlPage {
    private int page;
    private int size;
    private String sort;
    private String direction;

    public Pageable getJPAPage(){
        Sort.Direction sd = null;
        if(getSort()!=null&&size>0) {
            if (direction != null && direction.equals("ASC")) {
                sd = Sort.Direction.ASC;
            }
            return PageRequest.of(page, size, sd, sort);
        }else {
            return  PageRequest.of(page,size);
        }
    }
}
