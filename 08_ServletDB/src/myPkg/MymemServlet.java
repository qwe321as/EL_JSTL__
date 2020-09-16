package myPkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MymemServlet
 */
//@WebServlet("*.mem")
public class MymemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		System.out.println("doGet()");
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost()");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("process()");
		 
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int len = contextPath.length();
		
		System.out.println("uri:" + uri);
		System.out.println("contextPath:" + contextPath);
		System.out.println("len:" + len);
		
		String command =  uri.substring(len); // // /insert.mem or /select.mem 
		System.out.println("command : " + command);
		
		MymemDao dao = new MymemDao();
		String viewPage = null; 
		
		if(command.equals("/insert.mem")) {
			System.out.println("insert 요청 들어옴");
			request.setCharacterEncoding("UTF-8"); 
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			MymemBean bean = new MymemBean(0,name,password);
			int cnt = dao.insertMymem(bean);
			System.out.println("insert cnt : " + cnt );
			viewPage = "Ex01_mymemVia.jsp";
		}
		else if(command.equals("/select.mem")) {
			System.out.println("select 요청 들어옴");
			
			ArrayList<MymemBean> lists = dao.getMymemList();
			
			request.setAttribute("lists", lists);
			
			viewPage = "Ex01_mymemList.jsp";
		}
		else if(command.equals("/update.mem")) {
			System.out.println("update 요청 들어옴");
			request.setCharacterEncoding("UTF-8"); 
			int id= Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			MymemBean bean = new MymemBean(id,name,password);
	        dao.getupate(bean);
	        viewPage = "/select.mem";
			
		}
		else if(command.equals("/updateF.mem")) {
			System.out.println("update 요청 들어옴");
			String id = request.getParameter("id");
			//id에 해당하는 레코드를 뽑아와 띄워야 수정할수 있겠지
			MymemBean mb = dao.getOneSelect(id);
			request.setAttribute("mb", mb);
			viewPage = "Ex01_mymemUpdateForm.jsp";
			
		}
		else if(command.equals("/delete.mem")) {
			System.out.println("delete 요청 들어옴");
			String id = request.getParameter("id");
			int cnt = dao.deleteMymem(id);
			if (cnt>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			/*
			 * viewPage = "Ex01_mymemList.jsp"; 이렇게하면 list 값을 받아올수 없어서 오류가 발생한다.
			 */			
			viewPage ="/select.mem";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response); 
		
		
	}
}
















