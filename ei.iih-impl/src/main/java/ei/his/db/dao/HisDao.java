package ei.his.db.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface HisDao
{
	/**
	 * 
	 * 根据条件从obs_order获得(会诊，跨科处置)的就诊列表
	 * @param enPk 就诊序号
	 * @param statusCode  状态
	 * @param orderType  申请报告类型  3---会诊申请
	 * @param execUnit   (期望)执行单元
	 * @param oderStartTime 申请起始时间
	 * @param orderEndTime  申请终止时间
	 * */
    @Select
    List<Map<String,Object>> getZYConsMramrFromObsOrderByEnSn(String enPk,String statusCode,String orderType,String execUnit,String oderStartTime,String orderEndTime);

	/**
	 * 
	 * 根据条件从obs_order获得(会诊，跨科处置)的就诊列表
	 * @param enPk 就诊序号
	 * @param statusCode  状态
	 * @param orderType  申请报告类型  3---会诊申请
	 * @param execUnit   (期望)执行单元
	 * @param oderStartTime 申请起始时间
	 * @param orderEndTime  申请终止时间
	 * */
    @Select
    List<Map<String,Object>> getZYStepMramrFromObsOrderByEnSn(String enPk,String statusCode,String orderType,String execUnit,String oderStartTime,String orderEndTime);

	/**
	 * 
	 * 根据条件从obs_order获得(会诊，跨科处置)的就诊列表
	 * @param enPk 就诊序号
	 * @param statusCode  状态
	 * @param orderType  申请报告类型  3---会诊申请
	 * @param execUnit   (期望)执行单元
	 * @param oderStartTime 申请起始时间
	 * @param orderEndTime  申请终止时间
	 * */
    @Select
    List<Map<String,Object>> getMZConsMramrFromObsOrderByEnSn(String enPk,String statusCode,String orderType,String execUnit,String oderStartTime,String orderEndTime);

	/**
	 * 
	 * 根据条件从obs_order获得(会诊，跨科处置)的就诊列表
	 * @param enPk 就诊序号
	 * @param statusCode  状态
	 * @param orderType  申请报告类型  3---会诊申请
	 * @param execUnit   (期望)执行单元
	 * @param oderStartTime 申请起始时间
	 * @param orderEndTime  申请终止时间
	 * */
    @Select
    List<Map<String,Object>> getMZStepMramrFromObsOrderByEnSn(String enPk,String statusCode,String orderType,String execUnit,String oderStartTime,String orderEndTime);

    
}
