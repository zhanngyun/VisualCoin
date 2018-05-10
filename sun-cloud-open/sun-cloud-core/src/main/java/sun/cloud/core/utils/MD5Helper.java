package sun.cloud.core.utils;


import sun.cloud.core.exception.builder.ErrorBuilder;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xuebj on 2017/4/24.
 */
public class MD5Helper {
    /**
     * 私有盐
     */
    private  String publicSalt = "hsnet";

    /**
     * 密码加密方式
     */
    private  String hashAlgorithm = "MD5";
    /**
     * 加密方式
     */
    private  int hashInterations = 2;


    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public String encrypt(String content,String publicSalt)  {
        if (!StringUtils.isNotBlank(publicSalt)){
            this.publicSalt = publicSalt;
        }
        SimpleHash simpleHash = null;
        try {
            simpleHash = new SimpleHash(hashAlgorithm,content.getBytes(),publicSalt.getBytes(),hashInterations);
        } catch (NoSuchAlgorithmException e) {
            ErrorBuilder.buildBizError("密码解析错误");
        }
        return simpleHash.toString();
    }

    /**
     * MD5 加密
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static final String md5(String content){
        MessageDigest digest= null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(content.getBytes());
        return encodeToString(digest.digest());
    }

    private static String encodeToString(byte[] bytes) {
        return new String(byteArrayToHexString(bytes));
    }

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
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

   /* public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.printf(new MD5Helper().encrypt("user1","admin"));
    }*/
}
