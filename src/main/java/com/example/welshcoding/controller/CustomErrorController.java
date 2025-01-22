package com.example.welshcoding.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.welshcoding.exception.TagNullException;

@Controller
public class CustomErrorController implements ErrorController{
	
	@RequestMapping(value = "/error")
    public String handleError(HttpServletResponse response, HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String msg = "";
        
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
            	msg = "페이지를 찾을 수 없습니다.";
            }
            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
            	msg = "처리 실패하였습니다.";
            }
        }
        model.addAttribute("msg", msg);
        return "/mainbody/error";
    }

}
