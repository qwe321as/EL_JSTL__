package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet(
		urlPatterns = {"/ThirdServlet"},
		initParams = {
				@WebInitParam(name="singer" , value="방탄소년단"),
				@WebInitParam(name="title", value="Dynamite")
		}
		)
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//company,singer,title 출력
	//SM,방탄소년단,Dynamite
	//console, 브라우저

	String company;
	String singer;
	String title;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThirdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		company = context.getInitParameter("company");
		//singer = context.getInitParameter("singer"); // 태연

		singer = config.getInitParameter("singer"); // 방탄소년단
		title = config.getInitParameter("title"); // Dynamite

		System.out.println("company : " + company);
		System.out.println("singer : " + singer);
		System.out.println("title : " + title);

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

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.print("회사명:"+company+"<br>");
		pw.print("가수명:"+singer+"<br>");
		pw.print("제목:"+title+"<br>");

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
