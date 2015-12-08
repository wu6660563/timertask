package com.latin.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author nick
 */
@Component("applicationContextFactory")
public class ApplicationContextFactory implements ApplicationContextAware {

	private static ApplicationContext appContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;
	}

	public static ApplicationContext getAppContext() {
		return appContext;
	}

	public static Object getBean(String beanId) {
		return appContext.getBean(beanId);
	}
}
