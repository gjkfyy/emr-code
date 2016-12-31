package ei.ris.util;

import java.io.StringReader;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 解析检查印象xml
 */
public class AnalyticObsContent {
	public String getObImprContent(String xmlStr) throws DocumentException{
		SAXReader saxReader = new SAXReader();
		Document docx= (Document) saxReader.read(new StringReader(xmlStr));
		Element rootElem = docx.getRootElement(); //<sections>
		List<?> listOnex = rootElem.elements();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<listOnex.size();i++){
			Element eleOne = (Element) listOnex.get(i);//<section>
			List<?> listOnec = eleOne.elements();
			for(int j=0;j<listOnec.size();j++){
				Element elemTitle = (Element) listOnec.get(j);//<title>/<content>
				sb.append(elemTitle.getTextTrim()+"\r\n");
			}
		}
		return sb.toString();
	}
	public static void main(String args[]){
		String xmlStr2 = "<?xml version='1.0' encoding='utf-16'?><sections><section><title>超声所见:</title><content>经腹部扫查：子宫前位，体积增大，宫体大小约cm譪m譪m，形态正常，肌壁光点回声增粗，分布欠均匀，宫腔内未见明显异常回声团块。 双附件区未见异常回声。 ：上述脏器未见明显异常血流信号。</content></section><section> <title>超声提示:</title><content>1. 产后子宫声像. 双侧附件未见明显异常</content></section></sections>";
//		String xmlStr = "<?xml version='1.0' encoding='utf-16'?><sections><section><title>aaa</title><content>bbb</content></section></sections>";
		AnalyticObsContent c = new AnalyticObsContent();
		//String con="";
		String con2="";
		try {
			//con = c.getObImprContent(xmlStr);
			con2 = c.getObImprContent(xmlStr2);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		//System.out.println(con);
		//System.out.println("---------------");
		System.out.println(con2);
	}
}

