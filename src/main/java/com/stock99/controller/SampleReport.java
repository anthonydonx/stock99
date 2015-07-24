package com.stock99.controller;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class SampleReport {
	public static void main(String args[]){
		JasperPrint jasperPrint = null;
		 try {
	        String jr =JasperCompileManager.compileReportToFile("/media/anthonydonx/company/barcodeprint.jrxml");
	         jasperPrint = JasperFillManager.fillReport(jr, new HashMap(),
	                 new JREmptyDataSource());
	         JasperViewer jasperViewer = new JasperViewer(jasperPrint);
	         jasperViewer.setVisible(true);
	     } catch (JRException ex) {
	         ex.printStackTrace();
	     }
	}
	
}
