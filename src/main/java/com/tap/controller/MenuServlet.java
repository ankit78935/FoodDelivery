package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.MenuDaoI;
import com.tap.model.Menu;
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") !=null) {
			int userId=(int)session.getAttribute("userId");
			req.setAttribute("userId", userId);
		}
		MenuDaoI m  = new MenuDaoI();
		List<Menu> menu = m.getByRestaurantId(restaurantId);
		req.setAttribute("menus", menu);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req,resp);
      
	}

}
