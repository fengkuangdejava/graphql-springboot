package com.osp.nova.cqsdc.graphql.config;

import javassist.*;

import java.lang.reflect.Proxy;

/**
 * @program: graphql-module
 * @description:
 * @author: liting
 * @create: 2019-04-08 16:25
 **/
public class CC {
    public static void main(String args[]) throws NotFoundException, CannotCompileException {
        Class clazz = UA.class;
        String className = clazz.getName();
        String methodName = "killMe(String a)";
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(className);
        System.out.println(clazz.getName());
        System.out.println(clazz.toString());
        System.out.println(clazz.getTypeName());
        CtMethod[] cms = cc.getMethods();
        CtMethod mthd = null;
        if(haveMethod(cms,methodName)){
             mthd = CtNewMethod.make("String "+methodName, cc);
            cc.addMethod(mthd);
        }else{
            mthd=getMethodByName(cms,methodName);
        }
        Object newProxyInstance = new Invoker().getInstance(clazz);

    }

    public static boolean haveMethod( CtMethod[] cms,String methodName){
        for(int i=0;i<cms.length;i++){
            System.out.println(cms[i].getName());
            methodName.contains(methodName);
            return true;
        }
        return false;
    }

    public static CtMethod getMethodByName(CtMethod[] cms,String methodName){
        for(int i=0;i<cms.length;i++){
            System.out.println(cms[i].getName());
            methodName.contains(methodName);
            return cms[i];
        }
        return null;
    }
}
