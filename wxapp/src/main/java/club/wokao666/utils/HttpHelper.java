package club.wokao666.utils;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * http工具类
 */
public class HttpHelper {
	/**
	 * 设置请求类型
	 */
	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	//创建一个OKHttpClient对象
	private static final OkHttpClient client = new OkHttpClient();
	/**
	 * 发送post请求
	 */
	public static String post(String url,String code){
		//新建一个请求体
		RequestBody body = RequestBody.create(JSON, "appid=wx8c0ea36a481e274b&secret=70212cf6c277bef4c853219b4b806569&js_code=" + code + "&grant_type=authorization_code");
		//创建一个请求
		Request request = new Request.Builder().url(url).post(body).build();
		//执行请求，如果有错误直接释放资源，try catch
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}catch(Exception e){
			
		}
		return code;
	}
}