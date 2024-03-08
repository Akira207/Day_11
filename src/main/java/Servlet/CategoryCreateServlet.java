package Servlet;

import java.io.IOException;
import java.sql.Connection;

import beans.Category;
import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.CategoryUtils;

@WebServlet("/AddCategoryServlet")
public class CategoryCreateServlet extends HttpServlet {
    public CategoryCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String categoryName = req.getParameter("categoryName");

        Category category = new Category(0,categoryName);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CategoryUtils.addCategory(conn, category);
            resp.sendRedirect(req.getContextPath() + "/CategoryList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
            dispatcher.forward(req, resp);
        }
    }
}