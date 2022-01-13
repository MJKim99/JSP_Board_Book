package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookDAO;
import com.beans.BookDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		int price = Integer.parseInt(request.getParameter("price"));

		if ((title != null && title.trim().length() > 0) || (price > 0)) {
			try {
				cnt = new BookDAO().update(uid, title, summary, price);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("result", cnt);
	}

}
