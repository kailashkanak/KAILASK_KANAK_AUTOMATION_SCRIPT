package esyaHes;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileWriter;

import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetBLP3 
{
	//@Test
	public void getData()
	{
		Response response = given()
								.headers("content-type","application/json")
							.when()
								.get("http://localhost:3000/students/2");
							
		int statusCode = response.getStatusCode();
		
		String body = response.asPrettyString();
		
		
		System.out.println(body);
	}
	
	@Test
	public void getRequest()
	{
		RestAssured.baseURI="http://localhost:3000/students";
		
		RequestSpecification http = RestAssured.given();
		
		Response response = http.request(Method.GET,"/2");
		
		int resCode = response.getStatusCode();
		
		JsonPath js = response.jsonPath();
		
		String id = js.get("id");
		
		String name = js.get("name");
		
		String age = js.get("age");
				
		String grade = js.get("grade");
		
		try
		{
			FileWriter outputfile = new FileWriter("C:\\Users\\KAILASH PRASAD KANAK\\eclipse-workspace\\Esya_Hes_RestAutomation\\Test_Report\\BLP3.csv");
			
			CSVWriter writer = new CSVWriter(outputfile);
			
			String[] header = {"ID","Name","Age","Grade"};
			
			writer.writeNext(header);
			
			String[] data = {id,name,age,grade};
			
			writer.writeNext(data);
			
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
