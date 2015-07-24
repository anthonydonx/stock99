package com.stock99.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stock99.model.DailyOdersVO;
import com.stock99.model.GrnVO;
import com.stock99.model.JsonObjectUtil;
import com.stock99.model.OdersVO;
import com.stock99.service.AbstractService;
import com.stock99.service.DailyOdersManager;
import com.stock99.service.GrnManager;
import com.stock99.service.OderManager;

@RequestMapping(value = "/grnin")
@Controller
public class GrnController extends AbstractController<GrnVO, Integer> {
	Logger logger = Logger.getLogger(GrnController.class);
	@Autowired
	GrnManager grnManager;
	@Autowired
	OderManager oderManager;
	@Autowired
	DailyOdersManager dailyOdersManager;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public AbstractService<GrnVO> getService() {
		return grnManager;
	}

	@Override
	public JsonConfig getConfig() {
		return null;
	}

	@Override
	public String getControllerName() {
		return "grnin";
	}

	@RequestMapping(value = "/addGrn", method = RequestMethod.POST)
	public void addGin(HttpServletResponse httpservletResponse,
			@ModelAttribute GrnVO grnVO, @RequestParam("oderId") Integer oderId) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String current = dateFormat.format(date);

		try {
			OdersVO oderVO = oderManager.get(oderId);
			/*
			 * DailyOdersVO dailyOder = dailyOdersManager.getDailyOder(oderId,
			 * current).get(0); dailyOder.setDayIss(dailyOder.getDayIss() +
			 * grnVO.getQuantity());
			 */
			Integer finalQuantity = oderVO.getAllowedQuantity()
					- grnVO.getQuantity();
			if (finalQuantity >= 0) {
				// dailyOdersManager.update(dailyOder);

				// Update OderVO details
				oderVO.setAllowedQuantity(finalQuantity);
				oderVO.setGrnQty(oderVO.getGrnQty() + grnVO.getQuantity());
				oderManager.update(oderVO);

				grnVO.setOrders(oderVO);
				grnVO.setDate(current);
				String status = grnManager.add(grnVO);
				System.out.print(status);
				writeJsonString(httpservletResponse, "{\"Data\":\"" + status
						+ "\",\"success\":true}");
			} else {
				writeJsonString(httpservletResponse, "{\"Data\":\""
						+ "Not enough" + "\",\"success\":false}");

			}
		} catch (Exception e) {
			System.out.print(e);
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}
	}

	@RequestMapping(value = "/getGRNFromOderId", method = RequestMethod.GET)
	public void getGRNFromOderId(HttpServletResponse httpservletResponse,
			@RequestParam String oderId, @RequestParam String status) {

		try {
			List<GrnVO> valueObj = grnManager.getGRNFromOderId(oderId, status);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<GrnVO> jsonUtil = new JsonObjectUtil<GrnVO>();
				String m = jsonUtil.getJsonObjectDataDetail(valueObj, 1);
				ArrayNode node = mapper.readValue(m, ArrayNode.class);
				objectNode.put("Data", node);
				objectNode.put("success", true);
				writeJson(httpservletResponse, objectNode, mapper);
			} else {
				writeJsonString(httpservletResponse,
						"{\"Data\":\"Empty\",\"success\":false}");
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}

	}

	/* Get ALL GRN FOR GRN REPORT */

	@RequestMapping(value = "/getAllGRNById", method = RequestMethod.GET)
	public void getAllGRNById(HttpServletResponse httpservletResponse,
			@RequestParam String oderId) {

		try {
			List<GrnVO> valueObj = grnManager.getAllGRNById(oderId);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<GrnVO> jsonUtil = new JsonObjectUtil<GrnVO>();
				String m = jsonUtil.getJsonObjectDataDetail(valueObj, 1);
				ArrayNode node = mapper.readValue(m, ArrayNode.class);
				objectNode.put("Data", node);
				objectNode.put("success", true);
				writeJson(httpservletResponse, objectNode, mapper);
			} else {
				writeJsonString(httpservletResponse,
						"{\"Data\":\"Empty\",\"success\":false}");
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}

	}

	@Transactional
	@RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
	public void saveBooking(HttpServletResponse httpservletResponse,
			@RequestParam("grnId") Integer grnId) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String current = dateFormat.format(date);
		try {
			GrnVO grnVO = grnManager.get(grnId);

			// Update oders booking details
			OdersVO odersVO = oderManager.get(grnVO.getOrders().getOderId());
			odersVO.setGrnQty(odersVO.getGrnQty() - grnVO.getQuantity());
			odersVO.setBookingQty(odersVO.getBookingQty() + grnVO.getQuantity());
			oderManager.update(odersVO);

			grnVO.setStatus("booking");
			grnVO.setBookingDate(current);
			grnVO.setBookingUserId("1");
			String status = grnManager.update(grnVO);

			if (grnVO != null) {

				writeJsonString(httpservletResponse, "{\"Data\":\"" + status
						+ "\",\"success\":true}");
			} else {
				writeJsonString(httpservletResponse, "{\"Data\":\"" + status
						+ "\",\"success\":false}");
			}
		} catch (Exception e) {
			System.out.print(e);
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}

	}

	@RequestMapping(value = "/issuedGRN", method = RequestMethod.POST)
	public void issuedGRN(HttpServletResponse httpservletResponse,
			@RequestParam("grnId") Integer grnId) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String current = dateFormat.format(date);
		try {

			GrnVO grnVO = grnManager.get(grnId);
			grnVO.setStatus("issued");

			// Update Daily isseued
			DailyOdersVO dailyOder = dailyOdersManager.getDailyOder(
					grnVO.getOrders().getOderId(), current).get(0);
			dailyOder.setDayIss(dailyOder.getDayIss() + grnVO.getQuantity());
			dailyOdersManager.update(dailyOder);

			OdersVO odersVO = grnVO.getOrders();
			odersVO.setBookingQty(odersVO.getBookingQty() - grnVO.getQuantity());
			odersVO.setGinQty(odersVO.getGinQty() + grnVO.getQuantity());
			oderManager.update(odersVO);
			grnVO.setIssuedDate(current);
			grnVO.setIssuedUserId("1");
			String status = grnManager.update(grnVO);

			if (grnVO != null) {
				writeJsonString(httpservletResponse, "{\"Data\":\"" + status
						+ "\",\"success\":true}");
			} else {
				writeJsonString(httpservletResponse, "{\"Data\":\"" + status
						+ "\",\"success\":true}");
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}

	}

}
