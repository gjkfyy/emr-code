package ei.ass.or.zy.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.or.OrderModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.or.auto.po.OrderPo;
import ei.ass.or.zy.dao.ZyDirectOrderDao;
import ei.ass.or.zy.service.ZyDirectOrderService;

/**
 * @author guo_zhongbao
 * 医嘱视图
 */
public class ZyDirectOrderServiceImpl implements ZyDirectOrderService {
	 
	@Autowired
	ZyDirectOrderDao orderDao;
	
	public static String PORTAL_OUTP = "ENM01.01";
	public static String PORTAL_INP = "ENM01.04";
	
	/* (non-Javadoc)
	 * @see pkuhit.iih.or.OrderService#search(java.lang.String)
	 */
	@Override
	public SingleResult<OrderModel> search(String orPk) {
		OrderModel vo = null ;
		OrderPo po = orderDao.OrderDetailByOrderSn(orPk);
		SingleResultBuilder<OrderModel> builder = SingleResultBuilder.newSingleResult(OrderModel.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}
	
	/**  
     * 使用java正则表达式去掉多余的.与0  
     * @param s  
     * @return   
     */    
    public static String subZeroAndDot(String s){    
        if(s.indexOf(".") > 0){    
            s = s.replaceAll("0+?$", "");//去掉多余的0    
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉    
        }    
        return s;    
    }

	/* (non-Javadoc)
	 * @see pkuhit.iih.or.OrderService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<OrderModel> search(String enPk,String longOrF,String enTypeCode,String orTpNm,String svNm, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		//获取就诊类型
		
		List<OrderPo> poList = null;
		poList = orderDao.getOrderListByEnSn(enPk,longOrF,orTpNm,svNm,options);
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		OrderModel[] voArray = null ;
		ArrayResultBuilder<OrderModel> builder = ArrayResultBuilder.newArrayResult(OrderModel.class);
		if(null != poList){
			sortNo(poList);
			voArray = new OrderModel[poList.size()];
			int i = 0;
			int j = 1;
			String temp = null;
			for(OrderPo po : poList){
				OrderModel vo = new OrderModel();
				temp = po.getDosage();
				if(temp!=null && temp.length()!=0){
					temp = subZeroAndDot(temp);
					if(po.getDosageUnitNm()!=null && po.getDosageUnitNm().length()!=0){
						temp = temp+po.getDosageUnitNm();
					}
				}
				po.setDosage(temp);
				BeanUtils.copyProperties( po,vo);
				if(null != vo.getOrNoteNm()){
					vo.setOrNoteNm(vo.getOrNoteNm().trim());
				}
				vo.setNumber(j);
				voArray[i]= vo;
				i++;
				j++;
			}
			builder.withData(voArray);
		}
		ArrayResult<OrderModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	
	private void  sortNo(List<OrderPo> list){
		String temp = "";
		if(list != null){
			int num  = list.size();
			for(int i = 0;i<num;i++){
			    OrderPo  or = list.get(i);
			    if(or.getParOrPk() != null ){
			    	or.setGroupFlag("┌");
			    	if(or.getParOrPk().equals(temp)){
						or.setGroupFlag("-"); 
					}else{
						if(i>1){
							 OrderPo  parOR = list.get(i-1);
							 if(parOR.getParOrPk() != null){
								 if(parOR.getGroupFlag().equals("-")){
									  parOR.setGroupFlag("└");
								  }else if(parOR.getGroupFlag().equals("┌")){
									  parOR.setGroupFlag("");
								  }else{
									  parOR.setGroupFlag("");
								  }
							 } 
						 }
					}
					temp =  or.getParOrPk();
					if(i == num-1 ){
						 if(or.getGroupFlag().equals("-")) {
							 or.setGroupFlag("└");
						 }else if(or.getGroupFlag().equals("┌")){
							 or.setGroupFlag("");
						 }else{
							 or.setGroupFlag("");
						 }  
					}
				}else{
					 if(i>1){
						 OrderPo  parOR = list.get(i-1);
						 if(parOR.getParOrPk() != null){
						 if(parOR.getGroupFlag().equals("-")){
							  parOR.setGroupFlag("└");
						  }else if(parOR.getGroupFlag().equals("┌")){
							  parOR.setGroupFlag("");
						  }else{
							  parOR.setGroupFlag("");
							}
						 } 
					 }
				}	  
		    }
		 }
		
		/*if(list != null){
			int num  = list.size();
			for(int i = 0;i<num;i++){
			 OrderPo  or = list.get(i);
			 if(or.getParOrPk() != null && i !=0){
				 OrderPo  parOR = list.get(i-1);
				 if(parOR.getGroupFlag()==null){
					 parOR.setGroupFlag("┌");
				 }
				 or.setGroupFlag("-");
			}else{
				if(i>1){
					OrderPo  parOR = list.get(i-1);
					 if(parOR.getGroupFlag()=="-"){
					    parOR.setGroupFlag("└");
					 }
					
				}
				 
			}
		 }
	   }*/
	}
	
	
}
