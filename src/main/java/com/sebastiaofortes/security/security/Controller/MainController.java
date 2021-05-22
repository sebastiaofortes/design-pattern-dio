package com.sebastiaofortes.security.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sebastiaofortes.security.security.Usuariorepository;
import com.sebastiaofortes.security.security.Model.Usuarios;



@RequestMapping(path="/main")
@Controller
public class MainController {
	
	@Autowired
	private Usuariorepository userRepository;

	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String name
	      , @RequestParam String email) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Usuarios n = new Usuarios();
	    n.setNome("sebastiao");
	    n.setEmail("fortes4");
	    userRepository.save(n);
	    return "Saved";
	  }
	
	@RequestMapping("/teste-sql")
	public String index() {

	    Usuarios n = new Usuarios();
	    n.setNome("sebastiao");
	    n.setEmail("fortes4");
	    userRepository.save(n);
		
		return "testesql";
	}
	
	@RequestMapping("/sobre")
	public String sobre() {

		return "sobre";
	}
	
	@RequestMapping("/home")
	public String home() {

		return "home";
	}
}
