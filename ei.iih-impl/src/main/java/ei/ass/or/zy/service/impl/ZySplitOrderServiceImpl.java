package ei.ass.or.zy.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.or.OrderModel;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.or.auto.po.OrderPo;
import ei.ass.or.zy.dao.ZySplitOrderDao;
import ei.ass.or.zy.service.ZySplitOrderService;

/**
 * @author guo_zhongbao
 * 医嘱视图
 */
public class ZySplitOrderServiceImpl implements ZySplitOrderService {
	 
	final String ORDER_READ_FROM_VIEW_KEY = "ORDER_READ_FROM_VIEW"; //从视图中读取检查报告
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Autowired
	ZySplitOrderDao orderDao;
	
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
	public ArrayResult<OrderModel> search(String patient_id,String times, String longOrF,String enTypeCode,String orTpNm ,String svNm,String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		ArrayResultBuilder<OrderModel> builder = ArrayResultBuilder.newArrayResult(OrderModel.class);
		int total = 0 ;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(ORDER_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
					&&  null != rsFunFlag.getData()
					&& null != rsFunFlag.getData()
					&& rsFunFlag.getData().equalsIgnoreCase("1")
		)	
		{
			OrderModel[] voArray = null ;
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
			List<OrderPo> poList = this.orderDao.getOrderListByEnSn(patient_id,times,longOrF,orTpNm,svNm/*,options*/);
//			List<OrderPo> poList = this.orderDao.getOrderListByEnPk(enPk,longOrF/*,options*/);
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
					
			if(null != poList){
				voArray = new OrderModel[poList.size()];
				List<OrderPo> newPoList = sortNo(poList);
				//List<OrderPo> newPoList = sortNo2(sortNo1(poList));
				int i = 0;
				int j = 1;
				String temp = null;
				for(OrderPo po : newPoList){
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
		}

		ArrayResult<OrderModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	
	private List<OrderPo>  sortNo(List<OrderPo> list){
		
		List<OrderPo> parentList=new ArrayList<OrderPo>();
		for(Iterator<OrderPo> it=list.iterator();it.hasNext();){
			OrderPo order=it.next();
			if(order.getParOrPk()==null ||order.getParOrPk().equals("") || order.getParOrPk().equals("0")){
				parentList.add(order);
				it.remove();
			}
		}
		
		List<OrderPo> returnList=new ArrayList<OrderPo>();
		for(Iterator<OrderPo> pit=parentList.iterator();pit.hasNext();){
			OrderPo porder=pit.next();
			returnList.add(porder);
			pit.remove();
			
		  OrderPo child	=null;
			for(Iterator<OrderPo> it=list.iterator();it.hasNext();){
				OrderPo  order=it.next();
			//	System.out.println("order.getParentOrderSn()="+order.getParentOrderSn()+";porder.getOrderSn()="+porder.getOrderSn()+";");
				if(order.getParOrPk().equals(porder.getOrPk())){
					child=order;
					child.setGroupFlag("┠");
					returnList.add(child);
					it.remove();
				}
			}
			if(child!=null){
				porder.setGroupFlag("┏");
				child.setGroupFlag("┗");
			}else{
				porder.setGroupFlag("");
			}
		}
		return returnList;
	}
	//处理医嘱组
	private List<OrderPo>  sortNo1(List<OrderPo> list){
		List<OrderPo> newList =new ArrayList<OrderPo>(); //新的医嘱组
		List<OrderPo> parentOrPkList=new ArrayList<OrderPo>(); //按父遗嘱相同为一组
		List<OrderPo> sameOrPressList=new ArrayList<OrderPo>();
		String lastOrPk = null; //上一个orderPk
		String lastOrderPress = null ; //上一个处方号
		int size = list.size() ;
		//for(Iterator<OrderPo> it=list.iterator();it.hasNext();){
		for(int index = 0 ; index < list.size() ; index ++) //Iterator<OrderPo> it=list.iterator();it.hasNext();){
		{	//分组规则：1有父医嘱号码的为一组  或者 2 处方号orderPress相同，按sortNo排序
			OrderPo order=list.get(index);
			String currParOrPk = order.getParOrPk();
			if( null == lastOrPk ){
				//如果 上个是空的，那么把这个加入到组里
				lastOrPk = order.getOrPk() ;
				if(parentOrPkList.size() > 1){
					newList.addAll(operateFlag(parentOrPkList));
				}else if(parentOrPkList.size() > 0){
					newList.addAll(parentOrPkList);
				}
				parentOrPkList.clear();
				parentOrPkList.add(order);
			}else{
				if(null != currParOrPk && currParOrPk.equalsIgnoreCase(lastOrPk)){
					//如果父医嘱号为上一个医嘱号，则放到到组里
					parentOrPkList.add(order);
				}else{
					//如果父医嘱号不为上一个医嘱号，处理组标记，然后清空lastOrPk和parentOrPkList
					if(parentOrPkList.size() > 1){
						newList.addAll(operateFlag(parentOrPkList))  ;
					}else{
						newList.addAll(parentOrPkList);
					}					
					parentOrPkList.clear();
					lastOrPk = currParOrPk ;
					parentOrPkList.add(order);
				}
			}
			if(index == size - 1){
				if(parentOrPkList.size() > 1){
					newList.addAll(operateFlag(parentOrPkList))  ;
				}else{
					if(!parentOrPkList.isEmpty()){
						newList.addAll(parentOrPkList);
					}
				}
			}
		}
		return newList;
	}
		
		//处理相同的处方号
		private List<OrderPo>  sortNo2(List<OrderPo> list){
			List<OrderPo> newList =new ArrayList<OrderPo>(); //新的医嘱组
			List<OrderPo> sameOrPressList=new ArrayList<OrderPo>();
			String lastOrPk = null; //上一个orderPk
			String lastOrderPress = null ; //上一个处方号
			int size = list.size() ;
			//for(Iterator<OrderPo> it=list.iterator();it.hasNext();){
			for(int index = 0 ; index < list.size() ; index ++) //Iterator<OrderPo> it=list.iterator();it.hasNext();){
			{	//分组规则：1有父医嘱号码的为一组  或者 2 处方号orderPress相同，按sortNo排序
				OrderPo order=list.get(index);
				String currOrderPress = order.getOrPresPk();
				if(null == lastOrderPress){
					lastOrderPress = order.getOrPresPk();					
					if(sameOrPressList.size() > 1){
						newList.addAll(operateFlag(sameOrPressList));
					}else if(sameOrPressList.size() > 0){
						newList.addAll(sameOrPressList);
					}
					sameOrPressList.add(order);
				}else{
					if(null  != currOrderPress && currOrderPress.equalsIgnoreCase(lastOrderPress) && sameOrPressList.size() + 1 == Integer.valueOf(order.getSortNo())){
						//如果处方号相同，则放到到组里
						sameOrPressList.add(order) ;                       
					}else{
						//如果父医嘱号不为上一个医嘱号，处理组标记，然后清空lastOrPk和parentOrPkList
						if(sameOrPressList.size() > 1){
							newList.addAll(operateFlag(sameOrPressList))  ;
						}else{
							newList.addAll(sameOrPressList);
						}
					
						sameOrPressList.clear();
						sameOrPressList.add(order) ;  
						lastOrderPress = currOrderPress ;
					}
				}
				if(index == size -1){
					if(sameOrPressList.size() > 1){
						newList.addAll(operateFlag(sameOrPressList))  ;
					}else{
						if(!sameOrPressList.isEmpty()){
							newList.addAll(sameOrPressList);
						}
					}
				}
			}
			return newList;
		}
		
        //处理组标记
		private List<OrderPo> operateFlag(List<OrderPo> list) {
			List<OrderPo> returnList=new ArrayList<OrderPo>();
			OrderPo oFirst = list.get(0);
			returnList.add(oFirst);
			oFirst.setGroupFlag("┏");
			for(int i= 1; i < list.size() -1 ; i++){
				OrderPo  order= list.get(i);
				order.setGroupFlag("┠");
				returnList.add(order);
			}
			OrderPo olast = list.get( list.size() -1);
			olast.setGroupFlag("┗");
			returnList.add(olast);
			return returnList;
		}
	
}
