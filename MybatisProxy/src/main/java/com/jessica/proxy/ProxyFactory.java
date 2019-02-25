package com.jessica.proxy;

import com.jessica.dao.BasicService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static BasicService create(Class clz) throws  Exception{
        BasicService basicService = (BasicService) clz.newInstance();
        InvocationHandler invocationHandler = new Invocation(basicService);
        BasicService proxy = (BasicService) Proxy.newProxyInstance(basicService.getClass().getClassLoader(), basicService.getClass().getInterfaces(),invocationHandler);
        return proxy;
    }
}
