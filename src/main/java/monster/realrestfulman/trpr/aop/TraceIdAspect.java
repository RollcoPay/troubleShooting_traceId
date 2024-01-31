package monster.realrestfulman.trpr.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
                @SuppressWarnings("unchecked")
                HashMap<String, String> paramMap = (HashMap<String, String>) arg;

                if (paramMap.containsKey("TRACE_ID")) {
                    String traceId = paramMap.get("TRACE_ID");
                    MDC.put("TRACE_ID", traceId);
                    log.info("Added traceId to MDC: {}", traceId);
                }
            }
        }
            return joinPoint.proceed();
        }

}
