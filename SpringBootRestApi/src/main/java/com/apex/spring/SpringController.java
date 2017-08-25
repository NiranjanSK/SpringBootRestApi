package com.apex.spring;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
	
	@RequestMapping("/upload")
	public String uploadFile(){
		try {
			JSONParser parser = new JSONParser();
			
			//Reading Json file
			JSONArray jArray = (JSONArray) parser.parse(new FileReader("d:\\RestApi\\RestFile.json"));
			FileWriter file = new FileWriter("d:\\RestApi\\outFile.json");
			for(Object obj : jArray){
				JSONObject jsonObject =  (JSONObject) obj;
				String name = (String) jsonObject.get("name");
	            System.out.println(name);
	            String city = (String) jsonObject.get("city");
	            System.out.println(city);
	            String job = (String) jsonObject.get("state");
	            System.out.println(job);
	            file.write(jsonObject.toJSONString());
	            file.flush();
			}
			
		} catch (IOException | ParseException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}

}
