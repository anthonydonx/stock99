package com.stock99.dao;



import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;




public class CommonDAO<E extends Serializable>{
	
	@Autowired
	private HibernateTemplateImpl hibernateTemplateImpl = null ;
	

	
	
	public HibernateTemplateImpl getHibernateTemplateImpl() {
		return hibernateTemplateImpl;
	}

	
	public void setHibernateTemplateImpl(HibernateTemplateImpl hibernateTemplateImpl) {
		this.hibernateTemplateImpl = hibernateTemplateImpl;
	}

	Class<E> voClass;
	
	public CommonDAO(Class<E> voClass){
		this.voClass = voClass ;
	}
	
	public  List<E> getAll(){
		List<E> list = hibernateTemplateImpl.loadAll(this.voClass);
		return list;
	}
	
	
	@Transactional
	public void add(Serializable vo) {
		 hibernateTemplateImpl.save(vo);
		//hibernateTemplateImpl.flush();
	}
	
	/*@Transactional
	public Serializable addGet(Serializable vo) {
		 hibernateTemplateImpl.save(vo);
		return vo;
	}*/
	
	@Transactional
	public void update(Serializable vo) {
		try{
			hibernateTemplateImpl.update(vo);			
			//hibernateTemplateImpl.flush();
		}catch(Exception exception){
			System.out.println(exception);
		}
	}
		

	@Transactional
	public void saveOrUpdate(Serializable vo) {
		hibernateTemplateImpl.saveOrUpdate(vo);		
		//hibernateTemplateImpl.flush();
	}
	
	@Transactional
	public void delete(Serializable vo) {
		hibernateTemplateImpl.delete(vo);			
		//hibernateTemplateImpl.flush();
	}
	
	public E get(Serializable id) {
		return hibernateTemplateImpl.get(this.voClass, id);
	}
	
	/*public void evict(Serializable entity){
		hibernateTemplateImpl.evict(entity);
	}
	public void clear(){
		hibernateTemplateImpl.clear();
	}*/
	public void close(){
		hibernateTemplateImpl.close();
	}
	
	
}
