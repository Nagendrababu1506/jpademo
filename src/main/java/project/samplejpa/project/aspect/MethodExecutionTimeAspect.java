package project.samplejpa.project.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MethodExecutionTimeAspect {

    private final ThreadLocal<StopWatch> stopWatchThreadLocal = ThreadLocal.withInitial(StopWatch::new);
    private final Logger logger = LoggerFactory.getLogger(MethodExecutionTimeAspect.class);
    @Before("execution(* project.samplejpa.project.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.start();
    }

    @After("execution(* project.samplejpa.project.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();
        //System.out.println("Method " + joinPoint.getSignature().toShortString() + " executed in " + stopWatch.getTotalTimeMillis() + " ms");
        logger.info("Method {} executed in {} ms", joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());
        stopWatchThreadLocal.remove();
    }
}
