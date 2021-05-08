package com.project.shareMed.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.shareMed.entites.Party;
import com.project.shareMed.entites.Product;
import com.project.shareMed.services.PartyService;
import com.project.shareMed.services.ProductService;

@RestController
public class Controller {
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private ProductService productServive;
	
	@GetMapping("/")
	public Map<String, Object> home() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("partyId", "2");
		returnMap.put("partyName", "Madhi krishnan");
		returnMap.put("partyDesc", "This is decs");
		returnMap.put("partyAge", "22");
		return returnMap;
	}
	
	@PostMapping(path="/addUser",consumes="application/json")
	public Map<String, Object> addUser(@RequestBody Party party) {
		return (Map<String, Object>) this.partyService.createParty(party);
	}
	
	@PostMapping("/checkLogin")
	public Map<String, Object> checkLogin(@RequestBody Party party){
		return  partyService.checkLogin(party);
	}
	
	@GetMapping("/getProductList")
	public List<Product> getProductList() {
		return productServive.getProductList();
	}
	
	
}
