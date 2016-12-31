package pkuhit.xap.ac;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MenuTreeData implements Serializable
{
    private String code;
    
    private String name;
    
    private String nodeType;
    
    /**
     * 病历文书自定义分类编码
     */
    private String custCategoryCode;
    /**
     * 病历文书自定义分类名称
     */
    private String custCategoryName;
    
    private String nmEn;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    public String getCustCategoryCode()
    {
        return custCategoryCode;
    }

    public void setCustCategoryCode(String custCategoryCode)
    {
        this.custCategoryCode = custCategoryCode;
    }

    public String getCustCategoryName()
    {
        return custCategoryName;
    }

    public void setCustCategoryName(String custCategoryName)
    {
        this.custCategoryName = custCategoryName;
    }

    public String getNmEn()
    {
        return nmEn;
    }

    public void setNmEn(String nmEn)
    {
        this.nmEn = nmEn;
    }
}
