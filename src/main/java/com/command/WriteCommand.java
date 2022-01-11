package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookDAO;
import com.beans.BookDTO;
import com.command.Command;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookDTO dto = new BookDTO();
		dto.setTitle(title);
		dto.setSummary(summary);
		dto.setPrice(price);
		
		if (title != null && title.trim().length() > 0) {
			try {
				cnt = new BookDAO().insert(dto);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("result", cnt);
		request.setAttribute("dto", dto); // auto-generated key (uid)
	}

}