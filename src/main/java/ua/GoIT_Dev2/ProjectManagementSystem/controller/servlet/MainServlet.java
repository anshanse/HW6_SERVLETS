package ua.GoIT_Dev2.ProjectManagementSystem.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -4271636941373851678L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
        }
    }
}
