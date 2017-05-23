package com.micoach.web;

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
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("app")
public class UserController { 

	@RequestMapping(value="/getusers", method = RequestMethod.GET)
	public String saludos(Model model){
		RestTemplate restTemplate = new RestTemplate();
		String SERVER_URI = "http://localhost:8080"; //http://localhost:8080/app/users
		String REST_URI_CONSTANT = "/app/users";
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
		List<LinkedHashMap<String, Object>> listrest = restTemplate.getForObject(SERVER_URI + REST_URI_CONSTANT, List.class);
		
		
		/*
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(SERVER_URI + REST_URI_CONSTANT, Object[].class);
		Object[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		*/
		//model.addAttribute("listaUser", listaUser);
		return "usuarios";
	}
}
