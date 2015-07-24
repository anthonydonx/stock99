/**
 * 
 */
package com.stock99.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;










import com.stock99.dao.CommonDAO;
import com.stock99.dao.GrnDAO;
import com.stock99.dao.OderDAO;
import com.stock99.dao.UserDAO;
import com.stock99.model.GrnVO;
import com.stock99.model.OdersVO;
import com.stock99.model.UserVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class GrnManager extends AbstractService<GrnVO> {
	@Autowired
	GrnDAO grnDAO;

	@Override
	public CommonDAO<GrnVO> getDAO() {
		// TODO Auto-generated method stub
		return grnDAO;
	}
	
	
	public  List<GrnVO> getGRNFromOderId(final String oderId,final String status){
		List<GrnVO> list=grnDAO.getGRNFromOderId(oderId, status);
		return list;
	}
	
	public  List<GrnVO> getAllGRNById(final String oderId){
		List<GrnVO> list=grnDAO.getAllGRNById(oderId);
		return list;
	}
}
