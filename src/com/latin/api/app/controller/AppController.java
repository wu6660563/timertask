package com.latin.api.app.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latin.api.app.common.IPUtils;
import com.latin.api.app.service.APPAPIService;
import com.latin.mail.util.MailUtil;

/**
 * APP接口统一入口
 * 
 * @author nick
 * @since 2015/09/09
 * @version v1.0
 * 
 */
@Controller
@RequestMapping("/app")
public class AppController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "appAPIService")
	public APPAPIService appAPIService;

	@Autowired
	public MailUtil mailUtil;

	public MailUtil getMailUtil() {
		return mailUtil;
	}

	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String Test() {
		String returnData = "我是中国人";
		System.out.println("test");
//		String[] reviceiver = {"null", "772531127@comprame.com","nick@comprame.com", "953374957@qq.com" };
//		for (int i = 0; i < reviceiver.length; i++) {
//			mailUtil.send(reviceiver[i], "<br>TEST<br><p><b>正在测试中文</b>",
//					"发送邮件测试");
//		}
		
		return returnData;
	}

	@RequestMapping(value = "/api", method = RequestMethod.POST)
	@ResponseBody
	public Object API(HttpServletRequest request, HttpServletResponse response) {
		String returnData = "";
		try {
			request.setCharacterEncoding("utf-8");

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			String ipaddress = IPUtils.getRequestIpAddr(request);
			System.out.println("来源请求的IP地址是：" + ipaddress);

			HashMap<String, String> requestHash = new HashMap<String, String>();
			requestHash.put("osType", request.getParameter("osType"));
			requestHash.put("apiId", request.getParameter("apiId"));
			requestHash.put("version", request.getParameter("version"));

			requestHash.put("phone", request.getParameter("phone"));
			requestHash.put("email", request.getParameter("email"));
			requestHash.put("user_name", request.getParameter("user_name"));
			requestHash.put("content", request.getParameter("content"));
			requestHash.put("customer_id", request.getParameter("customer_id"));
			requestHash.put("netflow_type",
					request.getParameter("netflow_type"));
			requestHash.put("version_number",
					request.getParameter("version_number"));

			// System.out.println(json);
			// JSONObject jsonObject = JSONObject.fromObject(requestHash);
			//
			// // 根据jsonObject分发不同的API的Service
			returnData = appAPIService.excute(requestHash);
			logger.info("返回数据：" + returnData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try {
		// PrintWriter printWriter = response.getWriter();
		// printWriter.print(returnData);
		// printWriter.flush();
		// printWriter.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return returnData;
	}

	public APPAPIService getAppAPIService() {
		return appAPIService;
	}

	public void setAppAPIService(APPAPIService appAPIService) {
		this.appAPIService = appAPIService;
	}

}
