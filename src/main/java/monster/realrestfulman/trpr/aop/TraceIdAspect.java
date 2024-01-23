package monster.realrestfulman.trpr.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Aspect
@Component
@Slf4j
public class TraceIdAspect {

    @Pointcut("@annotation(monster.realrestfulman.trpr.aop.TraceIdAnnotation)")
    public void traceIdInterceptorPointcut() {
    }

    @Around("traceIdInterceptorPointcut()")
    public Object addTraceId(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof HashMap) {
                HashMap<String, String> dataMap = (HashMap<String, String>) arg;
                log.info(dataMap.toString());
                MDC.put("TRACE_ID", dataMap.get("TRACE_ID"));
            }
        }

        return joinPoint.proceed();
    }
}

