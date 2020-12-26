package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req == null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req  = new RequestSpecBuilder().setBaseUri(getGlobalvalue("baseUrl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.setContentType(ContentType.JSON).build();

			return req;
		}
		return req;

	}

	public String getGlobalvalue(String key) throws IOException
	{

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Eclipse workspace-20200724T163020Z-001\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	public String getJsonPath(Response response, String key)
	{

		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
