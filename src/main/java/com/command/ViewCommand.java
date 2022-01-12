package com.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookDAO;
import com.beans.BookDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<BookDTO> list = null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));

		try {
			list = new BookDAO().readByUid(uid);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
