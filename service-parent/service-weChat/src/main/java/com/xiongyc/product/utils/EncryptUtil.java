/**********************************************************************
 * FILE : EncryptUtils.java
 * CREATE DATE : 2008-07-01
 * DESCRIPTION :
 *		
 *		在IMES系统中，EncryptUtils提供对用户密码SHA-1算法签名，以及验证的函数。
 *		提供用户登录后Token的生成，以及Token的提交验证。
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2008-07-01 |  Liu Yan Lu  |    创建草稿版本
 *---------------------------------------------------------------------              
 **********************************************************************
 */
package com.xiongyc.product.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang3.StringUtils;

import com.xiongyc.product.exception.BizException;


public class EncryptUtil {

	/**
	 * 加密密码前附加前缀
	 */
	public static final String TOKEN_PASSWORD_PREFIX = "WYBEGIN!@PAsS";

	private static final String TOKEN_KEY = "WYBEGIN2#!@toKeN2#XkEy";
	
	private static final String APP_CHARSET = "utf-8";

	/**
	 * Should process password before encrypt or verify
	 * 
	 * @param passwd
	 *            Plaintext password
	 * @param salt
	 *            Salt, usually should be loginname or email
	 * @return
	 */
	protected static String saltPassword(String passwd, String salt) {
		return StringUtils.reverse(TOKEN_PASSWORD_PREFIX + passwd + salt);
	}

	/**
	 * 仅仅生成hash,安全要求低
	 */
	public static String hash(String text) {
		String strDes = null;
		try {
			MessageDigest md = null;
			byte[] bt = text.getBytes(APP_CHARSET);

			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString

		} catch (Exception e) {
			throw new BizException("Encode error", e);
		}

		return strDes;
	}

	/**
	 * 将明文的密码以SHA-1算法加密
	 * 
	 * @param passwd
	 *            明文密码
	 * @param salt
	 *            混入密码的字串，一般可为用户名或者邮箱
	 * @return String SHA-1算法加密后的密码签名
	 */
	public static String encodePassword(String passwd, String salt) {

		String strDes = null;
		try {
			passwd = saltPassword(passwd, salt);
			MessageDigest md = null;
			byte[] bt = passwd.getBytes(APP_CHARSET);

			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString

		} catch (Exception e) {
			throw new BizException("Encode password error", e);
		}

		return strDes;
	}

	/**
	 * 验证用户输入的密码是否与数据库中SHA-1算法加密后的密码相同
	 * 
	 * @param passwd
	 *            明文密码
	 * @param sha1_passwd
	 *            SHA-1加密算法后的密码签名
	 * @return true 相同 false 不相同
	 */
	public static boolean validatePassword(String passwd, String sha1_passwd,
			String salt) {

		if (null == passwd || null == sha1_passwd)
			return false;

		if (sha1_passwd.equals(encodePassword(passwd, salt))) {
			return true;
		}

		return false;
	}


	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	private static byte[] hex2Bytes(String srcStr) {
		int byte_len = srcStr.length() / 2;
		byte[] result = new byte[byte_len];
		for (int i = 0; i < byte_len; i++) {
			String bytestr = srcStr.substring(i * 2, i * 2 + 2);
			result[i] = Integer.valueOf(bytestr, 16).byteValue();
		}
		return result;
	}

	/**
	 * Secret key for des from plain text key.
	 */
	private static SecretKey WKZ_DES_SECRET_KEY = null;

	/**
	 * Return secret key based on plaintext key.
	 * 
	 * @return
	 */
	protected static SecretKey getWkzDesSecretKey() {
		if (WKZ_DES_SECRET_KEY == null) {
			try {
				// 从原始密匙数据创建一个DESKeySpec对象
				DESKeySpec dks = new DESKeySpec(TOKEN_KEY.getBytes());

				// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
				// 一个SecretKey对象
				SecretKeyFactory keyFactory = SecretKeyFactory
						.getInstance("DES");
				WKZ_DES_SECRET_KEY = keyFactory.generateSecret(dks);
			} catch (Exception e) {
				throw new BizException("Genereate secret des key error", e);
			}
		}
		return WKZ_DES_SECRET_KEY;
	}

	/**
	 * Encode input by DES reversible.
	 * 
	 * @param inputstr
	 * @return A encoded HEX String
	 */
	public static String encodeToken(String inputstr) {

		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();

			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");

			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, getWkzDesSecretKey(), sr);

			// 现在，获取数据并加密
			// 正式执行加密操作
			return bytes2Hex(cipher.doFinal(inputstr.getBytes()));

		} catch (Exception e) {
			throw new BizException("Encode token error", e);
		}

	}

	/**
	 * Decode HES String to original text.
	 * 
	 * @param encodedStr
	 *            encoded hex string
	 * 
	 * @return original text
	 */
	public static String decodeToken(String encodedStr) {
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();

			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance("DES");

			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, getWkzDesSecretKey(), sr);

			// 现在，获取数据并解密
			// 正式执行解密操作
			return new String(cipher.doFinal(hex2Bytes(encodedStr)));

		} catch (Exception e) {
			throw new BizException("common.exception.tokenerror", e);
		}
	}


	public static void main(String[] args) {
		String salt = "1111";
		String password = "admin";
		System.out.println(encodePassword(password, salt));
	}
}
