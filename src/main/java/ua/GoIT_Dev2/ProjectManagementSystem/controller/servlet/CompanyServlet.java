package ua.GoIT_Dev2.ProjectManagementSystem.controller.servlet;

import ua.GoIT_Dev2.ProjectManagementSystem.model.BaseEntity;
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

@WebServlet("/company/*")
public class CompanyServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -5518363074971978271L;

    private final BaseService service = new BaseService();
    private final Class className = Company.class;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo.equals("/show")){
            List<Company> companies = service.getAll(className);
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("/view/company/show.jsp").forward(req,resp);
        }
        if (pathInfo.equals("/find")) {
            if (req.getParameter("entityId") != null) {
                BaseEntity entity = service.getEntity(className, req.getParameter("entityId"), req.getParameter("entityName"));
                if (entity == null) {
                    String message = ("Company with input data not exists");
                    req.setAttribute("message", message);
                } else {
                    req.setAttribute("company", entity);
                }
            }
            req.getRequestDispatcher("/view/company/find.jsp").forward(req, resp);
        }
        if (pathInfo.equals("/updateFind")) {
            if (req.getParameter("entityId") != null) {
                BaseEntity entity = service.getEntity(className, req.getParameter("entityId"), req.getParameter("entityName"));
                if (entity == null) {
                    String message = ("Company with input data not exists");
                    req.setAttribute("message", message);
                } else {
                    req.setAttribute("entity", entity);
                }
            }
            req.getRequestDispatcher("/view/company/update.jsp").forward(req, resp);
        }
        if (pathInfo.equals("/get")){
            Company company = (Company) service.read(className,Long.valueOf(req.getParameter("id")));
            req.setAttribute("company", company);
            req.getRequestDispatcher("/view/company/details.jsp").forward(req, resp);
        }
        if (pathInfo.equals("/create")){
            req.getRequestDispatcher("/view/company/create.jsp").forward(req,resp);
        }
        if (pathInfo.equals("/update")){
            req.getRequestDispatcher("/view/company/update.jsp").forward(req,resp);
        }
        if (pathInfo.equals("/delete")){
            req.getRequestDispatcher("/view/company/delete.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        if (pathInfo.equals("/create")){
            if (!service.ifExist(Company.class,req)){
                Company newCompany = Company.builder()
                        .name(req.getParameter("name"))
                        .city(req.getParameter("city"))
                        .build();
                req.setAttribute("company", service.save(className, newCompany));
            }else{
                req.setAttribute("existCompany", service.findByName(className, req.getParameter("name")).get(0));
            }
            req.getRequestDispatcher("/view/company/create.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        if (pathInfo.equals("/update")){
            Company entity = (Company) service.read(Company.class, req.getParameter("entityId"));
            entity.setName(req.getParameter("entityName"));
            entity.setCity(req.getParameter("entityCity"));
            service.save(Company.class, entity);
            req.setAttribute("message", "Data updated");
        }
        req.getRequestDispatcher("/view/company/update.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        if (pathInfo.equals("/delete")){
            Company company = (Company) service.read(className,Long.valueOf(req.getParameter("companyId")));
            req.setAttribute("company", company);
            String message = " was deleted";
            req.setAttribute("message", message);
            service.delete(className,Long.valueOf(req.getParameter("companyId")));
            req.getRequestDispatcher("/view/company/delete.jsp").forward(req,resp);
        }
    }
}
