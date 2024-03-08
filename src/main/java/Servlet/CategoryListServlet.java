package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.Category;
import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.CategoryUtils;

@WebServlet("/CategoryList")
public class CategoryListServlet extends HttpServlet {

    public CategoryListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        List<Category> list = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            try {
                list = CategoryUtils.getAllCategories(conn);
            }catch (SQLException e){
                e.printStackTrace();
                errorString = e.getMessage();
            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("categoryList", list);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryList.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            errorString = e1.getMessage();
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryList.jsp");
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
