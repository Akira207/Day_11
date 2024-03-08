package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.Book;
import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookUtils;

@WebServlet("/BookList")
public class BookListServlet extends HttpServlet {
    public BookListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        List<Book> list = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            try {
                list = BookUtils.getAllBooks(conn);
            }catch (SQLException e){
                e.printStackTrace();
                errorString = e.getMessage();
            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("bookList", list);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/BookList.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            errorString = e1.getMessage();
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/BookList.jsp");
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}