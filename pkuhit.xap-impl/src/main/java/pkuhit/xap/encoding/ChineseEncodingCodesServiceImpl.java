package pkuhit.xap.encoding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import xap.sv.component.LifeCycleComponent;
import xap.sv.util.Ordered;

public class ChineseEncodingCodesServiceImpl implements
		ChineseEncodingCodesService , LifeCycleComponent, Ordered{
	
	@Autowired
	ChineseEncodingCodesDao	chineseEncodingCodesDao;

	@Override
	public Map<Character, String> getChineseEncodingCodes() {
		// TODO Auto-generated method stub
		return chineseEncodingCodesDao.getChineseEncodingCodes();
	}
	
	private Map<Character, String> read(){
		Map<Character, String> spellCode = new HashMap<Character, String>();
		SAXReader reader = new SAXReader();
        Document doc = null;
		try {
			doc = reader.read(this.getClass().getResource(
			        "/CodeConfig.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 获取根节点
        Element rootEle = doc.getRootElement();
        Element pyEle = rootEle.element("SpellCode");
        List<Element> pyEles = pyEle.elements();
        for (Element ele : pyEles)
        {
            spellCode.put(ele.getName().charAt(0), ele.getText());
        }
        return spellCode;
	}
	
	private void initChineseEncodingCodes(){
		Map<Character, String> map = read();
		chineseEncodingCodesDao.saveChineseEncodingCodes(map);
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		initChineseEncodingCodes();
	}

	@Override
	public void onDestory() {
		// TODO Auto-generated method stub
		
	}

}
