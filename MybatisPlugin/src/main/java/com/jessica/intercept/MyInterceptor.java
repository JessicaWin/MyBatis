package com.jessica.intercept;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import java.util.Properties;

@Intercepts({
        @Signature(method = "query", type = Executor.class, args = {
                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
        })
})
public class MyInterceptor implements Interceptor {
    private Logger logger= Logger.getLogger(MyInterceptor.class);
    /*
    * Invocation{代理对象，被监控的方法对象，当前被监控方法运行时需要的实参}
    * */
    public Object intercept(Invocation invocation) throws Throwable {
        logger.debug("before proceed");
        Object result = invocation.proceed();
        logger.debug("Invocation.proceed()");
        logger.debug("after proceed");
        return result;
    }

    /*
    * target: 被拦截的对象，是Executor的实例
    * 目的：为target对象生成一个代理对象【$proxy】
    * */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
