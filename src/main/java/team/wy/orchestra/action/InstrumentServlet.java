package team.wy.orchestra.action;

import com.alibaba.fastjson.JSON;
import team.wy.orchestra.bean.Instrument;
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
    }

    private void instrumentRemove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void instrumentModifypre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void instrumentModify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
    }

    private void instrumentQuery(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
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
