package team.wy.orchestra.action;

import com.alibaba.fastjson.JSON;
import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.ConcertType;
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
            case "addpre":
                List<ConcertType> concertTypes = concertTypeBiz.getAll();

                req.setAttribute("concertTypes", concertTypes);
                req.getRequestDispatcher("concert_add.jsp").forward(req, resp);
                break;
            case "add":
                String name = req.getParameter("name");
                String place = req.getParameter("place");
                String date = req.getParameter("date");
                String time = req.getParameter("time");
                String desc = req.getParameter("desc");
                long typeId = Long.parseLong(req.getParameter("concertType"));
                double price = Double.parseDouble(req.getParameter("price"));

                int count = concertBiz.add(name, place, date, time, desc, typeId, price);
                // List<Concert> concerts = concertBiz.getAll();
                // Concert recentConcert = concerts.;

                if (count > 0) {
                    out.println("<script>alert('Success to add a new concert!'); location.href='concert.let?type=query&pageIndex=1';</script>");
                } else {
                    out.println("<script>alert('Failed to add a new concert!'); location.href='concert.let?type=query&pageIndex=1';</script>");
                }
                break;
            case "remove":
                long concertId_0 = Long.parseLong(req.getParameter("id"));
                try {
                    int remove_count = concertBiz.remove(concertId_0);
                    if(remove_count > 0) {
                        out.println("<script>alert('Success to remove a concert!');location.href='concert.let?type=query&pageIndex=1'</script>");
                    } else {
                        out.println("<script>alert('Failed to remove a concert!');location.href='concert.let?type=query&pageIndex=1'</script>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<script>alert('" + e.getMessage() + "');location.href='concert.let?type=query&pageIndex=1'</script>");
                }
                break;
            case "modifypre":
                long concertId = Long.parseLong(req.getParameter("id"));
                Concert concert = concertBiz.getById(concertId);
                List<ConcertType> concertTypes2 = concertTypeBiz.getAll();

                req.setAttribute("concert", concert);
                req.setAttribute("concertTypes", concertTypes2);
                req.getRequestDispatcher("concert_modify.jsp").forward(req, resp);
                break;
            case "modify":
                long id = Long.parseLong(req.getParameter("id"));
                String name_m = req.getParameter("name");
                String place_m = req.getParameter("place");
                String date_m = req.getParameter("date");
                String time_m = req.getParameter("time");
                String desc_m = req.getParameter("desc");
                long concertTypeId = Long.parseLong(req.getParameter("concertType"));
                double price_m = Double.parseDouble(req.getParameter("price"));

                int count_m = concertBiz.modify(id, name_m, place_m, date_m, time_m, desc_m, concertTypeId, price_m);
                if (count_m > 0) {
                    out.println("<script>alert('Success to modify concert!');location.href='concert.let?type=query&pageIndex=1'</script>");
                } else {
                    out.println("<script>alert('Failed to modify concert!');location.href='concert.let?type=query&pageIndex=1'</script>");
                }
                break;
            case "query":
                int pageSize = 15;
                int pageCount = concertBiz.getPageCount(pageSize);
                int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
                if (pageIndex < 1) {
                    pageIndex = 1;
                }
                if (pageIndex > pageCount) {
                    pageIndex = pageCount;
                }
                List<Concert> concerts = concertBiz.getByPage(pageIndex, pageSize);

                req.setAttribute("pageCount", pageCount);
                req.setAttribute("concerts", concerts);
                req.getRequestDispatcher("concert_list.jsp?pageIndex=" + pageIndex).forward(req, resp);
                break;
            case "details":
                concertDetails(req, resp, out);
                break;
            case "doajax":
                long idNum = Long.parseLong(req.getParameter("id"));
                Concert concert1 = concertBiz.getById(idNum);
                String concertJson = JSON.toJSONString(concert1);
                out.print(concertJson);
                break;
            default:
                resp.sendError(404);

        }
    }


    private void concertDetails(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long concertId = Long.parseLong(req.getParameter("id"));
        Concert concert = concertBiz.getById(concertId);
        req.setAttribute("concert", concert);
        req.getRequestDispatcher("concert_details.jsp").forward(req, resp);
    }
}
