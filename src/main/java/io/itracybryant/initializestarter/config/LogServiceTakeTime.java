package io.itracybryant.initializestarter.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogServiceTakeTime
 * @Description Service方法的执行时间统计
 * @Author Administrator
 * @Date 2018/12/29 20:13
 * @Version 1.0
 */
@Aspect
@Component
public class LogServiceTakeTime {
    final static Logger logger = LoggerFactory.getLogger(LogServiceTakeTime.class);

    @Pointcut("execution(* io.itracybryant.initializestarter.service..*.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object doLog(ProceedingJoinPoint pjp) throws Throwable {
        //记录起始时间
        long begin = System.currentTimeMillis();
        Object result = "";
        // 执行目标方法
        try {
            result = pjp.proceed();
        } catch (Exception e) {
            logger.error("日志记录出现错误, errorMessage: {}", e.getMessage());
        } finally {
            // 记录操作时间
            long task = (System.currentTimeMillis() - begin) / 1000;
            if (task >= 10) {
                logger.error("Service 执行时间：{}秒", task);
            } else if (task >= 5) {
                logger.warn("Service 执行时间：{}秒", task);
            } else if (task >= 2) {
                logger.info("Service 执行时间：{}秒", task);
            }
        }
        return result;
    }

    @Before("performance()")
    public void doBefore(JoinPoint jp) throws Throwable {
        // 接收到Advise(横切点)请求，记录请求内容
        logger.info("doBefore");
    }

    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("doAfterReturning");
    }
}
