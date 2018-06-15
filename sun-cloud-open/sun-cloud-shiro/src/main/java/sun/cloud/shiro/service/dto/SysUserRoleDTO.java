package sun.cloud.shiro.service.dto;
import java.io.Serializable;



/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysUserRoleDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields user_name:用户名称
     */
    private String userName;
    /**
     *@Fields role_id:角色Id
     */
    private String roleId;
    /**
     *@Fields remark:备注
     */
    private String remark;

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setRoleId(String roleId){
        this.roleId = roleId;
    }
    public String getRoleId(){
        return roleId;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return "SysUserRole{" +
                    "userName='" + userName + "\'," +
                    "roleId='" + roleId + "\'," +
                    "remark='" + remark + "\'" +
                "}";
    }
        }