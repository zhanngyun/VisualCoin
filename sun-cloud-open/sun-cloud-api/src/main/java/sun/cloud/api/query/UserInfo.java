package sun.cloud.api.query;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author: yzhang
 * @Date: 2018/5/9 20:16
 * @Desc:
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -7103579797643559633L;
    /**
     * openId
     */
    private String openid;

    /**
     * 用户昵称
     */
    @NotBlank(message = "{nickName}")
    private String nickName;

    /**
     * 用户头像 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
     */
    private String avatarUrl;

    /**
     * 值为1时是男性，值为2时是女性，值为0时是未知
     */
   private String gender;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 用户所在省份
     */
    private String province;
    /**
     * 用户所在国家
     */
    private String country;
    /**
     * 语言
     */
    private String language;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "openid='" + openid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
