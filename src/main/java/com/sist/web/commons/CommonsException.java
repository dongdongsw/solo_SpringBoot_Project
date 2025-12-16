package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {

	@ExceptionHandler(Exception.class)
	public void exceptioon(Exception ex) {
		System.out.println("============================= Exception Error ==============================");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) {
		System.out.println("============================= Exception Error ==============================");
		ex.printStackTrace();
	}
}
