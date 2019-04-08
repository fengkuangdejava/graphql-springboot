package com.osp.nova.cqsdc.graphql.config;

/**
 * @program: graphql-module
 * @description: aa
 * @author: liting
 * @create: 2019-04-08 17:00
 **/
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Invoker {

    public Object getInstance(Class<?> cls){
        Object newProxyInstance = Proxy.newProxyInstance(
                cls.getClassLoader(),
                new Class[]{cls},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {

                            try {
                                return method.invoke(this, args);
                            } catch (Throwable t) {
                                t.printStackTrace();
                            }
                        return null;
                    }
                });
        return (Object)newProxyInstance;
    }
}
