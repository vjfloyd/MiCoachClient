package com.micoach.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.beans.UserResponse;

@Controller
@RequestMapping("/client")
public class UserController { 

	@RequestMapping(value="/getusers", method = RequestMethod.GET)
	public String saludos(Model model){
		RestTemplate restTemplate = new RestTemplate();
		String SERVER_URI = "http://localhost:8080"; //http://localhost:8080/app/users
		String REST_URI_CONSTANT = "/micoach/users";
		//List<LinkedHashMap> listaUser = restTemplate.getForObject(SERVER_URI + REST_URI_CONSTANT, List.class);
		
		//ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
		//RestTemplate restTemplate = new RestTemplate(requestFactory);
		
		//RestTemplate restTemplate = new RestTemplate();
		/*
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		List<LinkedHashMap> listaUser = restTemplate.getForObject(SERVER_URI + REST_URI_CONSTANT, List.class);
		*/
		
		//String resp = restTemplate.getForObject(SERVER_URI + REST_URI_CONSTANT, String.class);
		//List<LinkedHashMap> listaUser = restTemplate.getf
		System.out.println(SERVER_URI+REST_URI_CONSTANT);
		List<LinkedHashMap<String, Object>> listrest = restTemplate.getForObject(SERVER_URI + REST_URI_CONSTANT, List.class);
		LinkedHashMap<String, Object> element = listrest.get(0);
		System.out.println(element.get("username"));
		//[{"username":"pedro","password":"1234","foto":null,"names":"pedx","dni":"12321","mail":null,"idUser":1,"lastName":"rojas","cellNumber":"123123"}]
		UserResponse userResponse = new UserResponse();
		List<UserResponse> listUserResponse = new ArrayList<UserResponse>();
		for (UserResponse uResponse : listUserResponse) {
			uResponse.setUsername(element.get("username").toString());
			uResponse.setPassword(element.get("password").toString());
			uResponse.setFoto(element.get("foto").toString());
			uResponse.setNames(element.get("names").toString());
			uResponse.setDni(element.get("dni").toString());
			uResponse.setMail(element.get("mail").toString());
			uResponse.setIdUser(new Integer(element.get("idUser").toString()));
			uResponse.setLastName(element.get("lastName").toString());
			
			listUserResponse.add(uResponse);
				
		}
		
		
		/*
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(SERVER_URI + REST_URI_CONSTANT, Object[].class);
		Object[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		*/
		//model.addAttribute("listaUser", listaUser);
		return "usuarios";
	}
	
	@RequestMapping(value="/login")
	public String index(){
		return "index";
	}
	
	  
}
