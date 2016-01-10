package com.latin.test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Test1 {

	public static void main(String[] args) {
		String filePath = "D:\\git_space\\wu6660563\\timertask\\WebRoot\\jsptest\\add.jsp";
		Resource res1 = new FileSystemResource(filePath); 
		// ② 使用类路径方式加载文件
		Resource res2 = new ClassPathResource("jsptest/add.jsp"); 
		try {
			InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream(); 
			System.out.println("res1:"+res1.getFilename()); 
			System.out.println("res2:"+res2.getFilename()); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
