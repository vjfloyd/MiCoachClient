package com.micoach.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.micoach.domain.Person;


@Controller
@RequestMapping("micoach")
public class PersonControllers {


	@RequestMapping("/index")
	public String saludos(Model model){
		model.addAttribute("person", new Person()); 
		return "index";
	}
	
	
	 @RequestMapping(value = "/redireccionar", method = RequestMethod.POST)
	 public String submit(@Valid @ModelAttribute("person")Person person, 
		      BindingResult result, ModelMap model, HttpServletRequest request) {
		String var = person.getName();
		request.getSession().setAttribute("person", var);
		model.addAttribute("person", var); 
        return "redirect:/micoach/visita";
    }
	 
	@RequestMapping(value="/visita")
	public String visita(Model model, HttpServletRequest request){
		String persona = (String) request.getSession().getAttribute("person");
		model.addAttribute("personx", persona);
		return "visita";
	}
	
	  
}