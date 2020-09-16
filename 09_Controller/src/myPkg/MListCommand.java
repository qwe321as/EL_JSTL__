package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberBean> list = dao.getSelectAll();
		System.out.println("yeji");
		request.setAttribute("list", list);
	}
}
