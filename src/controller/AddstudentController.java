package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.*;
import Dao.*;
import Db.*;
@WebServlet("/AddstudentController")
public class AddstudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddstudentController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			int classid = Integer.parseInt(request.getParameter("dropdown_class")) ;
			double point = Double.parseDouble(request.getParameter("point"));
			
			student st = new student();
			st.setStudentName(name);
			st.setClassID(classid);
			st.setPoint(point);
			
			try {
				boolean kt = insertDao.insertstudent(Dbconnect.conn(), st);
				if (kt) {
					PrintWriter x = response.getWriter();
					x.print("them thanh cong");
					response.setContentType("text/html");
					RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/view/home.jsp");
					rdp.include(request, response);
				}
				else {
					PrintWriter x = response.getWriter();
					x.print("them that bai");
					response.setContentType("text/html");
					RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/view/home.jsp");
					rdp.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				
			} catch (SQLException e) {
				
			}
	}

}
