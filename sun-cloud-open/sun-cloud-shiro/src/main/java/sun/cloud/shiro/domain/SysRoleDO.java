package sun.cloud.shiro.domain;

import sun.cloud.core.base.BaseQueryEntity;

import java.io.Serializable;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleDO extends BaseQueryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields role_id:角色编号
     */
    private String roleId;
    /**
     * @Fields role_name:角色名称
     */
    private String roleName;
    /**
     * @Fields role_flag:角色标志
     */
    private String roleFlag;
    /**
     * @Fields remark:备注
     */
    private String remark;

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "SysRoleDO{" +
                "roleId='" + roleId + "\'," +
                "roleName='" + roleName + "\'," +
                "roleFlag='" + roleFlag + "\'," +
                "remark='" + remark + "\'" +
                "}";
    }
}