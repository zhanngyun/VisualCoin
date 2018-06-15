package sun.cloud.shiro.domain;

import java.io.Serializable;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:19
 * @Desc: shiro用户
 */
public class ShiroUser implements Serializable{

    private static final long serialVersionUID = 7356599832996541967L;
    /**
     *@Fields user_name:用户姓名
     */
    private String userName;
    /**
     *@Fields password:密码
     */
    private String password;
    /**
     *@Fields real_name:真实名称
     */
    private String realName;
    /**
     *@Fields sex:性别
     */
    private String sex;
    /**
     *@Fields mobile:手机号
     */
    private String mobile;
    /**
     *@Fields email:邮箱
     */
    private String email;
    /**
     *@Fields user_status:用户状态
     */
    private String userStatus;
    /**
     *@Fields user_type:用户类型
     */
    private String userType;
    /**
     *@Fields dept_code:部门信息
     */
    private String deptCode;
    /**
     *@Fields remark:备注
     */
    private String remark;

    /**
     * 是否是超级管理员
     */
    private String isAdmin;

    /**
     * 用户角色Id
     */
    private String roleId;


    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
