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
	RequestDispatcher dispatcher = null;
	private EmployeeDAO employeeDao = null;
       
    public EmployeeController() {
    	employeeDao = new EmployeeDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      String action = request.getParameter("action");
      
      if(action == null) { action = "LIST"; }
      
      switch(action) {
      	case "LIST":
      		listEmployees(request, response);
      		break;
      	case "EDIT":
      		getSingleEmployee(request, response);
      		break;
      	case "DELETE":
      		deleteEmployee(request, response);
      		break;
      	default:
      		listEmployees(request, response);
      		break;
      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("firstname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");
		Employee e = new Employee();
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		
		if(id.isEmpty() || id==null) {
			if(employeeDao.save(e)) {
				request.setAttribute("message", "Saved successfully");
			}
		} else {
			e.setId(Integer.parseInt(id));
			if(employeeDao.update(e)) {
				request.setAttribute("message", "Updated successfully");
			}
		}
		
		listEmployees(request, response);
	}
	
	public void listEmployees(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  List<Employee> theList = employeeDao.get();
	      request.setAttribute("list", theList);
	      dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
	      dispatcher.forward(request, response);
	}
	
	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Employee employee = employeeDao.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if(employeeDao.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Deleted successfully!");
		}
		listEmployees(request, response);
	}

}
