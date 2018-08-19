package com.calceteam.WPIClient.Service;


import java.util.List;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import com.calceteam.WPIClient.User.UserService;
import com.calceteam.WPIClient.User.WPIContent;
import com.ibm.watson.developer_cloud.http.Response;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions.Builder;


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
	
	@GetMapping("/Profile/{userId}")
	Profile calculateProfile(@PathVariable String userId) {
		UserService userService = new UserService();
		List<WPIContent> content =userService.getUserContentByUser(userId);
		Builder profileOptionsBuilder = new ProfileOptions.Builder();
		Content.Builder cbuilder = new Content.Builder();
		for(WPIContent item : content) {
			ContentItem citem = new ContentItem.Builder()
					.content(item.getContent())
					.forward(item.isForward()).reply(item.isReply())
					.parentid(item.getParentContentUUID()).language(item.getLanguaje()).build();
			cbuilder.addContentItem(citem);
		}
		profileOptionsBuilder.content(cbuilder.build());
		profileOptionsBuilder.acceptLanguage("es").consumptionPreferences(true);
		ServiceCall<Profile> profile = 
				personalityInsights.profile(profileOptionsBuilder.build());
		
		Response<Profile> response = profile.executeWithDetails();
		
		return response.getResult();
		
	}
	
}
