package com.stock99.model;



import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

public class JsonObjectUtil<E extends Serializable> {

	FilterObjects filter;

	public String getJsonObjectDataDetail(List<? extends Serializable> value, int level, String prefix) throws Exception {
		StringBuffer record = new StringBuffer();
		if (value == null || value.size() == 0)
			return "[]";
		if (prefix != null && !prefix.equals("")) {
			record.append("\"");
			record.append(prefix);
			record.append("\":");
		}
		record.append("[");
		for (Serializable listObj : value) {
			record.append(getJsonObjectDataDetail(listObj, level));
			record.append(",");
		}

		record.delete(record.length() - 1, record.length());
		record.append("],");
		if (record != null && record.length() > 1)
			record.delete(record.length() - 1, record.length());
		return record.toString();
	}

	public String getJsonObjectDataDetail(List<? extends Serializable> value, int level) throws Exception {

		return getJsonObjectDataDetail(value, level, "");
	}

	// Value has been passed to the servlet
	public String getJsonObjectDataDetail(Object value, int level) throws Exception {
		String record = "";
		// use asynchronize String Builder
		StringBuilder strbuffer = new StringBuilder();
		if (value == null)
			return "[]";

		Class c = value.getClass(); // Returns the runtime class of this Object.
		Method methlist[] = c.getMethods();// Returns an array of
													// Method objects reflecting
													// all the methods
		for (Method method : methlist) {

			String mName = method.getName();// Returns the name of the method
			
			if (mName.startsWith("is") ||  mName.startsWith("get") && mName.length() > 3 && !mName.equalsIgnoreCase("getClass")) {
				// remove 'get' and first character convert to simple
				Class<?>[] param = method.getParameterTypes();
				if (param.length > 0)
					continue; // continue for parameterized get methods
				String lowercase =(mName.startsWith("is"))? Character.toLowerCase(mName.charAt(2)) + mName.substring(3):Character.toLowerCase(mName.charAt(3)) + mName.substring(4);
				
				Class partypes[] = new Class[0];
				Method meth = c.getMethod(mName, partypes);// Returns a Method
															// object
				Object methdValue = meth.invoke(value);// Invokes the underlying
														// method represented by
														// this Method object
				Object retunType = meth.getReturnType();

				if (methdValue instanceof Serializable) {
					Serializable new_name = (Serializable) methdValue;
					// filter out some objects if filter is true go to next
					// iterate
					if (this.filter != null && this.filter.applyFilter(value, lowercase, new_name)) {
						continue;
					}
					if (methdValue instanceof Number || methdValue instanceof String || methdValue instanceof Boolean) {
						if (new_name instanceof String) {
							new_name = ((String) new_name).replaceAll("\\n", "\\\\n");
							new_name = ((String) new_name).replaceAll("\\\"", "\\\\\"");
						}
						record += '"' + lowercase + "\":\"" + new_name + "\",";
					} else if (methdValue instanceof List && level > 0) {
						List<? extends Serializable> listVal = (List<? extends Serializable>) methdValue;
						if (listVal.size() > 0)
							record += getJsonObjectDataDetail(listVal, level--, lowercase) + ",";
					} else if (level > 0) {
						// if go to the value object recursively go through the
						// method
						level--;
						record += "\"" + lowercase + "\":" + getJsonObjectDataDetail(methdValue, level) + ",";
					}
				}
			}
		}

		if (record != null && record.length() > 1)
			record = record.substring(0, record.length() - 1);
		return strbuffer.append("{" + record + "}").toString();

	}

	public boolean setJsonFilter(FilterObjects filter) {
		this.filter = filter;
		return false;
	}

}
