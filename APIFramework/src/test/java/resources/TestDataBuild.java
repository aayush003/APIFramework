package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String language, String address)
	{
		
				AddPlace p = new AddPlace();
				p.setAccuracy(50);
				p.setAddress(address);
				p.setLanguage(language);
				p.setPhone_number("(+91) 999 999 8888");
				p.setWebsite("https://google.com");
				p.setName(name);
				List<String> myList = new ArrayList<String>();
				myList.add("shoe park");
				myList.add("shop");
				p.setTypes(myList);

				Location l = new Location();
				l.setLat(-38.1234);
				l.setLng(33.1234);
				p.setLocation(l);
				
				return p;
		
	}
	
	public String deletePlacePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"   \t \t\r\n}";
	}
	
}
