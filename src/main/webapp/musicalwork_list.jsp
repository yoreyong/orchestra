<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "Orchestra java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="./Images/mail_left_bg.gif">
                    <img src="./Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="./Images/content_bg.gif">
                    
                </td>
                <td width="16" valign="top" background="./Images/mail_right_bg.gif"><img src="./Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="./Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4">
                                <table>
                                    <tr>
                                        <td width="100" align="center"><img src="./Images/mime.gif" /></td>
                                        <td valign="bottom"><h3 style="letter-spacing:1px;"><b>Musical work</b> > <b>List</b></h3></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 产品列表开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">

                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>Musical Work ID</th>
                                                        <th>Name</th>
                                                        <th>Author</th>
                                                        <th>Type</th>
                                                        <th>Instrument</th>
                                                        <th>Operation</th>
                                                    </tr>

                                                    <c:forEach items="${musicalWorks}" var="m">
                                                        <tr align="center" class="d">
                                                            <td><a href="musicalwork.let?type=details&id=${m.id}">${m.id}</a></td>
                                                            <td>${m.name}</td>
                                                            <td>${m.author}</td>
                                                            <td>${m.type.name}</td>
                                                            <td>
                                                                <a onclick="" href="require.let?type=query&id=${m.id}"><u>View</u></a>
                                                            </td>
                                                            <td>
                                                                <a onclick="return confirm('Confirm modification');" href="musicalwork.let?type=modifypre&id=${m.id}"><u>Modify</u></a>&nbsp;&nbsp;
                                                                <a onclick="return confirm('Confirm deletion');" href="musicalwork.let?type=remove&id=${m.id}"><u>Delete</u></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>

                                                   <tr><td colspan="12" align="center">
                                                    <div class="pager">
                                                        <ul class="clearfix">
                                                            <li><a href="musicalwork.let?type=query&pageIndex=${param.pageIndex-1}">Prev</a></li>
                                                            <c:forEach var="i" begin="1" end="${pageCount}" step="1">
                                                                <c:if test="${i==param.pageIndex}">
                                                                    <li class="current"><a href="musicalwork.let?type=query&pageIndex=${i}">${i}</a></li>
                                                                </c:if>
                                                                <c:if test="${i!=param.pageIndex}">
                                                                    <li><a href="musicalwork.let?type=query&pageIndex=${i}">${i}</a></li>
                                                                </c:if>
                                                            </c:forEach>
                                                            <li><a href="musicalwork.let?type=query&pageIndex=${param.pageIndex+1}">Next</a></li>
                                                        </ul>
                                                    </div>
                                                   </td></tr>
                                                </table>

                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 产品列表结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
<%--                        <tr>--%>
<%--                            <td width="2%">&nbsp;</td>--%>
<%--                            <td width="51%" class="left_txt">--%>
<%--                                <img src="./Images/icon_mail.gif" width="16" height="11"> 客户服务邮箱：2087924818@qq.com<br />--%>
<%--                            </td>--%>
<%--                            <td>&nbsp;</td><td>&nbsp;</td>--%>
<%--                        </tr>--%>
                    </table>
                </td>
                <td background="./Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="./Images/mail_left_bg.gif">
                    <img src="./Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="./Images/buttom_bgs.gif">
                    <img src="./Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="./Images/mail_right_bg.gif">
                    <img src="./Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
    </body>
</html>