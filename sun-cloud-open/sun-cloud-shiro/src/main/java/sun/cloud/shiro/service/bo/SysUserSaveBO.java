package sun.cloud.shiro.service.bo;
import java.io.Serializable;



/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysUserSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;

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


    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setUserStatus(String userStatus){
        this.userStatus = userStatus;
    }
    public String getUserStatus(){
        return userStatus;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public String getUserType(){
        return userType;
    }
    public void setDeptCode(String deptCode){
        this.deptCode = deptCode;
    }
    public String getDeptCode(){
        return deptCode;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return "SysUser{" +
                    "userName='" + userName + "\'," +
                    "password='" + password + "\'," +
                    "realName='" + realName + "\'," +
                    "sex='" + sex + "\'," +
                    "mobile='" + mobile + "\'," +
                    "email='" + email + "\'," +
                    "userStatus='" + userStatus + "\'," +
                    "userType='" + userType + "\'," +
                    "deptCode='" + deptCode + "\'," +
                    "remark='" + remark + "\'" +
                "}";
    }
}