package team.wy.orchestra.action;

import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.biz.MusicalWorkBiz;
import team.wy.orchestra.biz.MusicalWorkTypeBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: MusicalWorkServlet
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
@WebServlet("/musicalwork.let")
public class MusicalWorkServlet extends HttpServlet {

    MusicalWorkBiz musicalWorkBiz = new MusicalWorkBiz();
    MusicalWorkTypeBiz musicalWorkTypeBiz = new MusicalWorkTypeBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /musicalwork.let?type=add 添加
     * /musicalwork.let?type=modifypre&id=xx 修改前准备
     * /musicalwork.let?type=modify 修改
     * /musicalwork.let?remove&id=xx 删除
     * /musicalwork.let?type=query&pageIndex = 1 :分页查询（request:转发）
     * /musicalwork.let?type=details&id=xx 展示书籍详细信息
     * @param req -
     * @param resp -
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String type = req.getParameter("type");
        switch(type) {
            case "add":
                musicalWorkAdd(req, resp, out);
                break;
            case "modifypre":
                musicalWorkModifyPre(req, resp, out);
                break;
            case "modify":
                musicalWorkModify(req, resp, out);
                break;
            case "remove":
                musicalWorkRemove(req, resp, out);
                break;
            case "query":
                musicalWorkQuery(req, resp, out);
                break;
            case "details":
                musicalWorkDetails(req, resp, out);
                break;
            default:
                resp.sendError(404);
        }
    }


    private void musicalWorkDetails(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long musicalWorkId = Long.parseLong(req.getParameter("id"));
        MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(musicalWorkId);
        req.setAttribute("musicalWork", musicalWork);
        req.getRequestDispatcher("musicalwork_details.jsp").forward(req, resp);
    }


    /**
     *
     * @param req
     * @param resp
     * @param out
     * @throws ServletException
     * @throws IOException
     */
    private void musicalWorkQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        // 获取信息(页数，页码，，信息)
        int pageSize = 15;
        int pageCount = musicalWorkBiz.getPageCount(pageSize);
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if(pageIndex < 1) {
            pageIndex = 1;
        }
        if(pageIndex > pageCount) {
            pageIndex = pageCount;
        }
        List<MusicalWork> musicalWorks = musicalWorkBiz.getMusicalWorkByPage(pageIndex, pageSize);

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("musicalWorks", musicalWorks);
        req.getRequestDispatcher("musicalwork_list.jsp?pageIndex=" + pageIndex).forward(req, resp);
    }

    private void musicalWorkRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long musicalWorkId = Long.parseLong(req.getParameter("id"));
        try {
            int count = musicalWorkBiz.remove(musicalWorkId);
            if(count > 0) {
                out.println("<script>alert('Success to remove musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            } else {
                out.println("<script>alert('Failed to remove musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('" + e.getMessage() + "');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
        }
    }


    private void musicalWorkModify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        long typeId = Long.parseLong(req.getParameter("typeId"));
        String desc = req.getParameter("desc");
        try {
            int count = musicalWorkBiz.modify(id, name, author, desc, typeId);
            if(count > 0) {
                out.println("<script>alert('Success to modify musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            }
            else {
                out.println("<script>alert('Failed to modify musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('" + e.getMessage() + "');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
        }
    }


    private void musicalWorkModifyPre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long musicalWorkId = Long.parseLong(req.getParameter("id"));
        MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(musicalWorkId);
        List<MusicalWorkType> musicalWorkTypes = musicalWorkTypeBiz.getAllTypes();
        req.setAttribute("musicalWork", musicalWork);
        req.getRequestDispatcher("musicalwork_modify.jsp").forward(req, resp);
    }

    private void musicalWorkAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        long typeId = Long.parseLong(req.getParameter("typeId"));
        String desc = req.getParameter("desc");
        try {
            int count = musicalWorkBiz.add(name, author, desc, typeId);
            if(count > 0) {
                out.println("<script>alert('Success to add musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            }
            else {
                out.println("<script>alert('Failed to add musical work!');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('" + e.getMessage() + "');location.href='musicalwork.let?type=query&pageIndex=1'</script>");
        }
    }
}
