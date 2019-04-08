package com.osp.nova.cqsdc.graphql.config;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 16:29
 **/
public interface UA<T> {
    default T sayHello1(){
        System.out.println("aa");
        String a = "aa";
        Object b =(Object) a;
        return (T)b;
    }
}
