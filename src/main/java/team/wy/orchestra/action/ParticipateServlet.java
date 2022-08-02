package team.wy.orchestra.action;

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
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/1
 **/
@WebServlet("/participate.let")
public class ParticipateServlet extends HttpServlet {

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
        //TODO - 添加musician到concert中，需要在Biz中增加add
    }

    private void participateRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void participateQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }
}
