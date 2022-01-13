package com.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookDAO;
import com.beans.BookDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		List<BookDTO> list = null;
		
		try {
			list = new BookDAO().selectByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("list", list);
	}

}
