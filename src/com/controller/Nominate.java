package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Nomination;
import com.beans.Nominee;
import com.dao.NominationDao;
import com.service.SendEmail;
import com.service.Service;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/Nominate")
public class Nominate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Nominate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NominationDao nominationDao = new NominationDao();
		String action = request.getParameter("action");
		if ("nominate".equals(action)) {
			String nominatorFirstName = request.getParameter("firstname") == null ? "sriram"
					: request.getParameter("firstname");
			String nominatorLastName = request.getParameter("lastname") == null ? "subramanian"
					: request.getParameter("lastname");
			String userId = request.getParameter("userId") == null ? "ssubr3" : request.getParameter("lastname");
			String nominees = request.getParameter("nominees");
			String title = request.getParameter("title");

			String recognitionArea = request.getParameter("area");
			Integer recognitionAreaId = null;
			try {
				recognitionAreaId = nominationDao.getRecognitionAreaId(recognitionArea);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String recognitionType = request.getParameter("regtype");
			Integer recognitionTypeId = null;
			try {
				recognitionTypeId = nominationDao.getRecognitionAreaId(recognitionArea);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ArrayList<Nominee> list = new ArrayList<Nominee>();
			for (String str : nominees.split(";")) {
				list.add(new Service().getNominee(str));
			}
			String description = request.getParameter("Description");
			Nomination nomination = new Nomination();
			nomination.setRecognitionId(recognitionTypeId);
			nomination.setTitle(title);
			// nomination.setStatus(status);
			nomination.setNominatorFirstName(nominatorFirstName);
			nomination.setNominatorLastname(nominatorLastName);
			nomination.setNominatorUserId(userId);

			nomination.setNominees(list);
			nomination.setRecognitionAreaId(recognitionAreaId);
			nomination.setDescription(description);
			nomination.setCreatedAt(new Timestamp(System.currentTimeMillis()));

			Integer status = 1;
			nomination.setStatus(status);
			try {
				nominationDao.nominate(nomination);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//SendEmail.email("sriram.subramanian@monsanto.com", recognitionType);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}

	}
}
