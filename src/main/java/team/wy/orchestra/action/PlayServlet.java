package team.wy.orchestra.action;

import team.wy.orchestra.bean.PlaysInstr;
import team.wy.orchestra.biz.PlaysInstrBiz;

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
 * @className: PlayServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/2
 **/
@WebServlet("/play.let")
public class PlayServlet extends HttpServlet {

    PlaysInstrBiz playsInstrBiz = new PlaysInstrBiz();

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
                playAdd(req, resp, out);
                break;
            case "remove":
                playRemove(req, resp, out);
                break;
            case "query":
                playQuery(req, resp, out);
                break;
            default:
                resp.sendError(404, "请求的地址不存在");
        }
    }

    private void playAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        String SSN = req.getParameter("SSN");
        String ids = req.getParameter("ids");
        String[] strs = ids.split("_");
        List<Long> instrumentIds = new ArrayList<Long>();
        for(String i : strs) {
            long id = Long.parseLong(i);
            instrumentIds.add(id);
        }
        int count = playsInstrBiz.add(SSN, instrumentIds);
        if(count > 0) {
            out.println("<script>alert('Success!');location.href='play.let?type=query&SSN="+SSN+"';</script>");
        } else {
            out.println("<script>alert('Failed!');location.href='main.jsp';</script>");
        }
    }

    private void playRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long playId = Long.parseLong(req.getParameter("pid"));
        int count = playsInstrBiz.remove(playId);
        if(count > 0) {
            out.println("<script>alert('Success to remove!');location.href='musician.let?type=query&pageIndex=1'</script>");
        } else {
            out.println("<script>alert('Failed to remove!');location.href='musician.let?type=query&pageIndex=1'</script>");
        }
    }

    private void playQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        String musicianSSN = req.getParameter("SSN");
        List<PlaysInstr> plays = playsInstrBiz.getBySSN(musicianSSN);
        req.setAttribute("plays", plays);
        req.getRequestDispatcher("play_list.jsp").forward(req, resp);
    }
}

