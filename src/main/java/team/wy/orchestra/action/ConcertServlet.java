package team.wy.orchestra.action;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.biz.ConcertBiz;
import team.wy.orchestra.biz.ConcertTypeBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: ConcertServlet
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
@WebServlet("/concert.let")
public class ConcertServlet extends HttpServlet {

    ConcertBiz concertBiz = new ConcertBiz();
    ConcertTypeBiz concertTypeBiz = new ConcertTypeBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /concert.let?type=add 添加
     * /concert.let?type=modifypre&id=xx 修改前准备
     * /concert.let?type=modify 修改
     * /concert.let?remove&id=xx 删除
     * /concert.let?type=query&pageIndex = 1 :分页查询（request:转发）
     * /concert.let?type=details&id=xx 展示书籍详细信息
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
                concertAdd(req, resp, out);
                break;
            case "remove":
                concertRemove(req, resp, out);
                break;
            case "modifypre":
                concertModifyPre(req, resp, out);
                break;
            case "modify":
                concertModify(req, resp, out);
                break;
            case "query":
                concertQuery(req, resp, out);
                break;
            case "details":
                concertDetails(req, resp, out);
                break;
            default:
                resp.sendError(404);
        }

    }

    private void concertAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void concertRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void concertModifyPre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void concertModify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {

    }

    private void concertQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        int pageSize = 10;
        int pageCount = concertBiz.getPageCount(pageSize);
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if(pageIndex < 1) {
            pageIndex = 1;
        }
        if(pageIndex > pageCount) {
            pageIndex = pageCount;
        }
        List<Concert> concerts = concertBiz.getByPage(pageIndex, pageSize);

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("concerts", concerts);
        req.getRequestDispatcher("concert_list.jsp?pageIndex=" + pageIndex).forward(req, resp);

    }

    private void concertDetails(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long concertId = Long.parseLong(req.getParameter("id"));
        Concert concert = concertBiz.getById(concertId);
        req.setAttribute("concert", concert);
        req.getRequestDispatcher("concert_details.jsp").forward(req, resp);
    }
}
