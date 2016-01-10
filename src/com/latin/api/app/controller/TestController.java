package com.latin.api.app.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Testcontroller
 * 
 * @author NICK
 * @version 1.0
 * @Date 2016/01/10
 */
@Controller
@RequestMapping("/test")
public class TestController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String Test() {
		Resource res2 = new ClassPathResource("WEB-INF/log4j.properties");
		try {
			InputStream ins2 = res2.getInputStream();
			System.out.println("-------------->"+res2.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return "";
	}
	
}
