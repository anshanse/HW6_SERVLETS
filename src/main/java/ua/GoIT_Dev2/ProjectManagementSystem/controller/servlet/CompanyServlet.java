package ua.GoIT_Dev2.ProjectManagementSystem.controller.servlet;

import ua.GoIT_Dev2.ProjectManagementSystem.model.Company;
import ua.GoIT_Dev2.ProjectManagementSystem.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/company/")
public class CompanyServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -5518363074971978271L;

    private BaseService service = new BaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] command = pathInfo.split("/");
        String action = getAction(req);
        if (command[0].equals("show")){
            resp.sendRedirect("google.com");
            List<Company> allCompanies = service.getAll(Company.class);
            req.setAttribute("allCompanies", allCompanies);
            req.getRequestDispatcher("\\view\\company\\show.jsp").forward(req,resp);
        }else if (pathInfo.equals("find")){
            req.getRequestDispatcher("\\view\\company\\find.jsp").forward(req,resp);
        }else if (pathInfo.equals("create")){
            req.getRequestDispatcher("\\view\\company\\create.jsp").forward(req,resp);
        }else if (pathInfo.equals("delete")){
            req.getRequestDispatcher("\\view\\company\\delete.jsp").forward(req,resp);
        }
    }



    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }
}