package sun.cloud.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xuebj on 2017/4/24.
 */
public class SimpleHash {

    private byte[] bytes;

    private String algorithmName;

    public SimpleHash(String algorithmName, byte[] sources, byte[] salt, Integer hashIterations) throws NoSuchAlgorithmException {
        this.algorithmName = algorithmName;
        this.bytes = hash(sources,salt,hashIterations);
    }

    protected byte[] hash(byte[] bytes, byte[] salt, int hashIterations) throws NoSuchAlgorithmException {
        MessageDigest digest = this.getDigest(this.getAlgorithmName());
        if(salt != null) {
            digest.reset();
            digest.update(salt);
        }
        byte[] hashed = digest.digest(bytes);
        int iterations = hashIterations - 1;

        for(int i = 0; i < iterations; ++i) {
            digest.reset();
            hashed = digest.digest(hashed);
        }

        return hashed;
    }


    protected MessageDigest getDigest(String algorithmName) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithmName);
    }


    @Override
    public String toString() {
        return encodeToString(this.getBytes());
    }


    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encodeToString(byte[] bytes) {
        char[] encodedChars = encode(bytes);
        return new String(encodedChars);
    }

    public static char[] encode(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for(int var4 = 0; i < l; ++i) {
            out[var4++] = DIGITS[(240 & data[i]) >>> 4];
            out[var4++] = DIGITS[15 & data[i]];
        }

        return out;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
