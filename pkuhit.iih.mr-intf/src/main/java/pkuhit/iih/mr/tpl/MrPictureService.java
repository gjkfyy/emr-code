package pkuhit.iih.mr.tpl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface MrPictureService {
/*	**
	 *  【医疗记录模板】新建服务（单记录）
	 * @param MrPicture value
	 * @return MrPicture
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/mr/picture", method = RequestMethod.POST)
	MrPicture create(MrPicture value) throws Throwable;
	

	*//**
	 * 【医疗记录模板】删除服务（单记录）
	 * @param id
	 * @return MrPicture
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/mr/picture/{id}", method = RequestMethod.GET)
	MrPicture delete(String id) throws Throwable;
	
	*//**
	 *  【医疗记录模板】更新服务（单记录）
	 * @param MrPicture value
	 * @return MrPicture
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/mr/picture/{id}", method = RequestMethod.PUT)
	MrPicture update(MrPicture value) throws Throwable;
	
	*//**
	 *  【医疗记录模板】查询服务（单记录）
	 * @param String id
	 * @return MrPicture
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/mr/picture/{id}", method = RequestMethod.GET)
	MrPicture search(String id) throws Throwable;
	
	*//**
	 *  【医疗记录模板】查询服务（多记录）
	 * @param  MrPicture condition
	 * @return List<MrPicture>
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/mr/pictures", method = RequestMethod.GET)
	List<MrPicture> search(MrPicture condition) throws Throwable;*/
}
