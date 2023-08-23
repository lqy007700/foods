package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class ServiceLogAspect {

    public static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * AOP
     * 1. 前置 方法调用前
     * 2. 后置 方法正常调用后
     * 3. 环绕 方法调用前和调用后
     * 4. 异常 方法调用过程中出现异常
     * 5. 最终 方法调用结束后
     */
//    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("========开始 {}.{} =======",
                joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());


        long begin = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        long t = end - begin;

        if (t > 3000) {
            log.error("超过300毫秒");
        }
        log.info("=======执行结束，耗时{}毫秒=======", t);
        return proceed;
    }
}