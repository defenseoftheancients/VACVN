package com.vacvn.dao;

import java.util.List;


public interface IGenericDAO<T> {
	<T> List<T> query(String queryString, com.vacvn.mapper.IMapper<T> rowMapper, Object... params);
	void update(String queryString, Object... params);
	Long insert(String queryString, Object... params);
//	String insertCustom(String queryString, Object... params);
//	Long count(String sql, Object... parameters);
	Object[] getAttribute(String sql, int columnsSize, Object... parameters);
}
