package sun.cloud.shiro.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:23
 * @Desc: 密码服务类 加密作用
 */
public class ShiroPasswordService {

    /**
     * 私有盐
     */
    private String publicSalt = "cloud";

    /**
     * 密码加密方式
     */
    private String hashAlgorithm = "MD5";
    /**
     * 加密方式
     */
    private int hashInterations = 2;

    public String encryptPassword(String content, String privateSalt) throws IllegalArgumentException {
        SimpleHash hash = new SimpleHash(getHashAlgorithm(), content, ByteSource.Util.bytes(privateSalt + getPublicSalt()), getHashInterations());
        return hash.toString();
    }

    public String getPublicSalt() {
        return publicSalt;
    }

    public void setPublicSalt(String publicSalt) {
        this.publicSalt = publicSalt;
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public int getHashInterations() {
        return hashInterations;
    }

    public void setHashInterations(int hashInterations) {
        this.hashInterations = hashInterations;
    }

    public static void main(String[] args) {
        System.out.printf(new ShiroPasswordService().encryptPassword("123123", "admin"));
    }
}
