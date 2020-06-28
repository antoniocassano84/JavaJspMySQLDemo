package in.cassano.dao;

import java.util.List;
import in.cassano.entity.Employee;

public interface EmployeeDAO {

	List<Employee> get();
	Employee get(int id);
	boolean save(Employee employee);
	boolean update(Employee employee);
	boolean delete(int id);
}
