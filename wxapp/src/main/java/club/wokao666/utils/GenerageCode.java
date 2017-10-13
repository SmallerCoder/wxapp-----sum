package club.wokao666.utils;

import java.util.Random;

import org.springframework.boot.SpringApplication;

/**
 * 生成随机字符串，用户用户登录
 */
public class GenerageCode {
	
	
	/**
	 * 生成随机字符串,length为长度
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }     
	
	
	public static void main(String[] args) {
		System.err.println(getRandomString(32));
	}
	
}
