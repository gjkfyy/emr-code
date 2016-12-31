package iih.dr.util;

import iih.dr.model.MrDocTreeBean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class AnalyticXmlUtil {
	
	public static String getElementTextByXpath(String xmlStr, String xpathStr) throws Exception{
		// 创建Document对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream strm = new ByteArrayInputStream(xmlStr.getBytes());
        InputSource source = new InputSource(strm);
		org.w3c.dom.Document doc = db.parse(source);
		// 创建XPath对象
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		String xpathArr[] = xpathStr.split("\\."); //去掉路径中的“.x”
		NodeList nodeList = (NodeList) xpath.evaluate("/"+xpathArr[0]+"/@display-value", doc, XPathConstants.NODESET);
		String textContent = "";
		if(nodeList!=null && nodeList.getLength()>0){
			textContent = nodeList.item(0).getTextContent();
		}
		return textContent;
	}
	
	public static List<Map<String, Object>> getContentByXpath(String xmlStr, String xpathStr) throws Exception{
		// 创建Document对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(new FileInputStream(new File(xmlStr)));
		// 创建XPath对象
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		NodeList nodeList = (NodeList) xpath.evaluate(xpathStr, doc, XPathConstants.NODESET);
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>(); 
		for (int i = 0; i < nodeList.getLength(); i++) {
			if(null != nodeList.item(i)){
				int j = nodeList.item(i).getAttributes().getLength()-2;
				if(j>0){
					String elemType = nodeList.item(i).getAttributes().item(j).getNodeValue();
					Map map = new HashMap();
					if("Section".equals(elemType) || "Combine".equals(elemType) || "Table".equals(elemType)){
						map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getAttributes().item(0).getNodeValue());
					}
					if(!"Section".equals(elemType) && !"Combine".equals(elemType) && !"Table".equals(elemType) && !"FreeText".equals(elemType) && !"Label".equals(elemType)){
						map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getAttributes().item(3).getNodeValue());
					}
					if(!map.isEmpty()){
						listMap.add(map);
					}
				}
			}
		}
		return listMap;
	}
	
	public static ArrayList<MrDocTreeBean> getMrTree(String xmlStr, String mrPk, String docType) throws DocumentException{
		ArrayList<MrDocTreeBean> listBean = new ArrayList<MrDocTreeBean>();
		SAXReader saxReader = new SAXReader();
		Document docx= (Document) saxReader.read(new StringReader(xmlStr));
		Element rootElem = docx.getRootElement(); //根节点<data-record>
		List<?> listOne = rootElem.elements();
		Element bodyElem = (Element) listOne.get(0);//正文<body>
		List<?> listBody = bodyElem.elements();// <segment><group><element>
		StringBuilder elemPath = new StringBuilder(); //元素路径
		for (int i = 0; i < listBody.size(); i++) { //开始解析文档
			Element elemOne = (Element) listBody.get(i);
			if ("segment".equals(elemOne.getName())) {//解析中碰到<segment>
				MrDocTreeBean segmTree = new MrDocTreeBean();
				elemPath.delete(0, elemPath.length());
				String nameStr = elemOne.attributeValue("name").trim().contains("/")?elemOne.attributeValue("name").trim().replace("/", "~"):elemOne.attributeValue("name").trim();	
				elemPath.append("/segment[@name='"+nameStr+"']");//segment path
				segmTree.setDocType(docType);
				segmTree.setMrPk(mrPk);
				segmTree.setSegmType(elemOne.attributeValue("type"));
				segmTree.setSegmName(elemOne.attributeValue("name"));
				segmTree.setElemPath(elemPath.toString());
//				segmTree.setId(UUIDGenerator.getUUID());
//				segmTree.setText(elemOne.attributeValue("name"));
//				segmTree.setLeaf(Boolean.FALSE);
//				segmTree.setExpanded(Boolean.TRUE);
				segmTree.setNodeType("segment");
				listBean.add(segmTree);
				//调用递归方法
				getChildTree(elemOne, segmTree, null, listBean);
			}
		}
		return listBean;
	}
	
	public static void getChildTree(Element ele, MrDocTreeBean segmTree,MrDocTreeBean groupTree, ArrayList<MrDocTreeBean> listBean){
		List<?> list = ele.elements();
		StringBuilder elemPath = new StringBuilder(); //元素路径
		if(null!=groupTree){
			elemPath.append(groupTree.getElemPath());
		}else if(null!=segmTree){
			elemPath.append(segmTree.getElemPath());
		}
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Element e = (Element) list.get(i);
				MrDocTreeBean elemBean=new MrDocTreeBean();
				if ("element".equals(e.getName())) {//<element>代表元素
					int pathS = elemPath.length();
					if(!"FreeText".equals(e.attributeValue("type")==null?"":e.attributeValue("type").trim())&&!"Label".equals(e.attributeValue("type")==null?"":e.attributeValue("type").trim())){
						String nameStr = e.attributeValue("name").trim().contains("/")?e.attributeValue("name").trim().replace("/", "~"):e.attributeValue("name").trim();	
						elemPath.append("/element[@name='"+nameStr+"']."+i);//element path
						elemBean.setDocType(segmTree.getDocType());
						elemBean.setMrPk(segmTree.getMrPk());
						elemBean.setSegmType(segmTree.getSegmType());
						elemBean.setSegmName(segmTree.getSegmName());
						if(null!=groupTree){
							elemBean.setGroupName(groupTree.getGroupName());
							elemBean.setGroupType(groupTree.getGroupType());
						}
						elemBean.setElemDisplayValue(e.attribute("display-value").getText());
						elemBean.setElemType(e.attributeValue("type")==null?"":e.attribute("type").getText());
						elemBean.setElemName(e.attribute("name").getText());
						elemBean.setElemPath(elemPath.toString());
						elemBean.setNodeType("element");
						elemBean.setIsLeaf(1);
//						elemBean.setId(UUIDGenerator.getUUID());
//						elemBean.setText(e.attributeValue("name"));
//						elemBean.setLeaf(Boolean.TRUE);
//						elemBean.setExpanded(Boolean.FALSE);
						listBean.add(elemBean);
						int pathE = elemPath.length();
						elemPath.delete(pathS, pathE);
					}
				}
				if ("group".equals(e.getName())) {//<group>代表组合元素
					int pathS = elemPath.length();
					MrDocTreeBean groupBean=new MrDocTreeBean();
					String nameStr = e.attributeValue("name").trim().contains("/")?e.attributeValue("name").trim().replace("/", "~"):e.attributeValue("name").trim();	
					elemPath.append("/group[@name='"+nameStr+"']");//element path
					groupBean.setDocType(segmTree.getDocType());
					groupBean.setMrPk(segmTree.getMrPk());
					groupBean.setSegmType(segmTree.getSegmType());
					groupBean.setSegmName(segmTree.getSegmName());
					groupBean.setGroupName(e.attribute("name").getText());
					groupBean.setGroupType(e.attribute("type")==null?"":e.attribute("type").getText());
					groupBean.setElemPath(elemPath.toString());
					groupBean.setNodeType("group");
					groupBean.setIsLeaf(0);
//					groupBean.setId(UUIDGenerator.getUUID());
//					groupBean.setText(e.attributeValue("name"));
//					groupBean.setLeaf(Boolean.FALSE);
//					groupBean.setExpanded(Boolean.TRUE);
					listBean.add(groupBean);
					int pathE = elemPath.length();
					elemPath.delete(pathS, pathE);
					getChildTree(e, segmTree, groupBean, listBean);
				}
				if ("segment".equals(e.getName())) {//<segment>代表段落
					int pathS = elemPath.length();
					MrDocTreeBean segmentBean=new MrDocTreeBean();
					String nameStr = e.attributeValue("name").trim().contains("/")?e.attributeValue("name").trim().replace("/", "~"):e.attributeValue("name").trim();	
					elemPath.append("/segment[@name='"+nameStr+"']");//segment path
					segmentBean.setSegmType(e.attributeValue("type").trim());//segment type
					segmentBean.setSegmName(e.attributeValue("name").trim());//segment name
					segmentBean.setDocType(segmTree.getDocType());
					segmentBean.setMrPk(segmTree.getMrPk());
					segmentBean.setElemPath(elemPath.toString());
					segmentBean.setNodeType("segment");
					segmentBean.setIsLeaf(0);
//					segmentBean.setId(UUIDGenerator.getUUID());
//					segmentBean.setText(e.attributeValue("name"));
//					segmentBean.setLeaf(Boolean.FALSE);
//					segmentBean.setExpanded(Boolean.TRUE);
					listBean.add(segmentBean);
					int pathE = elemPath.length();
					elemPath.delete(pathS, pathE);
					getChildTree(e, segmentBean, null, listBean);
				}
			}
		}
	}
	
	/**
     * 以行为单位读取文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
            	sb.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            return sb.toString();
        }
    }
	
}
