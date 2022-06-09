package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.service.UserService;


@Controller 
@RequestMapping(path="/demo") 
public class MainController {
  @Autowired 
  private UserService userService;

//  @PostMapping(path="/add") // Map ONLY POST Requests
//  public @ResponseBody String addNewUser (@RequestParam String name
//      , @RequestParam String email) {
//
//    User n = new User();
//    n.setName(name);
//    n.setEmail(email);
//    userRepository.save(n);
//    return "Saved";
//  }

//  @GetMapping(path="/all")
//  public String getAllUsers(Model model) {
//
//	  model.addAttribute("all",userRepository.findAll());
//	  return "index";
//  }
  
  
  @GetMapping(value = "/list")
  public String list(
		  @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		   Model model) {
	  Pageable pageable = Pageable.ofSize(5).withPage(page);
//	  Page<User> userPage = userService.findAllByRepository(pageable);
	  Page<User2> userPage = userService.findAllByMapper(pageable);
	  
	  System.out.println(userPage.getTotalPages());
	  
	  // この辺りは、form に持たせたい
	  model.addAttribute("page", userPage);
      model.addAttribute("users", userPage.getContent());
      model.addAttribute("pageNum", userPage.getPageable().getPageNumber());
      
      PageForm p = new PageForm(userPage);
      
      
      userPage.getPageable().hasPrevious();
      
      
      return "index";
  }
}