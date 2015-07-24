/**
 * 
 */
package com.stock99.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock99.dao.CommonDAO;
import com.stock99.dao.DailyOdersDAO;
import com.stock99.model.DailyOdersVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class DailyOdersManager extends AbstractService<DailyOdersVO> {
	@Autowired
	DailyOdersDAO dailyOdersDAO;

	@Override
	public CommonDAO<DailyOdersVO> getDAO() {
		// TODO Auto-generated method stub
		return dailyOdersDAO;
	}
	public  List<DailyOdersVO> getDailyOder(final Integer oderId,final String date){
		List<DailyOdersVO> list=dailyOdersDAO.getDailyOder(oderId, date);
		return list;
	}
	public  List<DailyOdersVO> getDailyTargetDetailsByDate(final String selectedDate){
		List<DailyOdersVO> list=dailyOdersDAO.getDailyTargetDetailsByDate(selectedDate);
		return list;
	}

}
