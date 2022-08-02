package team.wy.orchestra.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: CustomerServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/2
 **/
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String type = req.getParameter("type");
        switch (type) {
            case "add":
                add(req, resp, out);
                break;
            case "modifypre":
                modifypre(req, resp, out);
                break;
            case "modify":
                modify(req, resp, out);
                break;
            case "remove":
                remove(req, resp, out);
                break;
            case "query":
                query(req, resp, out);
                break;
            case "details":
                details(req, resp, out);
                break;
            case "doajax":
                doAjax(req, resp, out);
                break;
            default:
                resp.sendError(404);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void modifypre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void modify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void query(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void details(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void doAjax(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }
}
