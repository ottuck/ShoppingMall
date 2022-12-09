package edu.global.ex.Controller;

import edu.global.ex.Command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet() ..");
        actionDo(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost() ..");
        actionDo(request, response);
    }

    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("actionDo() ..");

        request.setCharacterEncoding("UTF-8");

        String viewPage = null;
        MemberCommand command = null;

        String url = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = url.substring(conPath.length());
        //주소자르는 3줄

        if (com.equals("/list.do")) {
            System.out.println("/list.do ..");

            command = new MemberListCommand();
            command.execute(request, response);
            viewPage = "list.jsp";

        } else if (com.equals("/registration.do")) {
            System.out.println("/registration.do ..");

            command = new MemberRegistrationCommand();
            command.execute(request, response);
            viewPage = "insert.jsp";
        } else if (com.equals("/insert.do")) {
            System.out.println("/insert.do ..");

            command = new MemberInsertCommand();
            command.execute(request, response);
            viewPage = "list.do";
        } else if (com.equals("/sales.do")) {
            System.out.println("/sales.do ..");

            command = new MemberSalesCommand();
            command.execute(request, response);
            viewPage = "sales.jsp";
        } else if (com.equals("/content.do")) {
            System.out.println("/content.do ..");

            command = new MemberContentCommand();
            command.execute(request, response);
            viewPage = "content.jsp";
        } else if (com.equals("/content.do")) {
            System.out.println("/content.do ..");

            command = new MemberContentCommand();
            command.execute(request, response);
            viewPage = "content.jsp";
        } else if (com.equals("/update.do")) {
            System.out.println("/update.do ..");

            command = new MemberUpdateCommand();
            command.execute(request, response);
            viewPage = "list.do";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }
}
