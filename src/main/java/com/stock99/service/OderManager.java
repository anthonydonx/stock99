/**
 * 
 */
package com.stock99.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock99.dao.CommonDAO;
import com.stock99.dao.OderDAO;
import com.stock99.model.OdersVO;

/**
 * @author anthonydonx
 *
 */
@Component
public class OderManager extends AbstractService<OdersVO> {
	@Autowired
	OderDAO oderDAO;

	@Override
	public CommonDAO<OdersVO> getDAO() {
		// TODO Auto-generated method stub
		return oderDAO;
	}
	
	public  List<OdersVO> getSalesOderidFromStyle(final String style){
		List<OdersVO> list=oderDAO.getSalesOderidFromStyle(style);
		return list;
	}
	public  List<OdersVO> getDataFromStyleAndSalesoder(final String styleId,final String salesoder){
		List<OdersVO> list=oderDAO.getDataFromStyleAndSalesoder(styleId,salesoder);
		return list;
	}
	public  List<OdersVO> getDataFromStyleAndSalesoderLineItem(final String styleId,final String salesoder,final String lineitem){
		List<OdersVO> list=oderDAO.getDataFromStyleAndSalesoderLineItem(styleId,salesoder,lineitem);
		return list;
	}
	public  List<OdersVO> getDataFromStyleAndSalesoderLineItemSize(final String styleId,final String salesoder,final String lineitem,final String size){
		List<OdersVO> list=oderDAO.getDataFromStyleAndSalesoderLineItemSize(styleId,salesoder,lineitem,size);
		return list;
	}
	public  List<OdersVO> getDataFromOthers(final String styleId,final String salesoder,final String lineitem,final String size,final String module){
		List<OdersVO> list=oderDAO.getDataFromOthers(styleId, salesoder, lineitem, size, module);
		return list;
	}
	/*public void updateAllowedQuantity(final Integer oderId,Integer quantity){
		 oderDAO.updateAllowedQuantity(oderId,quantity);
		//return OdersVO;
	}*/
}
