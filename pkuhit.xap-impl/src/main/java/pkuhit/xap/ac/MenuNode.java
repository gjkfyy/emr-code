package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pkuhit.xap.dao.auto.entity.XapMenu;
import pkuhit.xap.dao.custom.CustomXapUserDao;

import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

public class MenuNode extends BaseNode<MenuTreeData>
{
    CustomXapUserDao customXapUserDao;
    
    public MenuNode(MenuTreeData data,Map<String, String> condition){
        super(data, condition);
        DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
        this.customXapUserDao = df.getDao(CustomXapUserDao.class);
    }
    
    @Override
    public void loadChildren() {
        ArrayList<Composite<MenuTreeData>> children = new ArrayList<Composite<MenuTreeData>>();
        MenuTreeData treeData  = this.getData();
        String parMenuCd = treeData.getCode();
        Map<String, String> condition = this.getCondition();
        String userId = (String)condition.get("userId");
        String portalCd = (String)condition.get("portalCd");
        String orgCd = (String)condition.get("orgCd");
        List<XapMenu> lst = new ArrayList<XapMenu>();
        if(orgCd != null)
            lst = customXapUserDao.selectXapMenuListByUserId(userId, portalCd, orgCd, parMenuCd);
        else
            lst = customXapUserDao.selectDefaultMenuList(userId, portalCd, parMenuCd);
        for(XapMenu item:lst){
            MenuTreeData menu = new MenuTreeData();
            menu.setCode(item.getMenuCd());
            menu.setName(item.getNm());
            menu.setNmEn(item.getNmEn());
            MenuNode menuNode = new MenuNode(menu,this.getCondition());
            children.add(menuNode);
        }
        //加载子节点
        this.setChildren(children);
        for(Composite<MenuTreeData> item:children) {
            item.loadChildren();
        }
    }
    
    @Override
    public String getText() {
        return this.getData().getName();
    }
}
