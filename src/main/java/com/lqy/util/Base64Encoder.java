package com.lqy.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base64Encoder {

	public static String encode(String msg){

		byte[] b=null;

		BASE64Encoder encoder =null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			b=md.digest(msg.getBytes());

			encoder =new BASE64Encoder();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encoder.encode(b);
	}


	public static void main(String[] args) {

		String x="123";
		String y="dfthreyrgfhrey46";

		System.out.println(encode(x));
		System.out.println(encode(y));

	}

}
