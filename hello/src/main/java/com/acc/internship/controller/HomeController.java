package com.acc.internship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.internship.repo.RecordDAO;
import com.acc.internship.repo.RouteDAO;
import com.acc.internship.repo.StationDAO;
import com.acc.internship.repo.UserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private StationDAO stationDao;

	@Autowired
	private RouteDAO routeDao;
	
	@Autowired
	private RecordDAO recordDao;

	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "world") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/")
	public String root(Model model) {
		
		recordDao.getAverageForRouteByHour(1, 19);
		return "index";
	}

	@RequestMapping("/driver")
	public String driver(Model model) {

		return "driver";
	}

}
