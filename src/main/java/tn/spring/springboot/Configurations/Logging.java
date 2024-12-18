package tn.spring.springboot.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging and performance monitoring.
 */
@Component
@Aspect
@Slf4j
public class Logging {

    /**
     afficher le message de log suivant « méthode exécutée »
     dans la console après l’exécution des méthodes de la couche service qui commencent
     par add..
     */
    @After("execution(* tn.spring.springboot.Services.Implementation.*.add*(..))")
    public void logControllerMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.debug("Entering method: " + methodName);
        log.info("méthode exécutée!");
    }
}
