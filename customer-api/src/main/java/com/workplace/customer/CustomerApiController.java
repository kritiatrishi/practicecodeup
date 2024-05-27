package com.workplace.customer;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags= {"Customer API"})
public class CustomerApiController {
	@Autowired
	private CustomerApiService customerApiService;
	
	@ApiIgnore
	@PostMapping(value="/customers/api/audit/v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name="text",value="Value of Audit Data",required=true,
				paramType="header",dataType = "java.lang.String"),
		@ApiImplicitParam(name="timestamp",value="TimeStamp",required=true,
				paramType="header",dataType = "java.sql.Timestamp"),
		
		@ApiImplicitParam(name="code",value="Value of Code",required=true,
		paramType="header",dataType = "java.lang.String"),
		@ApiImplicitParam(name="status",value="Value of Status",
		paramType="header",dataType = "java.lang.String")
	})
	
	@RequestMapping("/events")
	public String eventMethod() 
	{
		
		return "Events";
	}
	@RequestMapping("/event")
	public List<Payload> getAllMethod() 
	{
		
		return customerApiService.getAllPayload();
	}
	@RequestMapping("/customers")
	public String addMethod() 
	{
		
		return "Hi";
	}
}
