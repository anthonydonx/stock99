package com.stock99.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JsonConfig;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock99.model.UserVO;
import com.stock99.service.AbstractService;
import com.stock99.service.UserManager;

/**
 * Sample controller for going to the home page with a message
 */
@RequestMapping(value = "/profile")
@Controller
public class ProfileController extends AbstractController<UserVO, String> {
	Logger logger = Logger.getLogger(ProfileController.class);
	@Value("#{applicationProperties['application.uploadUrl']}") String imageUrl;
	@Value("#{applicationProperties['application.uploadUrl']}") String uploadUrl;
	
	@Autowired
	UserManager userManager;

	
	
	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return logger;
	}

	@Override
	public AbstractService<UserVO> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getControllerName() {
		// TODO Auto-generated method stub
		return "profile";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, 
            HttpServletResponse response,HttpSession session)throws ServletException, java.io.IOException {

		boolean isMultipart;
		String filePath;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		filePath = uploadUrl;

		// Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File(filePath));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();

	    
	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {
	            // Get the uploaded file parameters
	            String fieldName = fi.getFieldName();
	            String fileName = fi.getName();
	            String contentType = fi.getContentType();
	            boolean isInMemory = fi.isInMemory();
	            long sizeInBytes = fi.getSize();
	            // Write the file
	            if( fileName.lastIndexOf("\\") >= 0 ){
	               file = new File( filePath + 
	               fileName.substring( fileName.lastIndexOf("\\"))) ;
	            }else{
	               file = new File( filePath + 
	               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	            }
	            fi.write( file ) ;
	          //  out.println("Uploaded Filename: " + fileName + "<br>");
	         try {
	        	 Object	uname=session.getAttribute("uname");
	        	UserVO userVO= userManager.get(String.valueOf(uname));
	        	userVO.setUrl(fileName);
	        	userManager.update(userVO);
	        	 
			} catch (Exception e) {
				 writeJsonString(response, "{\"Data\":\"" + "Url setting problem"
							+ "\",\"success\":true}");
		         
			}   
	           
	            writeJsonString(response, "{\"Data\":\"" + fileName
						+ "\",\"success\":true}");
	         }
	      }
	     
	   }catch(Exception ex) {
	       System.out.println(ex);
	       writeJsonString(response,
					"{\"Data\":\"" + ex.getMessage() + "\",\"success\":false}");
	   }
	   }
	}


