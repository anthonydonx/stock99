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

import com.stock99.model.GrnVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class GrnDAO extends CommonDAO<GrnVO>{

	public GrnDAO() {
		super(GrnVO.class);
	
	}
	public  List<GrnVO> getGRNFromOderId(final String oderId ,final String status){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<GrnVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<GrnVO>>(){

			public List<GrnVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from GrnVO where oderId='"+oderId+"'AND status='"+status+"'").list();
				
			
			}
			
		});
		return list;
	}
	public  List<GrnVO> getAllGRNById(final String oderId ){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<GrnVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<GrnVO>>(){

			public List<GrnVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from GrnVO where oderId='"+oderId+"'").list();
				
			
			}
			
		});
		return list;
	}
}
