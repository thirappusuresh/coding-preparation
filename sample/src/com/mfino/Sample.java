package com.mfino;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Sample {
	public static void main(String[] args) {
		//try {
			//File uploadFile1 = new File("C:\\Users\\Suresh\\Desktop\\emp_pics\\MPS011.jpg");
/*				HttpResponse response = HttpRequest
						.post("http://localhost:8080/api/jsonws/dlapp/get-file-entry-by-uuid-and-group-id")
						.form("groupId ", "10181")
						.form("articleId ", "15207")
						.basicAuthentication("test@liferay.com", "test")
						.send();*/
/*			HttpResponse response = HttpRequest
					.post("http://localhost:8080/api/jsonws/journalarticle/get-display-article-by-url-title")
					.form("groupId","10194")
					.form("urlTitle","suresh-content")
					.basicAuthentication("test@liferay.com", "test")
					.send();
			System.out.println(response.statusCode());
			System.out.println(response.statusPhrase());
			System.out.println(response.body());
			JSONObject newJSON = new JSONObject(response.body().toString());
			System.out.println(newJSON.get("content").toString());
			DocumentBuilderFactory documentBuilderFactory1 = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder1 = documentBuilderFactory1
					.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(newJSON.get("content").toString()));
			Document document1 = documentBuilder1.parse(is);

			document1.getDocumentElement().normalize();
			NodeList nlList1 = document1.getElementsByTagName("root");
			Element eElement1 = (Element) nlList1.item(0);
			NodeList nlList = eElement1.getElementsByTagName("static-content");
			for (int indx = 0; indx < nlList.getLength(); indx++) {
				Element eElement = (Element) nlList.item(indx);
				if (eElement.getAttribute("language-id").equals("en_US")) {
					System.out.println("\n");
					System.out.println(eElement.getTextContent());
				} 
			}*/
/*				HttpRequest httpRequest = HttpRequest.post("http://103.231.102.196:9090/mfsportal/subscriberDashboard.do");
				httpRequest.form("mdnId", "2000020000");
				httpRequest.form("role", "RETAIL_SUBSCRIBER");
				httpRequest.form("requestFor", "POCKET");
				httpRequest.form("tenantCode", "citi");
				httpRequest.form("url", "subscriberDashboard.do");
				httpRequest.basicAuthentication("2000020000", "123456");
				HttpResponse response2 = httpRequest.send();
				System.out.println(response2.body().toString());*/
			
			

/*		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

/*		URL url = new URL(
				"http://192.168.1.5:7070/portal/j_spring_security_check");
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(
				conn.getOutputStream());

		writer.write("tenantCode=axis&j_username:1000000000&j_password:123456&submit=Login");
		writer.flush();
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		writer.close();
		reader.close();*/
		
	     

	     
    	try {   
    		// get the property values
    		String requestURL = "https://rest.nexmo.com/sms/json?";
    		String REQUESTTYPE = "SMSSubmitReq";
    		String USERNAME = "MMONEY";
    		String PASSWORD = "aircel";
    		String ORIGIN_ADDR = "DD-AIRCEL";
    		String TYPE = "0";
			 
	        // build the request message
	        StringBuilder data = new StringBuilder();
	        data.append("REQUESTTYPE=" + URLEncoder.encode(REQUESTTYPE, "UTF-8"));
	        data.append("&USERNAME=" + URLEncoder.encode(USERNAME, "UTF-8"));
	        data.append("&PASSWORD=" + URLEncoder.encode(PASSWORD, "UTF-8"));
	        data.append("&MOBILENO=" + URLEncoder.encode("918374263385", "UTF-8"));
	        data.append("&ORIGIN_ADDR=" + URLEncoder.encode(ORIGIN_ADDR, "UTF-8"));
	        data.append("&MESSAGE=" + URLEncoder.encode("test sms", "UTF-8"));
	        data.append("&TYPE=" + URLEncoder.encode(TYPE, "UTF-8"));
	        
	        // prepare HTTP connection
	        URL address = new URL(requestURL);
	        HttpURLConnection connection = (HttpURLConnection) address.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	 
	        // send Sms data
	        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
	        out.writeBytes(data.toString());
	        out.flush();
	        out.close();
	        
	        // read response
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String inputLine;
	 
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	            response.append("\n");
	        }
	        in.close();
     
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    	
    
	     
	}
}
