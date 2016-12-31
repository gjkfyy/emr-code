package iih.dr.util;

import iih.dr.model.MrDocTreeBean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.dom4j.DocumentException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class AnalyticXmlTest {
	public static void main(String args[]){
		/*if( (true)  ||  (true) ||  (true) ){
			System.out.println("abc");
		}
		System.out.println(1&0);
		System.out.println(true && false);
		System.out.println(1&1);
		System.out.println(true && true);
		System.out.println("~~~");
		System.out.println(1|0);
		System.out.println(true || false);
		System.out.println(1|1);
		System.out.println(true || true);*/
		/*
		ScriptEngineManager manager = new ScriptEngineManager();  
		String expr = "true&&true&&true&&false";  
		 ScriptEngine engine = manager.getEngineByName("js");  
         Object result;
		try {
			result = engine.eval(expr);
	         System.out.println(result);  
		} catch (ScriptException e) {
			e.printStackTrace();
		}  */
		
		AnalyticXmlUtil c = new AnalyticXmlUtil();
//		String xmlStr1 = c.readFileByLines("src/main/java/iih/dr/util/0001248407_2700927_585DBA89E52A43F680D29F067591CA91.xml");
//		String xmlStr = c.readFileByLines("src/main/java/iih/dr/util/ruyuanjilu.xml");
		String xmlStr = c.readFileByLines("src/main/java/iih/dr/util/123.xml");
		ArrayList<MrDocTreeBean> listBean = new ArrayList<MrDocTreeBean>();
//		ArrayList<MrDocTreeBean> listBean1 = new ArrayList<MrDocTreeBean>();
		try {
			listBean = c.getMrTree(xmlStr, "", "");
//			listBean1 = c.getMrTree(xmlStr1, "", "");
			for(int i=0;i<listBean.size();i++){
				System.out.println(listBean.get(i).getElemPath()+"      "+listBean.get(i).getElemType()+"      "+listBean.get(i).getElemName());
			}
//			for(int i=0;i<listBean1.size();i++){
//				System.out.println(listBean1.get(i).getElemPath());
//			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		/*List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		try {
			// 创建Document对象
			AnalyticXmlUtil c = new AnalyticXmlUtil();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			DocumentBuilder db = dbf.newDocumentBuilder();
			String xmlStr = c.readFileByLines("src/main/java/iih/dr/util/ruyuanjilu.xml");
			InputStream strm = new ByteArrayInputStream(xmlStr.getBytes());
	        InputSource source = new InputSource(strm);
			Document doc = db.parse(source);
			// 创建XPath对象
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			
			NodeList nodeList = (NodeList) xpath.evaluate("//segment[@name='家族史']/element[@name='有无传染病家族史']/@display-value", doc, XPathConstants.NODESET);
//			NodeList nodeList = (NodeList) xpath.evaluate("//segment[@name='既往史']/element[@name='既往体质']/@display-value", doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println(nodeList.item(i).getNodeName() + "-->" + nodeList.item(i).getTextContent());
			}
			
			listMap = c.getContentByXpath("src/main/java/iih/dr/util/ruyuanjilu.xml", "/data-record/body/segment/element/@date");
			for(int i=0;i<listMap.size();i++){
				System.out.println(listMap.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
//		System.out.println("aa??? bb".replaceAll("\\?\\?\\? ", ""));
		
		/*final int LEN = 10;
		int number = 89, lowValue=0, highValue=0;
		int level = number%LEN>0?(number/LEN+1):number/LEN;
		for(int i=0;i<level;i++){
			if(number%LEN>0 && i==(level-1)){
				lowValue = (level-1)==0?i*LEN:(i*LEN+1);
				highValue = number;
			}else {
				lowValue = i==0?i*LEN:(i*LEN+1);
				highValue = (level-1)==0?number:(i+1)*LEN;
			}
			System.out.println(lowValue+", "+highValue);
			for(int j=0;j<LEN;j++){
				//List  [lowValue]~[highValue]
			}
		}*/
		
	}
}
