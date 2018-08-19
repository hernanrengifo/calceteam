package com.calceteam.Customer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/CustomerService")
public class CustomerService {
	private String cloudantAccount = "https://18b96279-5f59-49a4-9165-004088e0ece5-bluemix:484a85aa988edbdecbd63d0ba8c404fd45de65701f8ab3eac23a804ac18e57fd@18b96279-5f59-49a4-9165-004088e0ece5-bluemix.cloudant.com";
	private String cloudantUser = "18b96279-5f59-49a4-9165-004088e0ece5-bluemix";
	private String cloudantPassword = "484a85aa988edbdecbd63d0ba8c404fd45de65701f8ab3eac23a804ac18e57fd";
	private String cloudantHost = "https://18b96279-5f59-49a4-9165-004088e0ece5-bluemix.cloudant.com:443";
	CloudantClient cloudantClient = null;
	private String cloudamt_customer = "calceteam_customer";

	public CustomerService() throws MalformedURLException {
		// cloudantClient = ClientBuilder.account(cloudantUser)
		// .username(cloudantUser).password(cloudantPassword).build();

		cloudantClient = ClientBuilder.account(cloudantUser).username(cloudantUser).password(cloudantPassword).build();
	}

	@PostMapping("/RegisterCustomer")
	String registerCustomer(@RequestBody Customer customer) throws Exception {
		Database db = cloudantClient.database(cloudamt_customer, false);
		Response res = db.save(customer);

		if (res.getStatusCode() != 200) {
			throw new Exception("error creando documento " + res.getReason());
		} else {
			return customer.getCedula();
		}
	}

	@GetMapping("/GetServiceStatus")
	String getServiceStatus() {
		StringBuilder builder = new StringBuilder();
		List<String> databases = cloudantClient.getAllDbs();
		builder.append("Databases:");
		for (String db : databases) {
			builder.append(db);
			builder.append(",");
		}

		return builder.toString();
	}

}
