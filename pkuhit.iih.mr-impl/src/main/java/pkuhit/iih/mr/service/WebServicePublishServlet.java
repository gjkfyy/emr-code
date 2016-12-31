package pkuhit.iih.mr.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.mr.wr.IEMRWebServiceImpl;
import xap.sv.app.Application;
import xap.sv.bundle.XapBundleContext;

public class WebServicePublishServlet extends HttpServlet {
	private Logger log = LoggerFactory.getLogger(WebServicePublishServlet.class);
	public void init() throws ServletException {
		super.init();
		String ip=null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!StringUtils.isBlank(ip)){
			String addrIEMR="http://"+ip+":1518/MRWebService";
			Application app = xap.sv.app.Application.getInstance();
			XapBundleContext context = app.getBundleContext();
			IEMRWebServiceImpl iEMRWebServiceImpl= context.getServiceOfType(pkuhit.iih.mr.wr.IEMRWebServiceImpl.class);
			Endpoint.publish(addrIEMR, iEMRWebServiceImpl);
			log.debug("发布IEMRwebservice成功!URL="+addrIEMR);
		}else{
			log.debug("获取ip地址失败，发布webservice失败!");
		}
	}
	
}