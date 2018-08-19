package com.calceteam.WPIClient.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

@RestController
@EnableAutoConfiguration
@RequestMapping("/UserService")
public class UserService {
	private String cloudantAccount = "https://18b96279-5f59-49a4-9165-004088e0ece5-bluemix:484a85aa988edbdecbd63d0ba8c404fd45de65701f8ab3eac23a804ac18e57fd@18b96279-5f59-49a4-9165-004088e0ece5-bluemix.cloudant.com";
	private String cloudantUser = "18b96279-5f59-49a4-9165-004088e0ece5-bluemix";
	private String cloudantPassword = "484a85aa988edbdecbd63d0ba8c404fd45de65701f8ab3eac23a804ac18e57fd";
	private String cloudantHost = "https://18b96279-5f59-49a4-9165-004088e0ece5-bluemix.cloudant.com:443";
	CloudantClient cloudantClient = null;
	private String cloudamt_userDB = "calceteam_wpiuser";
	private String cloudant_contentDB = "calceteam_wpicontent";

	public UserService() throws MalformedURLException {
		cloudantClient = ClientBuilder.account(cloudantUser)
				.username(cloudantUser).password(cloudantPassword).build();
	}
	
	@GetMapping("/Ping")
	String ping() {
		return "ping";
	}
	
	@GetMapping("/GetServiceStatus")
	String getServiceStatus() {
		StringBuilder builder  = new StringBuilder();
		List<String> databases = cloudantClient.getAllDbs();
		builder.append("Databases:");
		for ( String db : databases ) {
			builder.append(db);
			builder.append(",");
		}
		
		return builder.toString();
	}
	
	@PostMapping("/User")
	String createWPIUser(WPIUser user) throws Exception {
		Database db =	cloudantClient.database(cloudamt_userDB, false);
		Response res = db.save(user);
		
		if(res.getStatusCode() != 200) {
			throw new Exception("error creando documento " + res.getReason());
		}else {
			return user.getUserFacebookUUID();
		}
	}
	
	@GetMapping("/User")
	WPIUser getWPIUser(@PathVariable String userId) throws Exception {
		Database db =	cloudantClient.database(cloudamt_userDB, false);
		WPIUser res = db.find(WPIUser.class, userId);
		return res;
	}
	
	@PostMapping("/Content")
	String createUserContent(WPIContent content) throws Exception {
		Database db =	cloudantClient.database(cloudamt_userDB, false);
		Response res = db.save(content);
		
		if(res.getStatusCode() != 200) {
			throw new Exception("error creando documento " + res.getReason());
		}else {
			return content.getContentUUID();
		}
	}
	
	@GetMapping("/Content")
	WPIContent getUserContent(@PathVariable String userContentId) throws Exception {
		Database db =	cloudantClient.database(cloudamt_userDB, false);
		WPIContent res = db.find(WPIContent.class, userContentId);
		return res;
	}
	
	
	
	
}
