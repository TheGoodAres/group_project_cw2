package com.mycompany.group_project_cw2;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class HashPassword {
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }
    public static byte[] getSaltedHashSHA512(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] byteData = md.digest(password.getBytes());
            return byteData;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i < bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    public static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
    public static void main(String[] args) {
        String storedPassword = "Robylape";
        Scanner in = new Scanner(System.in);
        String typedPassword = in.next();
        byte[] salt;
        try {
            salt = getSalt();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hashPassword = getSaltedHashSHA512(storedPassword, salt);
        byte[] typedHashPassword = getSaltedHashSHA512(typedPassword, salt);
        String stringHashPassword = toHex(hashPassword);
        String typedHashPasswordToHex = toHex(typedHashPassword);
        System.out.println(stringHashPassword.equals(typedHashPasswordToHex));
        byte[] passwordFromHex = fromHex(stringHashPassword);
        System.out.println(Arrays.equals(typedHashPassword, passwordFromHex));
        if (Arrays.equals(hashPassword, typedHashPassword)) {
            System.out.println("Success");
        }
    }
}
