/**
 * 
 */
package com.stock99.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.stock99.model.DailyOdersVO;
import com.stock99.model.OdersVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class DailyOdersDAO extends CommonDAO<DailyOdersVO>{

	public DailyOdersDAO() {
		super(DailyOdersVO.class);
	
	}
	public  List<DailyOdersVO> getDailyOder(final Integer oderId,final String date){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<DailyOdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<DailyOdersVO>>(){

			public List<DailyOdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from DailyOdersVO where date='"+date+"'AND oderid='"+oderId+"'" ).list();
	
			}
			
		});
		return list;
	
}
	public  List<DailyOdersVO> getDailyTargetDetailsByDate(final String selectedDate){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<DailyOdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<DailyOdersVO>>(){

			public List<DailyOdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from DailyOdersVO where tdate='"+selectedDate+"'" ).list();
	
			}
			
		});
		return list;
	
}

}
