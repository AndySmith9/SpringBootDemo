package com.andy.main.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.andy.main.exception.ParamException;

@Component
public class SpringExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = null;
		if(ex instanceof ParamException) {
			String message = ex.getMessage();
			JsonData jsonData = JsonData.fail(message);
			modelAndView = new ModelAndView(new MappingJackson2JsonView(),jsonData.toMap());
		}

		
		return modelAndView;
	}

}
