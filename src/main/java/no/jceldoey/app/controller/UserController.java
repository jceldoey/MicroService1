package no.jceldoey.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String hiThere(@PathVariable String name){

		String response = "Hi there, " + name;

		return response;
	}
}
