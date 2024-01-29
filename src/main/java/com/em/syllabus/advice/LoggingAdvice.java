package com.em.syllabus.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import static com.em.syllabus.constants.Constants.FIVE_DAYS_TIME;

@Aspect
@Component
public class LoggingAdvice {

    private static long creationTimeCl = 0;
    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution(* com.em.syllabus.controller.*.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
                + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info(methodName + "()" + "  Response : "
                + mapper.writeValueAsString(object));
        try (FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.write(className + " : " + methodName + "()" + "  Response : "
                    + mapper.writeValueAsString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
        deleteOldRecords();
        return object;
    }

    private void deleteOldRecords() {
        try {

            Path logFilePath = Paths.get("log.txt");
            if (Files.exists(logFilePath)) {
                BasicFileAttributes attributes = Files.readAttributes(logFilePath, BasicFileAttributes.class);
                FileTime creationTime = attributes.creationTime();
                long creationTimeInMillis = creationTime.toMillis();
                if(creationTimeCl == 0L){
                    creationTimeCl = creationTimeInMillis;
                }
                long fiveDaysAgoMillis = System.currentTimeMillis() - (FIVE_DAYS_TIME);
                if (creationTimeCl < fiveDaysAgoMillis) {
                    Files.delete(logFilePath);
                    creationTimeCl = 0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
//5*24*60*