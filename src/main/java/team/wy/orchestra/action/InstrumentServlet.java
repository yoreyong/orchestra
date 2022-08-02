package team.wy.orchestra.action;

import com.alibaba.fastjson.JSON;
import team.wy.orchestra.bean.Instrument;
import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.biz.InstrumentBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: InstrumentServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/8/1
 **/
@WebServlet("/instrument.let")
public class InstrumentServlet extends HttpServlet {

    InstrumentBiz instrumentBiz = new InstrumentBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /instrument.let?type=add
     * /instrument.let?type=modifypre&id=xx
     * /instrument.let?type=remove=xx
     * /instrument.let?type=query&pageIndex=1
     * /instrument.let?type=details&id=xx
     * /instrument.let?type=doajax
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
        switch(type) {
            case "add":
                instrumentAdd(req, resp, out);
                break;
            case "remove": // 需要考虑foreign key:
                instrumentRemove(req, resp, out);
                break;
            case "modifypre":
                instrumentModifypre(req, resp, out);
                break;
            case "modify":
                instrumentModify(req, resp, out);
                break;
            case "query":
                instrumentQuery(req, resp, out);
                break;
            case "details": // 暂时不需要:
                instrumentDetails(req, resp, out);
                break;
            case "doajax":
                instrumentDoajax(req, resp,out);
                break;
            default:
                resp.sendError(404);
        }

    }

    private void instrumentAdd(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        String name = req.getParameter("name");
        String instrType = req.getParameter("instrType");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        int count = instrumentBiz.add(name, instrType, status);
        if(count > 0) {
            out.println("<script>alert('Success to add instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
        }
        else {
            out.println("<script>alert('Failed to add instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
        }
    }

    private void instrumentRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long instrumentId = Long.parseLong(req.getParameter("id"));
        try {
            int count = instrumentBiz.remove(instrumentId);
            if(count > 0) {
                out.println("<script>alert('Success to remove instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
            } else {
                out.println("<script>alert('Failed to remove instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('" + e.getMessage() + "');location.href='instrument.let?type=query&pageIndex=1'</script>");
        }
    }

    private void instrumentModifypre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        long instrumentId = Long.parseLong(req.getParameter("id"));
        Instrument instrument = instrumentBiz.getById(instrumentId);

        req.setAttribute("instrument", instrument);
        req.getRequestDispatcher("instrument_modify.jsp").forward(req, resp);
    }

    private void instrumentModify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String instrType = req.getParameter("instrType");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));

        try {
            int count = instrumentBiz.modify(id, name, instrType, status);
            if(count > 0) {
                out.println("<script>alert('Success to modify instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
            }
            else {
                out.println("<script>alert('Failed to modify instrument!');location.href='instrument.let?type=query&pageIndex=1'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('" + e.getMessage() + "');location.href='instrument.let?type=query&pageIndex=1'</script>");
        }
    }

    private void instrumentQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        // 获取信息(页数，页码，，信息)
        int pageSize = 10;
        long pageCount = instrumentBiz.getPageCount(pageSize);
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if(pageIndex < 1) {
            pageIndex = 1;
        }
        if(pageIndex > pageCount) {
            pageIndex = (int) pageCount;
        }
        List<Instrument> instruments = instrumentBiz.getByPage(pageIndex, pageSize);

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("instruments", instruments);
        req.getRequestDispatcher("instrument_list.jsp?pageIndex=" + pageIndex).forward(req, resp);

    }

    private void instrumentDetails(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void instrumentDoajax(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        String instrumentName = req.getParameter("name");
        List<Instrument> instruments = instrumentBiz.getByName(instrumentName);
        if(instruments == null) {
            out.print("{}");
        } else {
            out.print(JSON.toJSONString(instruments));
        }
    }
}
