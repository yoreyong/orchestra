package team.wy.orchestra.action;

import team.wy.orchestra.bean.Repertoire;
import team.wy.orchestra.biz.RepertoireBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: RepetoireServlet
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
@WebServlet("/repertoire.let")
public class RepetoireServlet extends HttpServlet {

    RepertoireBiz repertoireBiz = new RepertoireBiz();

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
            case "addpre":

            case "add":
                long concertId = Long.parseLong(req.getParameter("cid"));
                String ids = req.getParameter("ids");
                String[] strs = ids.split("_");
                List<Long> musicalWorkIds = new ArrayList<Long>();
                for(String s : strs) {
                    long id = Long.parseLong(s);
                    musicalWorkIds.add(id);
                }
                int count = repertoireBiz.add(concertId, musicalWorkIds);
                if(count > 0) {
                    out.println("<script>alert('Success to plan a repertoire!');location.href='main.jsp';</script>");
                } else {
                    out.println("<script>alert('Failed to plan a repertoire!');location.href='main.jsp';</script>");
                }
                break;
            case "query":
                int pageSize = 15;
                int pageCount = repertoireBiz.getPageCount(pageSize);
                int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
                if (pageIndex < 1) {
                    pageIndex = 1;
                }
                if (pageIndex > pageCount) {
                    pageIndex = pageCount;
                }
                List<Repertoire> repertoires = repertoireBiz.getByPage(pageIndex, pageSize);

                req.setAttribute("pageCount", pageCount);
                req.setAttribute("repertoires", repertoires);
                req.getRequestDispatcher("repertoire_list.jsp?pageIndex=" + pageIndex).forward(req, resp);
                break;
            default:
                resp.sendError(404, "请求的地址不存在");
        }
    }
}
