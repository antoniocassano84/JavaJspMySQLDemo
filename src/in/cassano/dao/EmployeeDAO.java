package in.cassano.dao;

import java.util.List;
import in.cassano.entity.Employee;

public interface EmployeeDAO {

	List<Employee> get();
	boolean save(Employee employee);
}
