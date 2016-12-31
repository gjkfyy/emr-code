package iih.di.model;

import java.util.ArrayList;
import java.util.List;

public class CommitDataModel {
	private String enSn;
	//private List list;
	//private String list;
    private DibDiModel[] list ;

	public String getEnSn() {
		return enSn;
	}
	public void setEnSn(String enSn) {
		this.enSn = enSn;
	}
	public DibDiModel[] getList() {
		return list;
	}
	public void setList(DibDiModel[] list) {
		this.list = list;
	}


}
