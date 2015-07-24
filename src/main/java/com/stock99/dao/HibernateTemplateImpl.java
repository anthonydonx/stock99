package com.stock99.dao;



import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateTemplateImpl extends HibernateTemplate {
	
	

	public HibernateTemplateImpl() {
		// TODO Auto-generated constructor stub
	}

	public HibernateTemplateImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public HibernateTemplateImpl(SessionFactory sessionFactory,
			boolean allowCreate) {
		super(sessionFactory, allowCreate);
		// TODO Auto-generated constructor stub
	}
	
	public void close(){
		getSession().close();
	}

}
