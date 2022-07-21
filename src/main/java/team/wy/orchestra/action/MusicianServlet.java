package team.wy.orchestra.action;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import team.wy.orchestra.bean.Musician;
import team.wy.orchestra.biz.MusicianBiz;
import team.wy.orchestra.util.DateHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: MusicianServlet
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
@WebServlet("/musician.let")
public class MusicianServlet extends HttpServlet {
    MusicianBiz musicianBiz = new MusicianBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /musician.let?type=add 添加
     * /musician.let?type=modifypre&id=xx 修改前准备
     * /musician.let?type=modify 修改
     * /musician.let?remove&id=xx 删除
     * /musician.let?type=query&pageIndex = 1 :分页查询（request:转发）
     * /musician.let?type=details&id=xx 展示书籍详细信息
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
                try {
                    add(req, resp, out);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                    resp.sendError(500, "Failed to upload file!");
                } catch (Exception e) {
                    e.printStackTrace();
                    resp.sendError(500, e.getMessage());
                }
                break;
            case "modifypre":
                modifypre(req, resp, out);
                break;
            case "modify":
                try {
                    modify(req, resp, out);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                    resp.sendError(500, "Failed to upload file!");
                } catch (Exception e) {
                    e.printStackTrace();
                    resp.sendError(500, e.getMessage());
                }
                break;
            case "remove":
                remove(req, resp, out);
                break;
            case "query":
                query(req, resp, out);
                break;
            case "details":
                details(req, resp, out);
                break;
            default:
                resp.sendError(404);
        }
    }

    /**
     * @param req
     * @param resp
     * @param out
     */
    private void details(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        String SSN = req.getParameter("SSN");
        Musician musician = musicianBiz.getMusicianBySSN(SSN);
        req.setAttribute("musician", musician);
        req.getRequestDispatcher("musician_details.jsp").forward(req, resp);
    }

    /**
     * @param req
     * @param resp
     * @param out
     */
    private void query(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        int pageSize = 8;
        int pageCount = musicianBiz.getMusicianPageCount(pageSize);
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if(pageIndex < 1) {
            pageIndex = 1;
        }
        if(pageIndex > pageCount) {
            pageIndex = pageCount;
        }

        List<Musician> musicians = musicianBiz.getMusiciansByPage(pageIndex, pageSize);

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("musicians", musicians);

        req.getRequestDispatcher("musician_list.jsp?pageIndex=" + pageIndex).forward(req, resp);
    }

    /**
     * @param req
     * @param resp
     * @param out
     */
    private void remove(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        String SSN = req.getParameter("SSN");
        int count = musicianBiz.remove(SSN);
        if(count > 0) {
            out.println("<script>alert('Success to remove musician!');location.href='musician.let?type=query&pageIndex=1'</script>");
        } else {
            out.println("<script>alert('Failed to remove musician!');location.href='musician.let?type=query&pageIndex=1'</script>");
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     */
    private void modify(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws Exception {
        // int pageIndex = 0;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 9);
        File file = new File("D:\\04_WorkSpace\\00_Archive\\temp_orchestra");
        if(!file.exists()) {
            file.mkdir();
        }
        factory.setRepository(file);

        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        List<FileItem> fileItems = fileUpload.parseRequest(req);

        Musician musician = new Musician();
        for(FileItem item : fileItems) {
            if(item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString("utf-8");
                switch (name){
                    case "SSN":
                        musician.setSSN(value);
                        break;
                    case "fname":
                        musician.setFname(value);
                        break;
                    case "lname":
                        musician.setLname(value);
                        break;
                    case "gender":
                        musician.setGender(value);
                        break;
                    case "phoneNum":
                        musician.setPhoneNum(value);
                        break;
                    case "state":
                        musician.setState(value);
                        break;
                    case "city":
                        musician.setCity(value);
                        break;
                    case "address":
                        musician.setAddress(value);
                        break;
                    case "zip":
                        musician.setZip(value);
                        break;
                    case "pic":
                        musician.setPic(value);
                        break;
                    // case "pageIndex":
                    //     pageIndex = Integer.parseInt(value);
                }
            } else {
                String fileName = item.getName();
                if(fileName.trim().length() > 0) {
                    String filterName = fileName.substring(fileName.lastIndexOf("."));
                    fileName = DateHelper.getImageName() + filterName;
                    String path = req.getServletContext().getRealPath("/Images/cover");
                    String filepath = path + "/" + fileName;
                    String dbPath = "Images/cover/" + fileName;
                    musician.setPic(dbPath);

                    item.write(new File(filepath));
                }
            }
        }

        int count = musicianBiz.modify(musician);
        if(count>0){
            out.println("<script>alert('Success to add musician!');location.href='musician.let?type=query&pageIndex=1';</script>");
            // out.println("<script>alert('Success to add musician!');location.href='musician.let?type=query&pageIndex=" + pageIndex + "';</script>");
        }else{
            out.println("<script>alert('Failed to add musician');location.href='musician.let?type=query&pageIndex=1';</script>");
            // out.println("<script>alert('Failed to add musician');location.href='musician.let?type=query&pageIndex=" + pageIndex + "';</script>");
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     */
    private void modifypre(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        String SSN = req.getParameter("SSN");
        Musician musician = musicianBiz.getMusicianBySSN(SSN);
        // String pageIndex = req.getParameter("pageIndex");
        // req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("musician", musician);
        req.getRequestDispatcher("musician_modify.jsp").forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @param out
     */
    private void add(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 9);
        File file = new File("D:\\04_WorkSpace\\00_Archive\\temp_orchestra");
        if(!file.exists()) {
            file.mkdir();
        }
        factory.setRepository(file);

        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        List<FileItem> fileItems = fileUpload.parseRequest(req);

        Musician musician = new Musician();
        for(FileItem item : fileItems) {
            if(item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString("utf-8");
                switch (name){
                    case "SSN":
                        musician.setSSN(value);
                        break;
                    case "fname":
                        musician.setFname(value);
                        break;
                    case "lname":
                        musician.setLname(value);
                        break;
                    case "gender":
                        musician.setGender(value);
                        break;
                    case "phoneNum":
                        musician.setPhoneNum(value);
                        break;
                    case "state":
                        musician.setState(value);
                        break;
                    case "city":
                        musician.setCity(value);
                        break;
                    case "address":
                        musician.setAddress(value);
                        break;
                    case "zip":
                        musician.setZip(value);
                        break;
                }
            } else {
                String fileName = item.getName();
                String filterName = fileName.substring(fileName.lastIndexOf("."));
                fileName = DateHelper.getImageName() + filterName;

                String path = req.getServletContext().getRealPath("/Images/cover");
                String filePath = path + "/" + fileName;

                String dbpath = "Images/cover/" + fileName;
                musician.setPic(dbpath); // set SQL table `pic`

                item.write(new File(filePath));
            }
        }

        int count = musicianBiz.add(musician);
        if(count>0){
            out.println("<script>alert('Success to add musician!');location.href='musician.let?type=query&pageIndex=1';</script>");
        }else{
            out.println("<script>alert('Failed to add musician');location.href='musician_add.jsp';</script>");
        }
    }
}
