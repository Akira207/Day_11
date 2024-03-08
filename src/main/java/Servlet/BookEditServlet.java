package Servlet;

import java.io.IOException;
import java.sql.Connection;

import beans.Book;
import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookUtils;

@WebServlet("/EditBookServlet")
public class BookEditServlet extends HttpServlet {
    public BookEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditBook.jsp");
        String id = req.getParameter("id");
        if (id == "") {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Book book = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            book = BookUtils.findBookById(conn, id);
            if (book == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + id;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || book == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("book", book);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String bookId = req.getParameter("bookId");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String releaseYear = req.getParameter("releaseYear");
        String priceStr = req.getParameter("price");
        String picture = req.getParameter("picture");
        String publisherIdStr = req.getParameter("publisherId");
        String categoryIdStr = req.getParameter("categoryId");
        Integer release = 0;
        Double price = 0.0;
        Integer publisherId = 0;
        Integer categoryId = 0;
        try {
            publisherId = Integer.parseInt(publisherIdStr);
            categoryId = Integer.parseInt(categoryIdStr);
            release = Integer.parseInt(releaseYear);
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            errorString = e.getMessage();
        }
        Book book = new Book(bookId, title, author, release, price, picture, publisherId, categoryId);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("book", book);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditBook.jsp");
            dispatcher.forward(req, resp);

        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            BookUtils.updateBook(conn, book);
            resp.sendRedirect(req.getContextPath() + "/BookList");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("book", book);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditBook.jsp");
            dispatcher.forward(req, resp);
        }
    }
}