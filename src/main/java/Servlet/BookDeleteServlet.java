package Servlet;

import java.io.IOException;
import java.sql.Connection;

import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookUtils;

@WebServlet("/DeleteBookServlet")
public class BookDeleteServlet extends HttpServlet {
    public BookDeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorString = null;
        String idS = req.getParameter("id");

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            BookUtils.deleteBookById(conn,idS);
        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/DeleteBookError.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/BookList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}