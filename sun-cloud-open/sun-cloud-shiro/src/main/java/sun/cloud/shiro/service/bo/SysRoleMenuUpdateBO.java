package sun.cloud.shiro.service.bo;
import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleMenuUpdateBO implements Serializable{
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