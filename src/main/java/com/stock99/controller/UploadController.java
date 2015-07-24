package com.stock99.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.stock99.model.OdersVO;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class UploadController  {

	private static final Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		return "upload";
	}
	
	
}
