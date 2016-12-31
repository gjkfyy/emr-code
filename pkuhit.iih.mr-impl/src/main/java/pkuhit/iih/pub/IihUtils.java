/**
 * <p>文件名:		IihUtils.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.pub;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;


import pkuhit.iih.mr.wr.MrSplFmValue;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectService;
import pkuhit.org.Organization;
import pkuhit.xap.ac.User;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;

/**
 * <p>
 * IihUtils
 * </p>
 * <p>
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年12月15日 上午10:33:03</td>
 *          </tr>
 *          <tr>
 *          </tr>
 *          </table>
 */
public class IihUtils {

	private static Logger log = LoggerFactory.getLogger(IihUtils.class);
	/**
	 * 构造器
	 */
	public IihUtils() {
	}

	/**
	 * 计算日期，系统时间 + days（天数）
	 * 
	 * @param days
	 *            天
	 * @return
	 */
	public static Date dateIncrease(int days) {
		return new Date(System.currentTimeMillis() + days * 24 * 3600 * 1000);
	}

	/**
	 * 计算日期，系统时间 + days（天数）
	 * 
	 * @param days
	 *            天
	 * @return
	 */
	public static Date dateIncrease(Date currentDate, int days) {
		return new Date(currentDate.getTime() + days * 24 * 3600 * 1000);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 
	 * 用户名转用户名称
	 * 
	 * @param dataObjectService
	 * @param userId
	 * @return
	 */
	public static String userIdToName(DataObjectService dataObjectService,
			String userId) {
		if (null != userId && null != dataObjectService) {
			DataObject dataObject = dataObjectService.getObject(User.OBJ_CD,
					userId);
			if (null != dataObject) {
				return dataObject.getObject(User.class).getName();
			}
		}
		return "";
	}

	/**
	 * 
	 * 用户名转用户名称
	 * 
	 * @param dataObjectService
	 * @param userId
	 * @return
	 */
	public static String deptCodeToName(DataObjectService dataObjectService,
			String deptCode) {
		if (null != deptCode && null != dataObjectService) {
			DataObject dataObject = dataObjectService.getObject(
					Organization.OBJ_CD, deptCode);
			if (null != dataObject) {
				return dataObject.getObject(User.class).getName();
			}
		}
		return "";
	}

	/**
	 * 批量调用DataObjectService，获得DataObject的map
	 * 
	 * @param doService
	 * @param objCd
	 * @param pks
	 * @return Map&lt;pk, DataObject&gt;
	 */
	public static Map<String, DataObject> getDataObjects(
			DataObjectService doService, String objCd, List<String> pks) {
		Map<String, DataObject> map = new LinkedHashMap<String, DataObject>();
		DataObject[] objects = doService.getObjects(objCd,
				pks.toArray(new String[pks.size()]));
		for (DataObject data : objects) {
			map.put(data.getId(), data);
		}
		return map;
	}

	/**
	 * 批量调用DataObjectService，获得具体Model的map，效率比{@link pkuhit.iih.pub.IihUtils#getDataObjects}要低
	 * 
	 * @param doService
	 * @param objCd
	 * @param pks
	 * @return Map&lt;pk, Model&gt;
	 */
	public static <T> Map<String, T> getModels(DataObjectService doService,
			String objCd, List<String> pks, Class<? extends T> T) {
		Map<String, T> map = new LinkedHashMap<String, T>();
		DataObject[] objects = doService.getObjects(objCd,
				pks.toArray(new String[pks.size()]));
		for (DataObject data : objects) {
			T object = data.getObject(T);
			map.put(data.getId(), object);
		}
		return map;
	}

    /**
     * 把一个 0~9999 之间的整数转换为汉字的字符串，如果是 0 则返回 ""
     * @param amountPart
     * @return
     */
    public static String partTranslate(int amountPart) {
    	String[] chineseDigits = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        if(amountPart < 0 || amountPart > 10000) {
            throw new IllegalArgumentException("参数必须是大于等于 0，小于 10000 的整数！");
        }


        String[] units = new String[] {"", "十", "百", "千"};

        int temp = amountPart;

        String amountStr = new Integer(amountPart).toString();
        int amountStrLength = amountStr.length();
        boolean lastIsZero = true; //在从低位往高位循环时，记录上一位数字是不是 0
        String chineseStr = "";

        for(int i=0; i<amountStrLength; i++) {
            if(temp == 0)  // 高位已无数据
                break;
            int digit = temp % 10;
            if(digit == 0) { // 取到的数字为 0
                if(!lastIsZero)  //前一个数字不是 0，则在当前汉字串前加“零”字;
                    chineseStr = "零" + chineseStr;
                lastIsZero = true;
            }
            else { // 取到的数字不是 0
                chineseStr = chineseDigits[digit] + units[i] + chineseStr;
                lastIsZero = false;
            }
            temp = temp / 10;
        }
        return chineseStr;
    }
    
	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}
	
	public static  String xmlStringReader(String s, String name,Integer regionAnalyticMethod) {
		// 创建一个新的字符串
		StringReader read = new StringReader(s);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder saxbBuilder = new SAXBuilder();
		StringBuffer sbBuffer = new StringBuffer();
		try {
			// 通过输入源构造一个Document
			Document doc = saxbBuilder.build(source);
			// 取的根元素
			Element root = doc.getRootElement();
			// System.out.println(root.getName());
			List<?> node = root.getChildren();
			for (int i = 0; i < node.size(); i++) {
				Element element = (Element) node.get(i);
				// System.out.println(element.getName());//body
				if(regionAnalyticMethod==null||regionAnalyticMethod==0){
					getNodeValues(sbBuffer, element, name);
				}else{//无区域内容解析
					nonRegionIdentContent(name, sbBuffer, element);
				}
			}
			return sbBuffer.toString();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void nonRegionIdentContent(String name, StringBuffer sbBuffer, Element element) {
		List<?> nodes = element.getChildren();
		if(nodes!=null&&nodes.size()>0)
		for (Object object : nodes) {
			Element elementO = (Element) object;
			if(elementO.getAttributeValue("name")!=null&&elementO.getAttributeValue("name").equals(name)){
				//按区域解析
				if(elementO.getAttributeValue("type")!=null&&elementO.getAttributeValue("type").equals("Section")){
					segmentOrGroupValue(sbBuffer,elementO,name);
				}else{
					sbBuffer.append(elementO.getAttributeValue("display-value") == null ? "" : elementO.getAttributeValue("display-value"));
					nodeChildrenContent(sbBuffer, elementO);
				}
				break;
			}else{
				List<?> node = elementO.getChildren();
				if(node!=null&&node.size()>0){
					nonRegionIdentContent(name,sbBuffer,elementO);
				}
			}
		}
	}

	private static void nodeChildrenContent(StringBuffer sbBuffer, Element elementO) {
		List<?> nodeL =elementO.getChildren();
		if(nodeL!=null&&nodeL.size()>0){
			for (Object objectO : nodeL) {
				Element elementT = (Element) objectO;
				sbBuffer.append(elementT.getAttributeValue("display-value") == null ? "" : elementT.getAttributeValue("display-value"));						
				nodeChildrenContent(sbBuffer, elementT);
			}
		}
	}
	
	public static  void getNodeValues(StringBuffer sbBuffer, Element element, String name) {
		List<?> subNode = element.getChildren();
		if(subNode!=null&&subNode.size()>0)
		for (int j = 0; j < subNode.size(); j++) {
			Element subElement = (Element) subNode.get(j);
			// System.out.println(subElement.getName());
			if (!StringUtils.isBlank(name)) {// 返回指定name值
				selectNodes(sbBuffer, subElement, name);
			} else {// 返回所有display-value值
				List<?> nodes=subElement.getChildren();
				if (nodes!=null&&nodes.size()>0) {
					//if(subElement.getName().equals("group")||subElement.getName().equals("segment")){
					segmentOrGroupValue(sbBuffer, subElement, name);
				}else {
					sbBuffer.append(subElement.getAttributeValue("display-value")==null?"":subElement.getAttributeValue("display-value"));
				}
			}
		}
	}
	public static void getColumnISFromMap(List<String> column, Map<String, Object> maps, Document document,String[] totalScoreTbNms,String[] chDocFeatureTbNms) {
		Element root = document.getRootElement();
		List<?> node = root.getChildren();
		for (int i = 0; i < node.size(); i++) {
			Element element = (Element) node.get(i);
			List<?> nodeO = element.getChildren();
			// System.out.println(element.getName());//body
			for (int j = 0; j < nodeO.size(); j++) {
				Element elementO = (Element) nodeO.get(j);// segment
				String totalScoreTbName=checkTableName(elementO,totalScoreTbNms);
				String chDocFeatureTbNm=checkTableName(elementO,chDocFeatureTbNms);//Barther-TotalScoreTable
				if (elementO.getName().equals("segment") && elementO.getAttributeValue("type").equals("Table")
						&&(totalScoreTbName!=null||chDocFeatureTbNm!=null)) 
				{
					if(totalScoreTbName!=null&&totalScoreTbName.equalsIgnoreCase("Barther-TotalScoreTable")){
						Element elem = (Element) nodeO.get(1);
						List<?> nodeT = elem.getChildren();
						if(nodeT!=null&&nodeT.size()>0){
							Element barther = (Element) nodeT.get(1);//第二列
							if(barther!=null){
								String valString=barther.getAttributeValue("display-value");
								if(barther!=null&&!StringUtils.isBlank(valString)&&!valString.equals("0")){
									List<MrSplFmValue> list=new ArrayList<MrSplFmValue>();
									MrSplFmValue col = new MrSplFmValue();
									col.setKey("总评分");
									col.setFmName(totalScoreTbName.substring(0,totalScoreTbName.indexOf("-")));
									col.setValue(valString);
									col.setFmType(2);//评估总分
									list.add(col);
									maps.put("r" + 0,list);
									break;
								}
							}
						}
					}
					List<?> nodeT = elementO.getChildren();
					int count = 0;int check=0;
					for (int k = 0; k < nodeT.size(); k++) {// group
						Element elementTh = (Element) nodeT.get(k);
						List<?> nodeTh = elementTh.getChildren();
						count=0;
						check=0;
						List<MrSplFmValue> list = new ArrayList<MrSplFmValue>();
						for (int l = 0; l < nodeTh.size(); l++) {// element
							Element elementF = (Element) nodeTh.get(l);
							if (count == column.size()){
								continue;
								}
							if(StringUtils.isBlank(elementF.getAttributeValue("display-value"))||
									totalScoreTbName!=null&&elementF.getAttributeValue("name").equals("总评分")&&elementF.getAttributeValue("display-value").equals("0")){
								//System.out.println(elementF.getAttributeValue("display-value") );
								check++;
								continue;
							}
							if(elementF.getAttributeValue("name").equals("总评分")&&totalScoreTbName!=null){
								MrSplFmValue col = new MrSplFmValue();
								col.setKey("总评分");
								col.setFmName(totalScoreTbName.substring(0,totalScoreTbName.indexOf("-")));
								col.setValue(elementF.getAttributeValue("display-value"));
								col.setFmType(2);//评估总分
								list.add(col);
								break;
							}
							if(column!=null&&column.size()>0){
								for (String str : column) {
									if (elementF.getAttributeValue("name").equals(str)) {
										count++;
										MrSplFmValue col = new MrSplFmValue();
										col.setFmName(chDocFeatureTbNm.substring(0,chDocFeatureTbNm.indexOf("-")));
										col.setKey(elementF.getAttributeValue("name"));
										col.setValue(elementF.getAttributeValue("display-value"));
										col.setFmType(1);//中医特色内容
										list.add(col);
										continue;
									}
								}
							}
							
						}
						if(check>=nodeTh.size())break;
						if(list.size()>0)
						maps.put("r" + k, list);
					}
				}

			}
		}
	}
	private static String checkTableName(Element element, String[] tbs) {
		if(tbs!=null&&tbs.length>0)
		for (String string : tbs) {
			if(element!=null&&element.getAttributeValue("name")!=null&&element.getAttributeValue("name").equals(string)){
				return  element.getAttributeValue("name");
			}
		}
		return null;
	}

	public static void segmentOrGroupValue(StringBuffer sbBuffer, Element subElement, String name) {
		List<?> subNodes = subElement.getChildren();
		if(subNodes!=null&&subNodes.size()>0){
			Element sub = (Element) subNodes.get(0);
			String vn1 = sub.getAttributeValue("value");
			for (int k = 0; k < subNodes.size(); k++) {
				Element subNode = (Element) subNodes.get(k);
				List<?> nodes=subNode.getChildren();
				if (nodes!=null&&nodes.size()>0) {
				//if(subNode.getName().equals("group")||subNode.getName().equals("segment")){
					segmentOrGroupValue(sbBuffer, subNode, name);
				}else{
					if (vn1!=null&&vn1.equals("0")) {// 如果是0循环到2
						if (k < 2) {
							sbBuffer.append(subNode.getAttributeValue("display-value")==null?"":subNode.getAttributeValue("display-value"));
							getNodeValues(sbBuffer, subNode, name);
						} else {
							break;
						}
					} else {// 如果非0循环到底
						sbBuffer.append(subNode.getAttributeValue("display-value")==null?"":subNode.getAttributeValue("display-value"));
						getNodeValues(sbBuffer, subNode, name);
					}
				}
			}
		}
	}
	public static Document xmlConvertDom(String xml){
		Document doc=null;
		Reader in = new StringReader(xml);     
        try {
			doc = (new SAXBuilder()).build(in);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public static  void selectNodes(StringBuffer sbBuffer, Element subElement, String name) {
		List<?> subNodeSList = subElement.getChildren();
		if (subNodeSList.size() > 0) {
			if (!StringUtils.isBlank(name) && subElement.getAttributeValue("name").equals(name)) {
				Element subNodeS = (Element) subNodeSList.get(0);
				String vn1 = subNodeS.getAttributeValue("value");
				if(subNodeS.getName().equals("group")||subNodeS.getName().equals("segment")){
					segmentOrGroupValue(sbBuffer, subNodeS, name);
				}else{
					for (int k = 0; k < subNodeSList.size(); k++) {
						Element subNode = (Element) subNodeSList.get(k);
						if(subNode.getName().equals("group")||subNode.getName().equals("segment")){
							segmentOrGroupValue(sbBuffer, subNode, name);
						}else{
							if (vn1!=null&&vn1.equals("0")) {// 如果是0循环到2
								if (k < 2) {
									sbBuffer.append(subNode.getAttributeValue("display-value")==null?"":subNode.getAttributeValue("display-value"));
									getNodeValues(sbBuffer, subNode, name);
								} else {
									break;
								}
							} else {// 如果是1循环到底
								sbBuffer.append(subNode.getAttributeValue("display-value")==null?"":subNode.getAttributeValue("display-value"));
								getNodeValues(sbBuffer, subNode, name);
							}
						}
					}
				}
			}
		}
	}
	/***
	 * 更新xap_bizfile文件
	 * IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
	 * */
	public static String updateMrBizFile(String filePk,String Data,FileService fileService) {
		// TODO Auto-generated method stub
		FileObject fileObject = null;
		if (!StringUtils.isEmpty(filePk)) {
			fileObject = fileService.getFile(filePk);
		}
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(Data)) {
			try {
				if (fileObject != null) {
					fileObject = fileService.updateFile(fileObject.getId(),Data.getBytes());
					return null;
				} else {
					fileObject = fileService.createFile("biz", Data.getBytes());
					return fileObject.getId();
				}
			} catch (Exception e) {
				log.error("业务文件发生错误：FileObject filePk："+filePk+"-- data :" + Data + "错误信息如下：");
				e.printStackTrace();
			}
		}
		return null;
	}
}
