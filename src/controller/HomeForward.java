package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.classDao;
import Dao.graduateDao;
import Db.Dbconnect;
import bean.classroom;
import bean.graduate;


@WebServlet("/HomeForward")
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HomeForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		classDao cl = new classDao();
		graduateDao grade = new graduateDao();
		Dbconnect conn = new Dbconnect();
		try {
			List<classroom> listclass = cl.getlistclass(conn.conn());
			List<graduate> listgrade = 	grade.getlistgrade(conn.conn());
			
			request.setAttribute("listclass",listclass);
			request.setAttribute("listgraduate", listgrade);
			RequestDispatcher rqd =  request.getRequestDispatcher("WEB-INF/view/home.jsp");
			rqd.forward(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
