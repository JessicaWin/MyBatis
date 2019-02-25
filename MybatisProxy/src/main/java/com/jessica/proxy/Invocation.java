package com.jessica.proxy;

import com.jessica.dao.BasicService;
import com.jessica.dao.ExtraService;
import com.jessica.dao.impl.WashHandService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invocation implements InvocationHandler {
    private  BasicService basicService;
    public Invocation(BasicService service) {
        this.basicService = service;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ExtraService washHandService = new WashHandService();
        Object value;
        if ("eat".equals(method.getName())) {
            washHandService.wash();
            value = method.invoke(basicService, args);
        } else {
            value = method.invoke(basicService, args);
            washHandService.wash();
        }
        return  value;
    }
}
