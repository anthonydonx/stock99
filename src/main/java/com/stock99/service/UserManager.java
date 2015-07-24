/**
 * 
 */
package com.stock99.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;






import com.stock99.controller.OderController;
import com.stock99.dao.CommonDAO;
import com.stock99.dao.UserDAO;
import com.stock99.model.UserVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class UserManager extends AbstractService<UserVO> {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public CommonDAO<UserVO> getDAO() {
		// TODO Auto-generated method stub
		return userDAO;
	}
	/*@Override
	public String add(UserVO valueObject) throws Exception {
		UserVO vo=new UserVO();
		vo.setUsername("anthonydonx");
		vo.setPassword("123");
		vo.setUsertype("admin");
		
		return super.add(valueObject);
	}
	public  List<UserVO> getFromUsername(String username){
		List<UserVO> list=userDAO.getUser(username);
		return list;
	}*/

}
