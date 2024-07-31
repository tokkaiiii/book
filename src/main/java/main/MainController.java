package main;

import domain.Main;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class MainController extends HttpServlet {

    private ServletContext context;


    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String m = req.getParameter("m");
        if (m != null && !m.equals("")) {
            m = m.trim();
            switch (m) {
                case "list": list(req, res); break;
//                case "search" : search(req, res); break;
            }
        }else {
            list(req, res);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        MainService service = MainService.getInstance();

        ArrayList<Main> list = service.mainPageS();
        int count = service.count_academyS();

        req.setAttribute("list", list);
        req.setAttribute("count", count);

        String view = "index.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }

    private void search(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        MainService service = MainService.getInstance();

        String acd_name = req.getParameter("academy_name");
        ArrayList<Main> list = service.searchS(acd_name);

        String view = "autosearch.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, res);
    }
}