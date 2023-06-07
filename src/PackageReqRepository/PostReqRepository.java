package PackageReqRepository;
import java.io.IOException;
import java.util.ArrayList;
import PackageCommonFunction.Utilitycommonfunction;


public class PostReqRepository {
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		
		return baseURI;
			
	}
	
	public static String resource() {
		String resource="/api/users";
		
		return resource;
		
	}
	
	public static String requestBody1() throws IOException {
		ArrayList<String>data=Utilitycommonfunction.readdataexcel("Post_Test_Data" , "POST_Class_1");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
		
	}
	public static String requestBody2() throws IOException {
		ArrayList<String>data=Utilitycommonfunction.readdataexcel("Post_Test_Data" , "POST_Class_2");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
		
	}
	public static String requestBody3() throws IOException {
		ArrayList<String>data=Utilitycommonfunction.readdataexcel("Post_Test_Data" , "POST_Class_3");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
		
	}
	public static String requestBody4() throws IOException {
		ArrayList<String>data=Utilitycommonfunction.readdataexcel("Post_Test_Data" , "POST_Class_4");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
		
	}
}
