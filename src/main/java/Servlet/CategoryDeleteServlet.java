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
import utils.CategoryUtils;

@WebServlet("/DeleteCategory")
public class CategoryDeleteServlet extends HttpServlet {
    public CategoryDeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorString = null;
        String idS = req.getParameter("id");
            Integer id = 0;
            try {
                id = Integer.parseInt(idS);
            }catch (Exception e){
                e.printStackTrace();
            }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CategoryUtils.deleteCategoryById(conn,id);
        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/DeleteCategoryError.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/CategoryList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}