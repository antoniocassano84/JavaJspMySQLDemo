package in.cassano.dao;

import in.cassano.entity.Login;

public interface LoginDAO {

	String authenticate(Login login);
}
