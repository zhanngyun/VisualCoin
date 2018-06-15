package sun.cloud.shiro.service.query;
import java.io.Serializable;
import sun.cloud.core.base.BaseQueryEntity;



/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleMenuQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields role_id:角色Id
     */
    private String roleId;

    /**
     *@Fields menu_id:资源Id
     */
    private Integer menuId;

    /**
     *@Fields remark:备注
     */
    private String remark;


    public void setRoleId(String roleId){
        this.roleId = roleId;
    }
    public String getRoleId(){
        return roleId;
    }
    public void setMenuId(Integer menuId){
        this.menuId = menuId;
    }
    public Integer getMenuId(){
        return menuId;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return "SysRoleMenu{" +
                    "roleId='" + roleId + "\'," +
                    "menuId='" + menuId + "\'," +
                    "remark='" + remark + "\'" +
                "}";
    }
}