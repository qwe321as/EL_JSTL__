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
				@WebInitParam(name="singer" , value="��ź�ҳ��"),
				@WebInitParam(name="title", value="Dynamite")
		}
		)
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//company,singer,title ���
	//SM,��ź�ҳ��,Dynamite
	//console, ������

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
		//singer = context.getInitParameter("singer"); // �¿�

		singer = config.getInitParameter("singer"); // ��ź�ҳ��
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
		pw.print("ȸ���:"+company+"<br>");
		pw.print("������:"+singer+"<br>");
		pw.print("����:"+title+"<br>");

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
