package com.osp.nova.cqsdc.graphql.config;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 16:23
 **/
public class Ue {
    private String name;
    private String id;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String sayHello(){
        return "hello";
    }
}
