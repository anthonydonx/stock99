package com.stock99.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
//import net.sf.json.JsonConfig;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stock99.model.JsonObjectUtil;
import com.stock99.service.AbstractService;

public abstract class AbstractController<E extends Serializable, T extends Serializable> {

	public abstract Logger getLogger();

	public abstract AbstractService<E> getService();

	public abstract JsonConfig getConfig();

	public abstract String getControllerName();

	/**
	 * get view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getView() {
		return getControllerName();
	}

	/**
	 * add
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	void add(E valueObject, HttpServletResponse httpServletResponse) {
		// JSONObject json = new JSONObject();
		try {

			String msg = getService().add(valueObject);
			/*
			 * json.put("message", msg); json.put("success", true);
			 * writeJsonString(httpServletResponse, json.toString());
			 */
			writeJsonString(httpServletResponse, "{\"message\":\"" + msg
					+ "\",\"success\":true}");
		} catch (Exception e) {
			/*
			 * json.put("message", e.getMessage()); json.put("success", false);
			 * getLogger().error(e.getMessage());
			 */
			e.printStackTrace();
			// writeJsonString(httpServletResponse, json.toString());

			getLogger().error(e.getMessage());
			writeJsonString(httpServletResponse,
					"{\"message\":\"" + e.getMessage()
							+ "\",\"success\":false}");
		}

	}
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	void update(E valueObject, HttpServletResponse httpServletResponse) {
		// JSONObject json = new JSONObject();
		try {

			String msg = getService().update(valueObject);
			/*
			 * json.put("message", msg); json.put("success", true);
			 * writeJsonString(httpServletResponse, json.toString());
			 */
			writeJsonString(httpServletResponse, "{\"message\":\"" + msg
					+ "\",\"success\":true}");
		} catch (Exception e) {
			/*
			 * json.put("message", e.getMessage()); json.put("success", false);
			 * getLogger().error(e.getMessage());
			 */
			e.printStackTrace();
			// writeJsonString(httpServletResponse, json.toString());

			getLogger().error(e.getMessage());
			writeJsonString(httpServletResponse,
					"{\"message\":\"" + e.getMessage()
							+ "\",\"success\":false}");
		}

	}

	

	/**
	 * delete
	 */
	@RequestMapping(value = "{Id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable T Id, HttpServletResponse httpServletResponse)
			throws IOException {
		// JSONObject json=new JSONObject();
		try {

			String message = getService().delete(Id);
			/*
			 * json.put("msg", message); json.put("success", true);
			 * writeJsonString(httpServletResponse, json.toString());
			 */
			writeJsonString(httpServletResponse, "{\"msg\":\"" + message
					+ "\",\"success\":true}");
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException) {
				String msg = "This item cannot be deleted, because it has already been used elsewhere in the system";
				/*
				 * json.put("msg", msg); json.put("success", false);
				 * writeJsonString(httpServletResponse,json.toString());
				 */
				writeJsonString(httpServletResponse, "{\"msg\":\"" + msg
						+ "\",\"success\":false}");
			} else {
				String msg = "Delete fail.";
				/*
				 * json.put("msg", msg); json.put("success", false);
				 * writeJsonString(httpServletResponse,json.toString());
				 */
				writeJsonString(httpServletResponse, "{\"msg\":\"" + msg
						+ "\",\"success\":false}");
			}
			getLogger().error(e.getMessage());

		}
	}

	/**
	 * get
	 */
	@RequestMapping(value = "{Id}", method = RequestMethod.GET)
	public void get(@PathVariable T Id, HttpServletResponse httpServletResponse) {

		try {

			E valuObj = getService().get(Id);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node2 = new ObjectNode(mapper.getNodeFactory());
			JsonObjectUtil<E> jsonUtil = new JsonObjectUtil<E>();
			String m = jsonUtil.getJsonObjectDataDetail(valuObj, 2);
			// System.out.println(m);
			ObjectNode node = mapper.readValue(m, ObjectNode.class);

			node2.put("Data", node);
			node2.put("success", true);
			writeJson(httpServletResponse, node2, mapper);
		} catch (Exception e) {
			/*
			 * json.put("Data", e.getMessage()); json.put("success", false);
			 * getLogger().error(e.getMessage());
			 * writeJsonString(httpServletResponse, json.toString());
			 */

			getLogger().error(e.getMessage());
			writeJsonString(httpServletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");
		}
	}

	/**
	 * get All
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public void get(HttpServletResponse httpServletResponse) {

		try {

			List<E> valuObj = getService().getAll();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node2 = new ObjectNode(mapper.getNodeFactory());

			JsonObjectUtil<E> jsonUtil = new JsonObjectUtil<E>();
			String m = jsonUtil.getJsonObjectDataDetail(valuObj, 2);
			// System.out.println(m);
			ArrayNode node = mapper.readValue(m, ArrayNode.class);
			node2.put("Data", node);
			node2.put("success", true);

			writeJson(httpServletResponse, node2, mapper);
		} catch (Exception e) {
			/*
			 * e.printStackTrace(); json.put("Data", e.getMessage());
			 * json.put("success", false); getLogger().error(e.getMessage());
			 * writeJsonString(httpServletResponse, json.toString());
			 */
			e.printStackTrace();
			getLogger().error(e.getMessage());
			writeJsonString(httpServletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");
		}
	}

	protected void writeJson(HttpServletResponse httpServletResponse,
			ObjectNode node2, ObjectMapper mapper) {
		try {
			httpServletResponse.setContentType("application/json");
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setHeader("Access-Control-Allow-Headers",
					"X-HTTP-Method-Override");
			httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
			httpServletResponse.setHeader("Access-Control-Allow-Methods",
					"POST, GET, DELETE,OPTION");
			// httpServletResponse.setHeader("Access-Control-Allow-Headers",
			// "X-PINGOTHER");
			httpServletResponse.setHeader("Access-Control-Max-Age", "1728000");

			mapper.writeValue(httpServletResponse.getWriter(), node2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * write given message in json
	 * 
	 * @param httpServletResponse
	 * @param msg
	 */
	protected void writeJsonString(HttpServletResponse httpServletResponse,
			String msg) {
		try {
			httpServletResponse.setContentType("application/json");
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setHeader("Access-Control-Allow-Headers",
					"X-HTTP-Method-Override");
			httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
			httpServletResponse.setHeader("Access-Control-Allow-Methods",
					"POST, GET, DELETE,OPTION");
			// httpServletResponse.setHeader("Access-Control-Allow-Headers",
			// "X-PINGOTHER");
			httpServletResponse.setHeader("Access-Control-Max-Age", "1728000");
			httpServletResponse.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
