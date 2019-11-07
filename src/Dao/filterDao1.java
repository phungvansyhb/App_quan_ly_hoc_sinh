package Dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = "home.jsp")
public class filterDao1 implements Filter {

   
    public filterDao1() {
       
    }
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name = request.getParameter("name");
		String point = request.getParameter("point") ;
		if(name.matches("sy") && point.matches("10")) {
			RequestDispatcher rdp = request.getRequestDispatcher("AddstudentController");
			chain.doFilter(request, response);			
			rdp.forward(request, response);
		}else {
			response.setContentType("text/html");
			PrintWriter x = response.getWriter();
			x.print("Thông tin bạn nhập vào chưa chính xác");
			RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/view/home.jsp");
			rdp.include(request, response);
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
