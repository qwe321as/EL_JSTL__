package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParameter
 */
//@WebServlet("/initParameter.do") 
public class InitParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String company ;
	String singer ;
	String manager ;
	String title ;
	String title_config ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParameter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		
		
		
		// ServletContext ��ü : ������Ʈ �� 1�� ����
		ServletContext context = config.getServletContext();
		
		company = context.getInitParameter("company");
		singer = context.getInitParameter("singer");
		manager = context.getInitParameter("manager");
		title = context.getInitParameter("title");
		
		// ServletConfig ��ü : ���� �� 1�� ����
		title_config = config.getInitParameter("title");
		
		System.out.println("company:" + company);
		System.out.println("singer:" + singer);
		System.out.println("manager:" + manager);
		System.out.println("title:" + title);
		System.out.println("title_config:" + title_config);
	}

	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print("ȸ���:"+company +"<br>");
		pw.print("������:"+singer +"<br>");
		pw.print("�Ŵ���:"+manager +"<br>");
		pw.print("title:"+title +"<br>");
		pw.print("title_config:"+title_config +"<br>");
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
