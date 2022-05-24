package com.vacvn.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vacvn.dao.IGenericDAO;
import com.vacvn.mapper.IMapper;

public abstract class AbstractDao<T> implements IGenericDAO<T> {
	public Connection getConnection() {
		String DB_URL = "jdbc:mysql://127.0.0.1:3306/vacvn";
		String USER_NAME = "root";
		String PASSWORD = "thptuongbi";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
		} catch (Exception e) {
			System.out.println("connect failure!");
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public <T> List<T> query(String queryString, IMapper<T> rowMapper, Object... params) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			setParameter(statement, params);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			System.out.println(statement);
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... params) {
		try {
			for (int i = 0; i < params.length; i++) {
				Object param = params[i];
				int index = i + 1;
				if (param instanceof Long)
					statement.setLong(index, (long) param);
				else if (param instanceof String) {
					statement.setString(index, (String) param);
				} else if (param instanceof Integer) {
					statement.setInt(index, (Integer) param);
				} else if (param instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) param);
				}
				else if (param instanceof Boolean) {
					statement.setBoolean(index, (Boolean) param);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			System.out.println(statement);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String queryString, Object... params) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, params);
			System.out.println(statement);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				id = resultSet.getLong(1);
				
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			e.printStackTrace();
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
//	@Override
//	public void insertCustom(String queryString, Object... params) {
//		ResultSet resultSet = null;
//		Connection connection = null;
//		PreparedStatement statement = null;
//		String id = null;
//		try {
//			connection = getConnection();
//			connection.setAutoCommit(false);
//			statement = connection.prepareStatement(queryString);
//			setParameter(statement, params);
//			statement.executeUpdate();
//			System.out.println(statement);
//			if (resultSet.next()) {
//				id = resultSet.getString(2);
//			}
//			connection.commit();
//			return id;
//		} catch (Exception e) {
//			if (connection != null)
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//
//			e.printStackTrace();
//			
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (resultSet != null) {
//					resultSet.close();
//				}
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
//	@Override
//	public Long count(String sql, Object... parameters) {
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		try {
//			Long count = 0L;
//			connection = getConnection();
//			statement = connection.prepareStatement(sql);
//			setParameter(statement, parameters);
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				count = resultSet.getLong(1);
//			}
//			return count;
//		} catch (SQLException e) {
//			return 0L;
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (resultSet != null) {
//					resultSet.close();
//				}
//			} catch (SQLException e) {
//				return 0L;
//			}
//		}
//	}
	@SuppressWarnings("null")
	@Override
	public Object[] getAttribute(String sql, int columnsSize, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Object[] result = new Object [columnsSize];
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				for(int i = 0;i < columnsSize;i++)
					result[i] = resultSet.getObject(i+1);
			}
			return result;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
}
