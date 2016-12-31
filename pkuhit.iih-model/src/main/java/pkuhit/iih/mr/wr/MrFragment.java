
package pkuhit.iih.mr.wr;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

public class MrFragment extends BaseBizModel{

	public MrFragment() {
		super();
	}

	public MrFragment(String code) {
		super(code);
	}

	//个人知识库编码
	@Column(name = "FRAGMENT_TPL_CD")
	private String fragmentTplCd;

	//个人知识库内容
	@Column(name = "FRAGMENT_TPL_CONTENT")
	private String fragmentTplContent;

	//个人知识库类型编码
	@Column(name = "FRAGMENT_TPL_TYPE_CD")
	private String fragmentTplTypeCd;
	
	//个人知识库类型名称
    @Column(name = "FRAGMENT_TPL_TYPE_NM")
    private String fragmentTplTypeNm;

	//所属类别
	@Column(name = "OWNER_TYPE_CD")
	private String ownerTypeCd;
	
    //所属编码
    @Column(name = "OWNER_CD")
    private String ownerCd;
    
    //个人知识库名称
    @Column(name = "FRAGMENT_TPL_NM")
    private String fragmentTplNm;
    
    //创建人姓名
    @Column(name = "CRT_USER_ID")
    private String crtUserId;
    
    public String getCrtUserId()
    {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId)
    {
        this.crtUserId = crtUserId;
    }

    public String getFragmentTplTypeNm()
    {
        return fragmentTplTypeNm;
    }

    public void setFragmentTplTypeNm(String fragmentTplTypeNm)
    {
        this.fragmentTplTypeNm = fragmentTplTypeNm;
    }

    public String getFragmentTplCd()
    {
        return fragmentTplCd;
    }

    public void setFragmentTplCd(String fragmentTplCd)
    {
        this.fragmentTplCd = fragmentTplCd;
    }

    public String getFragmentTplContent()
    {
        return fragmentTplContent;
    }

    public void setFragmentTplContent(String fragmentTplContent)
    {
        this.fragmentTplContent = fragmentTplContent;
    }

    public String getFragmentTplTypeCd()
    {
        return fragmentTplTypeCd;
    }

    public void setFragmentTplTypeCd(String fragmentTplTypeCd)
    {
        this.fragmentTplTypeCd = fragmentTplTypeCd;
    }

    public String getOwnerTypeCd()
    {
        return ownerTypeCd;
    }

    public void setOwnerTypeCd(String ownerTypeCd)
    {
        this.ownerTypeCd = ownerTypeCd;
    }

    public String getOwnerCd()
    {
        return ownerCd;
    }

    public void setOwnerCd(String ownerCd)
    {
        this.ownerCd = ownerCd;
    }

    public String getFragmentTplNm()
    {
        return fragmentTplNm;
    }

    public void setFragmentTplNm(String fragmentTplNm)
    {
        this.fragmentTplNm = fragmentTplNm;
    }
}
