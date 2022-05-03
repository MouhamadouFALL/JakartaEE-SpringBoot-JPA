package sn.esmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParametresController {
	
	@GetMapping({"/", "index"})
	public String passe(Model model) {
		
		String title = "Spring MVC";
		String intitule = "Bienvenue sur la page Spring MVC";
		
		model.addAttribute("viewTitle", title);
		model.addAttribute("intitule", intitule);
		
		return "index";
	}

}
