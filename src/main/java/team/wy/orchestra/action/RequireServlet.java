package team.wy.orchestra.action;

import team.wy.orchestra.bean.RequireInstrument;
import team.wy.orchestra.biz.RequireInstrumentBiz;

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
 * @className: RequireServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/1
 **/
@WebServlet("/require.let")
public class RequireServlet extends HttpServlet {

    RequireInstrumentBiz requireInstrumentBiz = new RequireInstrumentBiz();

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
                requireAdd(req, resp, out);
                break;
            case "remove":
                requireRemove(req, resp, out);
                break;
            case "query":
                requireQuery(req, resp, out);
                break;
            default:
                resp.sendError(404, "请求的地址不存在");
        }
    }

    private void requireAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long musicalWorkId = Long.parseLong(req.getParameter("mid"));
        String ids = req.getParameter("ids");
        String[] strs = ids.split("_");
        List<Long> instrumentIds = new ArrayList<Long>();
        for(String i : strs) {
            long id = Long.parseLong(i);
            instrumentIds.add(id);
        }
        int count = requireInstrumentBiz.add(instrumentIds, musicalWorkId);
        if(count > 0) {
            out.println("<script>alert('Success to connect instruments with musical work!');location.href='require.let?type=query&pageIndex=1&id="+musicalWorkId+"';</script>");
        } else {
            out.println("<script>alert('Failed to connect instruments with musical work!');location.href='main.jsp';</script>");
        }
    }

    private void requireRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long requireId = Long.parseLong(req.getParameter("rid"));
        int count = requireInstrumentBiz.remove(requireId);
        if(count > 0) {
            out.println("<script>alert('Success to remove!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
        } else {
            out.println("<script>alert('Failed to remove!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
        }
    }

    private void requireQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long musicalWorkId = Long.parseLong(req.getParameter("id"));
        List<RequireInstrument> requires = requireInstrumentBiz.getByMusicalWork(musicalWorkId);
        req.setAttribute("requires", requires);
        req.getRequestDispatcher("require_list.jsp").forward(req, resp);
    }
}
