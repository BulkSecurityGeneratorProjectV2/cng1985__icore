package com.young.security.rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.young.security.utils.Base64;


public class RSAMakePrivateKey {

	String privatekey;

	public RSAMakePrivateKey(String privatekey) {
		super();
		this.privatekey = privatekey;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ClientRSA rsac = new ClientRSA();
//		System.out.println(rsac.encode("xx"));
//		ServerRSA rsa = new ServerRSA();
//		System.out.println(rsa.decoder(rsac.encode("xx")));
//
//		
//		System.out.println(rsa.encode("你是谁啊测试下哦"));
//		System.out.println(rsac.decoder(rsa.encode("你是谁啊测试下哦")));

	}

	public String encode(String r) {
		String reslut = "";
		try {
			RSAPrivateKey p = getPrivateKey(privatekey);
			byte[] y;
			y = encrypt(p, r.getBytes());
			reslut = Base64.encode(y);

		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;

	}
	public String decoder(String r) {
		String reslut = "";
		try {
			RSAPrivateKey p = getPrivateKey(privatekey);
			byte[] y;
			y = decrypt(p, Base64.decode(r));
			reslut=new String(y);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;

	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (publicKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] encrypt(RSAPrivateKey publicKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (publicKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] decrypt(RSAPrivateKey privateKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (privateKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	private static RSAPrivateKey getPrivateKey(String x)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			IOException {

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
				Base64.decode(x));
		RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory
				.generatePrivate(priPKCS8);
		return privateKey;
	}

	private static RSAPublicKey getPublicKey(String x)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			IOException {

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec priPKCS8 = new X509EncodedKeySpec(Base64.decode(x));
		RSAPublicKey privateKey = (RSAPublicKey) keyFactory
				.generatePublic(priPKCS8);
		return privateKey;
	}
}
