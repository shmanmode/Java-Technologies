package com.cdac.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdac.dao.FlightDao;
import com.cdac.entity.Flight;

@Controller
public class AddFlightController {

	@Autowired
	private FlightDao dao;
	
	
	
	@RequestMapping(value="/addFlightController", method=RequestMethod.GET)
	public String add(Map<String, Object>model,@RequestParam("source") String src , Flight flight) {
		dao.add(flight);
		
		model.put("message" ,""+src+"");
		
		return "confirmation.jsp";
	}
	@RequestMapping(value="/searchFlightController", method=RequestMethod.GET)
	public @ResponseBody Flight SearchFilghtData(@RequestParam("flightNo") int flightNo)
	{
		Flight f = dao.find(flightNo);
		return f;
	}
}

/* this code is provided by spring:
 * the code for storing request data in an object
 
Flight f = new Flight();
f.setFlightNo(request.getParameter("flightNo"));
..
*/