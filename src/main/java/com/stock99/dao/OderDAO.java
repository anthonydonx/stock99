/**
 * 
 */
package com.stock99.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.stock99.model.OdersVO;
import com.stock99.model.UserVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class OderDAO extends CommonDAO<OdersVO> {

	public OderDAO() {
		super(OdersVO.class);

	}

	public List<OdersVO> getSalesOderidFromStyle(final String styleId) {
		HibernateTemplateImpl hibernateTemplateImpl = getHibernateTemplateImpl();
		List<OdersVO> list = hibernateTemplateImpl
				.execute(new HibernateCallback<List<OdersVO>>() {

					public List<OdersVO> doInHibernate(Session arg0)
							throws HibernateException, SQLException {
						SimpleDateFormat sdf = new SimpleDateFormat("H");
						SimpleDateFormat dateF = new SimpleDateFormat(
								"yyyy-M-d");
						String currenttime = sdf.format(new Date());
						String dates = dateF.format(new Date());
						return arg0.createQuery(
								"from OdersVO where style='" + styleId + "'")
								.list();

					}

				});
		return list;
	}
	
	public  List<OdersVO> getDataFromStyleAndSalesoder(final String styleId,final String salesoder){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<OdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<OdersVO>>(){

			public List<OdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from OdersVO where style='"+styleId+"'AND salesOder='"+salesoder+"'" ).list();
				
			
			}
			
		});
		return list;
	}	
	
	public  List<OdersVO> getDataFromStyleAndSalesoderLineItem(final String styleId,final String salesoder,final String lineitem){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<OdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<OdersVO>>(){

			public List<OdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from OdersVO where style='"+styleId+"'AND salesOder='"+salesoder+"'AND lineItem='"+lineitem+"'" ).list();
				
			
			}
			
		});
		return list;
	}
	public  List<OdersVO> getDataFromStyleAndSalesoderLineItemSize(final String styleId,final String salesoder,final String lineitem,final String size){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<OdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<OdersVO>>(){

			public List<OdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from OdersVO where style='"+styleId+"'AND salesOder='"+salesoder+"'AND lineItem='"+lineitem+"'AND size='"+size+"'" ).list();
				
			
			}
			
		});
		return list;
	}
	public  List<OdersVO> getDataFromOthers(final String styleId,final String salesoder,final String lineitem,final String size,final String module){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<OdersVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<OdersVO>>(){

			public List<OdersVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from OdersVO where style='"+styleId+"'AND salesOder='"+salesoder+"'AND lineItem='"+lineitem+"'AND size='"+size+"'AND module='"+module+"'" ).list();
				
			
			}
			
		});
		return list;
	}
	
	/*public  void updateAllowedQuantity(final Integer oderId,Integer quantity){
		OdersVO order=get(oderId);
		order.setAllowedQuantity(quantity);
		saveOrUpdate(order);		
		
	}*/
	
	
	
	//updateAllowedQuantity(final String oderId,double quantity)
	
	
}
