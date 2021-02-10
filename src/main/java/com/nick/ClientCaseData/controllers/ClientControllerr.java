package com.nick.ClientCaseData.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nick.ClientCaseData.models.Client;
import com.nick.ClientCaseData.models.User;
import com.nick.ClientCaseData.services.ClientService;
import com.nick.ClientCaseData.services.UserService;

@Controller
public class ClientControllerr {
	@Autowired
	private ClientService clientService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/dashboard")
	private String dash(HttpSession session, Model model) {
		Long userId = (Long)session.getAttribute("user_id");
		List<Client> client = clientService.getAllClients();
		model.addAttribute("user", this.userService.findUser(userId));
		model.addAttribute("client", client);
		return "dashboard.jsp";
	}
	
	@GetMapping("/client/new")//question for jon about model attribute
	public String createClientPage(@ModelAttribute("client") Client client, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		model.addAttribute("user_id", userId);
		return "newClient.jsp";
	}
	@PostMapping("/client/new")
	public String createClient(@Valid @ModelAttribute("client") Client client, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			model.addAttribute("user_id", userId);
			return "newClient.jsp";
		}
		else {
			clientService.createClient(client);
			return "redirect:/dashboard";
		}
	}
//	@GetMapping("/client/{id}")
//	public String showClient(Model model, @PathVariable("id") Long id) {
//		Client client = clientService.findById(id);
//		model.addAttribute("client", client);
//		return "showClient.jsp";
//	}
	
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
    	this.clientService.deleteClient(id);
    	return "redirect:/dashboard";
    }
	@GetMapping("/edit/{id}")
	public String editClient(@PathVariable("id") Long id, @ModelAttribute("client") Client client, Model viewModel, HttpSession session) {
		Client currentClient = this.clientService.findById(id);
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("client", currentClient);
		viewModel.addAttribute("user_id", userId);
		return "editClient.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String updatedClient(@Valid @ModelAttribute("client") Client client, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			Client currentClient = this.clientService.findById(id);
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("client", currentClient);
			viewModel.addAttribute("user_id", userId);
			return "editClient.jsp";
		}
		
		this.clientService.updateClient(client);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search/clients")
	public String Search(@RequestParam("name") String name, Model model) {
		List<Client> client = clientService.searchForClientByName(name);
		model.addAttribute("name", name);
		model.addAttribute("clientsByName", client);
		return "clients.jsp";
	}
}
