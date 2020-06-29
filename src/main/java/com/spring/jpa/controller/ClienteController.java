package com.spring.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jpa.model.Cliente;
import com.spring.jpa.service.ClienteService;

@RestController
@Component
public class ClienteController implements ErrorController {

   // private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";
	
	@Autowired
	private ClienteService clienteService;
		
	@RequestMapping("index")
	public ModelAndView init() {
		return new ModelAndView("index");
	}
//	
//	@RequestMapping(value= "list" ,method = RequestMethod.GET)
//	public ModelAndView list() {
//		return new ModelAndView("list");
//	}
//	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public ModelAndView saveClient(Cliente cliente) {
		clienteService.saveClient(cliente);
		return new ModelAndView("save");
	}

	@GetMapping("/clientes")	
	public ModelAndView index(){
		ModelAndView listView = new ModelAndView("list");
		listView.addObject("clientes",clienteService.listAll());
		return listView;
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Optional<Cliente> getClientePorId(@PathVariable("id") Integer id) {
		return clienteService.findOne(id);
	}
	
	@RequestMapping(value = "/cidade/{cidade}" ,method =RequestMethod.GET)
	public List<Cliente> getClientePorCidade(@PathVariable("cidade") String cidade) {
		return clienteService.listByCity(cidade);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}