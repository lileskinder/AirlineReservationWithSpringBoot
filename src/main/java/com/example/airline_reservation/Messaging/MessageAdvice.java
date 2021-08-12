package com.example.airline_reservation.Messaging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MessageAdvice {

    @After("execution(* com.example.airline_reservation.Service.ReservationService.makeReservation(..))")
    public void afterSendMail(JoinPoint joinPoint) {


        System.out.println("send email for making reservation");
    }
}