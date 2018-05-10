package sun.cloud.core.biz.domain;

import java.io.Serializable;

/**
 * @Author: yzhang
 * @Date: 2018/5/3 17:39
 * @Desc:测试用户表
 */
public class UserInfoDO implements Serializable{

    private static final long serialVersionUID = -1659887596600259204L;


    private String userId;
    private String userName;
    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
