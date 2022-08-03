package team.wy.orchestra.action;

import team.wy.orchestra.bean.Customer;
import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.biz.CustomerBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: CustomerServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/2
 **/
@WebServlet("/customer.let")
public class CustomerServlet extends HttpServlet {

    CustomerBiz customerBiz = new CustomerBiz();

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
        String username = req.getParameter("username");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNum = req.getParameter("phoneNum");

        int count = customerBiz.add(username, fname, lname, email, address, phoneNum);
        if(count > 0) {
            out.println("<script>alert('Success to add a customer!');location.href='customer.let?type=query&pageIndex=1'</script>");
        }
        else {
            out.println("<script>alert('Failed to add a cuatomer!');location.href='customer.let?type=query&pageIndex=1'</script>");
        }
    }

    private void modifypre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void modify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void query(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        // 获取信息(页数，页码，，信息)
        int pageSize = 15;
        int pageCount = customerBiz.getCustomerPageCount(pageSize);
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if(pageIndex < 1) {
            pageIndex = 1;
        }
        if(pageIndex > pageCount) {
            pageIndex = pageCount;
        }
        List<Customer> customers = customerBiz.getCustomersByPage(pageIndex, pageSize);

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("customer_list.jsp?pageIndex=" + pageIndex).forward(req, resp);
    }

    private void details(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void doAjax(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }
}
