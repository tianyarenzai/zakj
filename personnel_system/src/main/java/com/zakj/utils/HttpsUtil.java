package com.zakj.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Properties;


public class HttpsUtil {

	public static final String corpid="dingb3ecf28755f7a28a35c2f4657eb6378f";
	public static final String corpsecret="t-dW83dZGX6S6gZivY8D_yMg3LNycgrybaOEEA4DTVUKJAnooaPSuLq2oMUPFkn7";
    public static final String  accessToken1="07834f9ba8623ce7bf92ea0fb3c3aed1";
	public  static HttpsUtil utils = new HttpsUtil();
	Properties header = new Properties();
	private int readTimeout = 30000;
	private int connectTimeout = 100000;

	public void setConnecTimeout(int timeout) {
		this.connectTimeout = timeout;
	}

	public void setReadTimeout(int timeout) {
		this.readTimeout = timeout;
	}

	public void setHeader(String key, String value) {
		this.header.setProperty(key, value);
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public String sendPost(String url, String body) throws Exception {
		trustAllHttpsCertificates();
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		URL httpsUrl = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) httpsUrl.openConnection();
		conn.setHostnameVerifier(hv);
		DataOutputStream out = null;
		InputStream in = null;
		try {
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(this.connectTimeout);
			conn.setReadTimeout(this.readTimeout);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			out = new DataOutputStream(conn.getOutputStream());
			if (body != null) {
				byte[] outByte = body.getBytes("UTF-8");
				out.write(outByte);
			}
			out.flush();
			out.close();
			in = conn.getInputStream();
			int code = conn.getResponseCode();
			String response = null;
			if (HttpURLConnection.HTTP_OK == code) {
				response = org.apache.commons.io.IOUtils.toString(in,"UTF-8");
			}
			
			System.out.print("https url = " + url + " || response = " + response);
			return response;
		} catch (Exception e) {
			System.out.print(e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public String sendGet(String url) throws Exception {
		trustAllHttpsCertificates();
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		URL httpsUrl = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) httpsUrl.openConnection();
		conn.setHostnameVerifier(hv);
		DataOutputStream out = null;
		InputStream in = null;
		try {
			conn.setConnectTimeout(this.connectTimeout);
			conn.setReadTimeout(this.readTimeout);
			conn.setDoOutput(true);
			in = conn.getInputStream();
			int code = conn.getResponseCode();
			String response = null;
			if (HttpURLConnection.HTTP_OK == code) {
				response = org.apache.commons.io.IOUtils.toString(in,"UTF-8");
			}
			System.out.print("https url = " + url + " || response = " + response);
			return response;
		} catch (Exception e) {
			System.out.print(e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}

		}
	}

	/**
	 * 钉钉服务端返回是否成功
	 * @param response
	 * @return
	 */
	public static boolean isSuccess(String response){
		if (response.contains("\"errcode\":0")) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void trustAllHttpsCertificates() throws Exception {
		// Create a trust manager that does not validate certificate chains:
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	public static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		@Override
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		@Override
		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		@Override
		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}

 //钉钉的唯一凭证  
	public static String getAccess_token() {
		String token = null;
		try {
			String url1 = "https://oapi.dingtalk.com/gettoken?corpid=" +corpid
					+ "&corpsecret=" + corpsecret;
			String rst = utils.sendGet(url1);
			Map<String, Object> json = JsonTools.parseJSON2Map(rst);
			token = json.get("access_token").toString();
			System.out.println("*****************"+token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}


	//获取部门信息
	public static Map<String, Object> getDept(String accessToken){
		Map<String, Object> array=null;
	try {
		String getDeptIdUrl = "https://oapi.dingtalk.com/department/list?access_token=";
		getDeptIdUrl += accessToken;
		String rstDept = utils.sendGet(getDeptIdUrl);

		Map<String, Object> json = JsonTools.parseJSON2Map(rstDept);


		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return array;
	}


	//创建部门
	public static Map<String, Object> addDept(String accessToken,String body){

		Map<String, Object>  rstDeptMap = null;
		try {
			String url = "https://oapi.dingtalk.com/department/create?access_token=";
			url += accessToken;

			rstDeptMap = JsonTools.parseJSON2Map(utils.sendPost(url,body));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptMap;
	}

//获取管理员列表
	public static Map<String, Object> getAdmin(String accessToken){

		Map<String, Object>  rstDeptMap = null;
		try {
			String url = "https://oapi.dingtalk.com/user/get_admin?access_token=";

			url += accessToken;
			String rstDept = utils.sendGet(url);
			System.out.println(rstDept);
			Map<String, Object> json = JsonTools.parseJSON2Map(rstDept);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptMap;
	}

	//获取职工打卡信息
	public static  Map<String, Object>  list(String accessToken,String body){

		try {
			String url = "https://oapi.dingtalk.com/attendance/list?access_token=";
			url += accessToken;
			System.out.println("************"+utils.sendPost(url,body));
			Map<String, Object> rstDeptMap = JsonTools.parseJSON2Map(utils.sendPost(url,body));
			System.out.println(rstDeptMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//考勤打卡记录开放
	public static  Map<String, Object>  listRecord(String accessToken,String body){

		try {
			String url = "https://oapi.dingtalk.com/attendance/listRecord?access_token=";
			url += accessToken;

			Map<String, Object> rstDeptMap = JsonTools.parseJSON2Map(utils.sendPost(url,body));
			System.out.println(rstDeptMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	//查询钉钉职工信息
	public static  Map<String, Object>  getEmoloyeeByuserId(String accessToken,String userId){
		Map<String, Object> rstDeptDetails =  null;
		try {
			String url = "https://oapi.dingtalk.com/user/get?access_token="+accessToken+"&userid="+userId;
			rstDeptDetails =JsonTools.parseJSON2Map(utils.sendGet(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptDetails;
	}


	//修改钉钉用户信息
	public static Map<String, Object> updateUserId(String accessToken,String body){
		Map<String, Object> json=null;
		try {
			String url = "https://oapi.dingtalk.com/user/update?access_token=";
			url += accessToken;
			json =JsonTools.parseJSON2Map(utils.sendPost(url,body));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}


	// 修改钉钉用户信息
	public static Map<String, Object> addUserId(String accessToken,String body){
		HttpsUtil utils = new HttpsUtil();
		Map<String, Object> json=null;
		try {
			String url = "https://oapi.dingtalk.com/user/create?access_token=";
			url += accessToken;
			json=JsonTools.parseJSON2Map(utils.sendPost(url,body));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	//删除职工
	public static Map<String, Object> delUser(String accessToken,String userId){
		Map<String, Object> rstDeptDetails =  null;
		try {
			String url = "https://oapi.dingtalk.com/user/delete?access_token="+accessToken+"&userid="+userId;
			rstDeptDetails =JsonTools.parseJSON2Map(utils.sendGet(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptDetails;

	}


	public static Map<String, Object> signAtten(String accessToken,String userId){
		Map<String, Object> rstDeptDetails =  null;
		try {
			String url = "https://oapi.dingtalk.com/checkin/record?access_token=ACCESS_TOKEN&department_id=1&start_time=1467707227000";
			rstDeptDetails = JsonTools.parseJSON2Map(utils.sendGet(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptDetails;

	}


	// https://oapi.dingtalk.com/user/simplelist?access_token=ACCESS_TOKEN&department_id=1
//获取部门成员
	public static Map<String, Object> simplelist(String accessToken,String department_id){
		Map<String, Object> rstDeptDetails =  null;
		try {
			String url = "https://oapi.dingtalk.com/user/simplelist?access_token="+accessToken+"&department_id="+department_id;
			rstDeptDetails = JsonTools.parseJSON2Map(utils.sendGet(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstDeptDetails;

	}


	public  static void main (String [] args){


		/*
		* response = {
	"errmsg": "ok",
	"department": [{
		"id": 1,
		"createDeptGroup": true,
		"name": "西安西航测试中心",
		"autoAddUser": true
	}, {
		"id": 69001606,
		"createDeptGroup": true,
		"name": "钉钉事业部1",
		"parentid": 1,
		"autoAddUser": true,
		"sourceIdentifier": "source"
	}, {
		"id": 68970572,
		"createDeptGroup": true,
		"name": "钉钉人事部",
		"parentid": 1,
		"autoAddUser": true,
		"sourceIdentifier": "source"
	}],
	"errcode": 0
}
null*/
		/**
		 * 获取部门成员
		 * {"name":"李小猛","userid":"013348171426174650"}
		 *
		 * {"name":"张霞","userid":"1301624729793598"}
 		 */
	//	Map<String, Object> map=simplelist(accessToken1,"69001606");




		/*获取部门信息*/
/*
		Map<String, Object> map=	getDept(accessToken1);
		System.out.println(map);*/



   /*     Map<String, Object> map=listRecord("695509705ec63c9fb2791c69a6b3ba7e",body);
*/
   /*
   获取职工打卡信息  "013348171426174650", "1301624729793598"
    */
/*
	 	String body="{ \"workDateFrom\": \"2018-06-27 00:00:00\",\n" +
				"    \"workDateTo\": \"2018-06-29 00:00:00\",\n" +
				"    \"userIdList\":[\"1301624729793598\"],\n" +
				"    \"offset\":0,\n" +
				"    \"limit\":10}";

		Map<String, Object> map=list(accessToken1,body);*/



	/*	String body="{\n" +
				"    \"userIds\": [\"manager8099\",\"002\"],\n" +
				"    \"checkDateFrom\": \"2018-06-25 00:00:00\",\n" +
				"    \"checkDateTo\": \"2018-06-26 00:00:00\"\n" +
				"}";

		Map<String, Object> map=listRecord("695509705ec63c9fb2791c69a6b3ba7e",body);

*/
	/* Map<String, Object> map=getAdmin(accessToken1);
		System.out.println(map.toString());*/
		/*String body="{\n" +
				"    \"name\": \"钉钉人事部\",\n" +
				"    \"parentid\": \"1\",\n" +
				"    \"order\": \"1\",\n" +
				"    \"createDeptGroup\": true,\n" +
				"    \"deptHiding\" : true,\n" +
				"    \"deptPerimits\" : \"3|4\",\n" +
				"    \"userPerimits\" : \"userid1|userid2\",\n" +
				"    \"outerDept\" : true,\n" +
				"    \"outerPermitDepts\" : \"1|2\",\n" +
				"    \"outerPermitUsers\" : \"userid3|userid4\",\n" +
				"    \"sourceIdentifier\" : \"source\"\n" +
				"}";

		Map<String, Object> map=addDept("695509705ec63c9fb2791c69a6b3ba7e",body);
		*///
		 String token =	getAccess_token();
	    System.out.println(token);
	}
}
