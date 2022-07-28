package team.wy.orchestra.action;

import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.biz.MusicalWorkTypeBiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: MusicalWorkTypeServlet
 * @description:
 * @author: YORE
 * @date: 2022/7/27
 **/
@WebServlet("/musicalworktype.let")
public class MusicalWorkTypeServlet extends HttpServlet {

    MusicalWorkTypeBiz musicalWorkTypeBiz = new MusicalWorkTypeBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /musicalworktype.let?type=add:添加（表单）
     * /musicalworktype.let?type=modify：修改的预备界面（req->转发->type_modify.jsp）
     * /musicalworktype.let?type=modifypre：修改（表单）
     * /musicalworktype.let?type=remove&id=xx:删除（获取删除的类型编号）
     * /musicalworktype_list.jsp 查询(所有的数据类型：当项目运行时，将所有数据读出并放到application对象中)
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
        ServletContext application = req.getServletContext();

        String type = req.getParameter("type");
        switch (type) {
            case "add":
                add(req, resp, out, application);
                break;
            case "modifypre":
                modifyPre(req, resp, out, application);
                break;
            case "modify":
                modify(req, resp, out, application);
                break;
            case "remove":
                remove(req, resp, out, application);
                break;
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     * @param application
     */
    private void add(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, ServletContext application) {
        String typeName = req.getParameter("typeName");
        long parentId = Long.parseLong(req.getParameter("parentType"));
        int count = musicalWorkTypeBiz.add(typeName, parentId);

        if(count > 0) {
            List<MusicalWorkType> types = musicalWorkTypeBiz.getAllTypes();
            application.setAttribute("types", types);
            out.println("<script>alert('Success to add musical work type!');location.href='musicalworktype_list.jsp';</script>");
        } else {
            out.println("<script>alert('Failed to add musical work type!');location.href='musicalworktype_add.jsp';</script>");
        }
    }

    /**
     * @param req
     * @param resp
     * @param out
     * @param application
     */
    private void modifyPre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, ServletContext application) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        MusicalWorkType type = musicalWorkTypeBiz.getTypeById(id);
        req.setAttribute("type", type);
        req.getRequestDispatcher("musicalworktype_modify.jsp").forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     * @param application
     */
    private void modify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, ServletContext application) {
        long id = Long.parseLong(req.getParameter("typeId"));
        String name = req.getParameter("typeName");
        long parentId = Long.parseLong(req.getParameter("parentType"));
        int count = musicalWorkTypeBiz.modify(id, name, parentId);
        if(count > 0) {
            List<MusicalWorkType> types = musicalWorkTypeBiz.getAllTypes();
            application.setAttribute("types", types);
            out.println("<script>alert('Success to modify musical work type!');location.href='musicalworktype_list.jsp';</script>");
        } else {
            out.println("<script>alert('Failed to modify musical work type!');location.href='musicalworktype_list.jsp';</script>");
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     * @param application
     */
    private void remove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, ServletContext application) {
        long id = Long.parseLong(req.getParameter("id"));
        try {
            int count = musicalWorkTypeBiz.remove(id);
            if(count > 0) {
                List<MusicalWorkType> types = musicalWorkTypeBiz.getAllTypes();
                application.setAttribute("types", types);
                out.println("<script>alert('Success to remove musical work type!');location.href='musicalworktype_list.jsp';</script>");
            } else {
                out.println("<script>alert('Failed to remove musical work type!');location.href='musicalworktype_list.jsp';</script>");
            }
        } catch (Exception e) {
            // e.printStackTrace();
            out.println("<script>alert('"+e.getMessage()+"');location.href='musicalworktype_list.jsp';</script>");
        }
    }
}
