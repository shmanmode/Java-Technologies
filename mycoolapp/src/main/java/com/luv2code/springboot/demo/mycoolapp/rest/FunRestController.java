package com.luv2code.springboot.demo.mycoolapp.rest;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springboot.demo.mycoolapp.dataDelivery;

@RestController
public class FunRestController {
		
	// expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	@GetMapping("/data")
	public SolrDocumentList getData() throws SolrServerException, IOException {
		final dataDelivery x = new dataDelivery();
		return x.get_data();
	}

}












