package Servlet;


import java.io.IOException;
import java.sql.Connection;

import beans.Publisher;
import conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.PubLisherUtils;


@WebServlet("/EditPublisher")
public class PublisherEditServlet extends HttpServlet {
    public PublisherEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditPublisher.jsp");
        String idStr = req.getParameter("id");
        Integer id = 0;
        try{
            id = Integer.parseInt(idStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (id == 0) {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Publisher publisher = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            publisher = PubLisherUtils.findPublisherById(conn, id);
            if (publisher == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + id;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || publisher == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("publisher", publisher);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String publisherId = req.getParameter("publisherId");
        String publisherName = req.getParameter("publisherName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer id = 0;
        try{
           id = Integer.parseInt(publisherId);
        }catch (Exception e){
            e.printStackTrace();
        }
        Publisher publisher = new Publisher(id,publisherName,phone,address);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("publisher", publisher);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditPublisher.jsp");
            dispatcher.forward(req, resp);

        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            PubLisherUtils.updatePublisher(conn, publisher);
            resp.sendRedirect(req.getContextPath() + "/PublisherList");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("publisher", publisher);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditPublisher.jsp");
            dispatcher.forward(req, resp);
        }
    }
}