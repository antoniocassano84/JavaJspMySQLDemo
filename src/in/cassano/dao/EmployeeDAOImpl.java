package in.cassano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.cassano.entity.Employee;
import in.cassano.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<Employee> get() {
		
		List<Employee> list = null;
		Employee employee = null;
	    
		try {
			list = new ArrayList<>();
			String sql = "SELECT * FROM tbl_employee";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
				list.add(employee);
			}
		} catch (Exception e) { e.printStackTrace(); } 
		return list;
	}

	@Override
	public boolean save(Employee employee) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO tbl_employee(name, dob, department) VALUES ('" +
						 employee.getName() + "', '" +
					     employee.getDob() + "', '" +
						 employee.getDepartment() + "')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException ex) { ex.printStackTrace(); }
		return flag;
	}

}
