package team.wy.orchestra.action;

import team.wy.orchestra.bean.User;
import team.wy.orchestra.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: UserServlet
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/11
 **/
@WebServlet(urlPatterns = "/user.let")
public class UserServlet extends HttpServlet {
    // 构建UserBiz对象
    UserBiz userBiz = new UserBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /user.let?type=login 登录
     * /user.let?type=exit 安全退出
     * /user.let?type=modifyPwd 修改密码
     * @description: doPost
     *
     * @param:  req, resp
     * @return:
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 1. 判断用户请求的类型为login
        String method = req.getParameter("type");
        switch (method) {
            case "login":
                // 2. 从login.html中获取用户名和密码
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");
                String userCode = req.getParameter("valcode");

                // 2.2 提取session中的验证码
                String code = session.getAttribute("code").toString();
                // 不区分大小写
                if(!code.equalsIgnoreCase(userCode)) {
                    out.println("<script>alert('Confirmation Code Error!');location.href = 'login.html';</script>");
                    return;
                }

                // 3. 调用UserBiz的getUser方法，根据用户名和密码获取对应的用户对象
                User user = userBiz.getUser(name, pwd);
                // 4. 判断用户对象是否为null
                if(user == null) {
                    // 4.1 如果是null表示用户名或密码不正确，提示错误，回到登录页面
                    out.println("<script>alert('Invalid username or password');location.href = 'login.html';</script>");
                } else {
                    // 4.2 非空，表示登录成功，将用户对象保存到session中，提示登录成功后，将页面跳转至index.jsp
                    session.setAttribute("user",user);
                    out.println("<script>alert('Login successfully!');location.href='index.jsp';</script>");
                }
                break;

            case "exit":
                // 1.清理session
                session.invalidate();
                // 2.跳转到html
                out.println("<script>parent.window.location.href='login.html';</script>");
                break;

            case "modifyPwd":
                // 用户修改密码
                // 获取用户输入的新密码
                String newPwd = req.getParameter("newpwd");
                // 获取用户编号 - session
                Long id = ((User) session.getAttribute("user")).getId();
                // 调用biz层方法
                int count = userBiz.modifyPwd(id, newPwd);

                // 响应操作
                if(count > 0) {
                    out.println("<script>alert('Password reset complete!');parent.window.location.href='login.html';</script>");
                } else {
                    out.println("<script>alert('Password change failed!');</script>");
                }

                break;
        }

    }
}
