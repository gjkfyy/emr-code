package fi.clinical.server.cis.service;




import xap.sv.annotation.Action;

public interface CisLoginVerifyService
{
    @Action("cisLoginVerify")
    public String cisLoginVerify(CisLoginVerifyModel loginModel);
    
    public CisLoginVerifyModel parseCisLoginVerifyModel(String para);
    
    public String parseCisLoginVerifyModelToken(String para);
}
