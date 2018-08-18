package com.calceteam.WPIClient.Service;


import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import com.ibm.watson.developer_cloud.http.Response;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;


@RestController
@EnableAutoConfiguration
@RequestMapping("/PersonalityService")
public class PersonalityService {
	private String serviceURL = "https://gateway.watsonplatform.net/personality-insights/api";
	private String serviceToken = "2f0ea04f-1bce-4e55-8f63-f15848a90f15";
	private String servicePassword = "aw2XYGlIO76S";
	private String serviceVersionDate = "2017-10-13";
	private PersonalityInsights personalityInsights;
	
	public PersonalityService() {
		personalityInsights = new PersonalityInsights(serviceVersionDate, serviceToken, servicePassword);
		personalityInsights.setEndPoint(serviceURL);
	}
	
	@GetMapping("/Ping")
	String ping() {
		return "Ping";
	}
	
	@GetMapping("/GetServiceStatus")
	String getServiceStatus() {
		ServiceCall<String> srvcCall = personalityInsights.getToken();
		Response<String> srvcCallResult = srvcCall.executeWithDetails();
		StringBuilder builder = new StringBuilder();
		for(String headerName: srvcCallResult.getHeaders().names()) {
			builder.append(headerName);
			builder.append(":");
			builder.append(srvcCallResult.getHeaders().values(headerName));
			builder.append("\n");
		}
		builder.append("Result:");
		builder.append(srvcCallResult.getResult());
		return builder.toString();
	}
	
}
