package PackageTestClass;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import PackageCommonFunction.APICommonFunction;
import PackageCommonFunction.Utilitycommonfunction;
import PackageReqRepository.PostReqRepository;
import io.restassured.path.json.JsonPath;

public class POST_Class_1 {
	public static void execute() throws IOException {
		
		for (int i=0; i<5; i++)
		{				
			int statusCode=APICommonFunction.statusCode(PostReqRepository.baseURI(), PostReqRepository.resource(), PostReqRepository.requestBody1());
		
		if (statusCode==201)
		{
			String responseBody =APICommonFunction.responseBody(PostReqRepository.baseURI(), PostReqRepository.resource(), PostReqRepository.requestBody1());
			System.out.println(responseBody);
			
		POST_Class_1.validator(statusCode, responseBody);
		Utilitycommonfunction.evidencefilecreator("Sample1", PostReqRepository.requestBody1(), responseBody);
		break;
		}
	
		else {
			System.out.println("Status code is incorrect hence retrying the API");
		}
		}
	}
		
		public static void validator(int statusCode, String responseBody) throws IOException {
		
		JsonPath jspreq=new JsonPath(PostReqRepository.requestBody1());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");

		String expDate=LocalDateTime.now().toString().substring(0,10);
		
		JsonPath jspres=new JsonPath(responseBody);
		String res_name=jspres.getString("name");
		String res_job=jspres.getString("job");
		String res_id=jspres.getString("id");
		String res_createdAt=jspres.getString("createdAt").substring(0,10);
		
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(res_createdAt, expDate);
		
		System.out.println("Validation Successful");
	}

}
