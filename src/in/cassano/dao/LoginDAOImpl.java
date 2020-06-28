package in.cassano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.cassano.entity.Login;
import in.cassano.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String authenticate(Login login) {
		String sql = "select * from tbl_login where email=? and password=?";
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) { return "true"; }
			else { return "false"; }
		} catch(SQLException ex) { ex.printStackTrace(); }
		return "error";
	}

}
