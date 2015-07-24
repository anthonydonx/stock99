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






import com.stock99.model.UserVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class UserDAO extends CommonDAO<UserVO>{

	public UserDAO() {
		super(UserVO.class);
	
	}
	/*public  List<UserVO> getUser(final String username){
		HibernateTemplateImpl hibernateTemplateImpl=getHibernateTemplateImpl();
		List<UserVO> list=hibernateTemplateImpl.execute(new HibernateCallback<List<UserVO>>(){

			public List<UserVO> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				SimpleDateFormat sdf = new SimpleDateFormat("H");
				SimpleDateFormat dateF = new SimpleDateFormat("yyyy-M-d");
				String currenttime = sdf.format(new Date());
				String dates = dateF.format(new Date());
				return arg0.createQuery("from UserVO WHERE username ='"+username+"'" ).list();
				
			
			}
			
		});
		return list;*/
	//}

}
