
package pkuhit.iih.mr.wr;

import org.seasar.doma.Id;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

public class MrFragmentType extends BaseBizModel{

	public MrFragmentType() {
		super();
	}

	public MrFragmentType(String code) {
		super(code);
	}
	//个人知识库类型编码
    @Id
    @Column(name = "FRAGMENT_TPL_TYPE_CD")
    String fragmentTplTypeCd;

    //个人知识库类型名称
    @Column(name = "FRAGMENT_TPL_TYPE_NM")
    String fragmentTplTypeNm;
    
    //使用该类别的知识库个数
    @Column(name = "USECOUNT")
    String useCount;

    public String getUseCount()
    {
        return useCount;
    }

    public void setUseCount(String useCount)
    {
        this.useCount = useCount;
    }

    public String getFragmentTplTypeCd()
    {
        return fragmentTplTypeCd;
    }

    public void setFragmentTplTypeCd(String fragmentTplTypeCd)
    {
        this.fragmentTplTypeCd = fragmentTplTypeCd;
    }

    public String getFragmentTplTypeNm()
    {
        return fragmentTplTypeNm;
    }

    public void setFragmentTplTypeNm(String fragmentTplTypeNm)
    {
        this.fragmentTplTypeNm = fragmentTplTypeNm;
    }
}
