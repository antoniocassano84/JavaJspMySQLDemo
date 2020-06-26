package in.cassano.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cassano.dao.EmployeeDAO;
import in.cassano.dao.EmployeeDAOImpl;
import in.cassano.entity.Employee;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDao = null;
       
    public EmployeeController() {
    	employeeDao = new EmployeeDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        List<Employee> theList = employeeDao.get();
        request.setAttribute("list", theList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("firstname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");
		Employee e = new Employee();
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		if(employeeDao.save(e)) {
			request.setAttribute("message", "Saved successfully");
		}
	}

}
