package com.exception;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



//import com.capg.bean.ExceptionBean;

//global exception handling class

@ControllerAdvice
public class GlobalException {
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value={Exception.class})
	public ExceptionBean errorHandler(Exception exception,HttpServletRequest req) {
		String httpreq = exception.getMessage();
		String uri = req.getRequestURL().toString();
		return new ExceptionBean(uri, httpreq);
}
}