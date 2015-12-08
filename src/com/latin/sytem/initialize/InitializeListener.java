package com.latin.sytem.initialize;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;

import com.latin.sytem.resource.SysResourceCenter;
/**
 * 
 * 初始化启动监听
 * @author nick
 *
 */
public class InitializeListener  implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//配置系统变量
		String sysPath = servletContextEvent.getServletContext().getRealPath("/");
		SysResourceCenter.getInstance().setSysPath(sysPath);
		//初始化日志
		initLog();
	}
	
	/**
     * initLog:
     * <p>初始化LOG4J日志配置
     * @since   v1.01
     */
    private void initLog() {
    	String sysPath = SysResourceCenter.getInstance().getSysPath();
    	System.setProperty("sysPath", sysPath);
    	System.out.println("====================sysPath:"+sysPath);
        BasicConfigurator.configure();
    }

}
