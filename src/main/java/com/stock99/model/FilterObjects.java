package com.stock99.model;



public interface FilterObjects {

	abstract boolean applyFilter(Object source, String name, Object value);
}
