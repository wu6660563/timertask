package com.latin.api.app.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Testcontroller
 * 
 * @author NICK
 * @version 1.0
 * @Date 2016/01/10
 */
@Controller
@RequestMapping("/app")
public class TestController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "xxx");
		modelAndView.addObject("xxx", "xxxx");
		return modelAndView;
	}
	
}
