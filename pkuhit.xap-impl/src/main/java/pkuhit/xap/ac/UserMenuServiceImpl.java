package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.custom.CustomXapUserDao;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.model.TreeResultBuilder;

public class UserMenuServiceImpl implements UserMenuService
{
    @Autowired
    CustomXapUserDao customXapUserDao;

    @Override
    public TreeResult<MenuTreeData> getUserMenuTree(Map<String, String> condition)
    {
        TreeNode<MenuTreeData> root = new TreeNode<MenuTreeData>();
        MenuTreeData menu = new MenuTreeData();
        MenuNode menuNode = new MenuNode(menu,condition);
        //加载树数据
        menuNode.loadChildren();
        menuNode.copyToTreeNode(root);
        
        //■　设置返回值
        TreeResultBuilder<MenuTreeData> newTreeResult = TreeResultBuilder.newTreeResult(MenuTreeData.class);
        newTreeResult.withRoot(root);
        TreeResult<MenuTreeData> build = newTreeResult.build();
        return build;
    }
}
