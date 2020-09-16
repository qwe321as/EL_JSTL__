package svy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPkg.MymemBean;

/**
 * Servlet implementation class SurveyServlet
 */
//@WebServlet("/sv")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	String driver;
	String url1;
	String user;
	String pw;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
		driver = config.getInitParameter("driver");
		url1 = config.getInitParameter("url1");
		user= config.getInitParameter("user");
		pw = config.getInitParameter("pw");
		System.out.println("driver: "+ driver);
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
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request,response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String context1 = request.getContextPath();
		int len = context1.length();
		String command = uri.substring(len);
		String viewPage = null;
		Surveydao dao = new Surveydao(driver,url1,user,pw);
		if (command.equals("/insert.sv")) {
			String flag = (String)context.getAttribute("flag");
			System.out.println("flag: "+flag);
			request.setCharacterEncoding("UTF-8"); 
			String name =request.getParameter("name");
			String company =request.getParameter("company");
			String email =request.getParameter("email");
			String satisfaction =request.getParameter("satisfaction");
			String[] part_ = request.getParameterValues("part");
			String howto =request.getParameter("howto");
			String agree_imsi =request.getParameter("agree");
			 int agree;
			if (agree_imsi==null) {
				agree=0;
			}else {
				agree=1;
			}
			String part="";
			if (part_==null) {
				part="선택한 관심분야가 없습니다.";
			}else {
			for (int i = 0; i < part_.length; i++) {
				part += part_[i];
				if (i != part_.length-1) {
					part +=",";
				}
			}}
			Surveybean bean = new Surveybean(0, name, company, email, satisfaction, part, howto, agree);
			if(flag.equals("false")) {
				dao.insert(bean);
				
				context.setAttribute("flag","true");
				viewPage = "/list.sv";
			}
			else {
				viewPage = "/list.sv";
			}					}
		else if (command.equals("/list.sv")) {
			request.setCharacterEncoding("UTF-8"); 
			ArrayList<Surveybean> list = dao.selectall();
			request.setAttribute("list", list);
			viewPage="Ex02_surveylist.jsp";
		}
		
		  else if (command.equals("/updateForm.sv")) {
			  request.setCharacterEncoding("UTF-8"); 
			  ArrayList<Surveybean> list = dao.selectone(request.getParameter("no"));
			  request.setAttribute("list", list);
			  viewPage="Ex02_surveyupdateForm.jsp";
		  
		  }
		   else if (command.equals("/update.sv")) {
				request.setCharacterEncoding("UTF-8"); 
				String name =request.getParameter("name");
				int no =Integer.parseInt(request.getParameter("no"));
				String company =request.getParameter("company");
				String email =request.getParameter("email");
				String satisfaction =request.getParameter("satisfaction");
				String[] part_ = request.getParameterValues("part");
				String howto =request.getParameter("howto");
				String agree_imsi =request.getParameter("agree");
				 int agree;
				if (agree_imsi==null) {
					agree=0;
				}else {
					agree=1;
				}
				String part="";
				if (part_==null) {
					part="선택한 관심분야가 없습니다.";
				}else {
				for (int i = 0; i < part_.length; i++) {
					part += part_[i];
					if (i != part_.length-1) {
						part +=",";
					}
				}}
				Surveybean bean = new Surveybean(no, name, company, email, satisfaction, part, howto, agree);
				dao.update(bean);
				viewPage ="/list.sv"; 
		  } 
		  else if (command.equals("/delete.sv")) {
			 String no = request.getParameter("no");
			 dao.delete(no); 
			 viewPage ="/list.sv";
		  }
		 
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, respons);
		
		
	}
}
