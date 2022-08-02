package team.wy.orchestra.action;

import team.wy.orchestra.bean.Participate;
import team.wy.orchestra.biz.ParticipateBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: ParticipateServlet
 * @description:
 * @author: YORE
 * @date: 2022/8/1
 **/
@WebServlet("/participate.let")
public class ParticipateServlet extends HttpServlet {
    ParticipateBiz participateBiz = new ParticipateBiz();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /participate.let&type=add
     * /participate.let?type=remove=xx
     * /participate.let?type=query
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String type = req.getParameter("type");
        switch (type) {
            case "add":
                participateAdd(req, resp, out);
                break;
            case "remove":
                participateRemove(req, resp, out);
                break;
            case "query":
                participateQuery(req, resp, out);
                break;
            default:
                resp.sendError(404, "请求的地址不存在");
        }
    }

    private void participateAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long concertId = Long.parseLong(req.getParameter("cid"));
        String ids = req.getParameter("ids");
        String[] strs = ids.split("_");
        List<String> musicianSSNs = new ArrayList<String>(Arrays.asList(strs));

        int count = participateBiz.add(musicianSSNs, concertId);
        if(count > 0) {
            out.println("<script>alert('Success!');location.href='participate.let?type=query&pageIndex=1&id="+concertId+"';</script>");
        } else {
            out.println("<script>alert('Failed!');location.href='main.jsp';</script>");
        }
    }

    private void participateRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long participateId = Long.parseLong(req.getParameter("pid"));
        int count = participateBiz.remove(participateId);
        if(count > 0) {
            out.println("<script>alert('Success to remove participate!');location.href='concert.let?type=query&pageIndex=1'</script>");
        } else {
            out.println("<script>alert('Failed to remove participate!');location.href='concert.let?type=query&pageIndex=1'</script>");
        }
    }

    private void participateQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long concertId = Long.parseLong(req.getParameter("id"));
        List<Participate> participates = participateBiz.getByConId(concertId);
        req.setAttribute("participates", participates);
        req.getRequestDispatcher("participate_list.jsp").forward(req, resp);
    }
}
