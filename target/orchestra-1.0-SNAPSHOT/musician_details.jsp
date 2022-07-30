<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "Orchestra java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <style>
        #content{
            width: 500px;
            height: 400px;
            overflow: scroll;
            margin-top: 10px;
            text-indent: 2em;
            line-height: 24px;
            font-size: 14px;
        }
    </style>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Musician > Details</h3></td>
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
                        <!-- 添加产品开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>SSN：</td>
                                                        <td width="20%"><input class="text" type="text" name="SSN"  value="${musician.SSN}" disabled="disabled"/></td>
                                                        <td rowspan="9" valign="top" >
                                                            <fieldset style="width: 205px; height: 265px;">
                                                             <legend>Image Preview</legend>
                                                             <img id="imgPic" src="${musician.pic}" style="width: 200px; height: 250px;"/>
                                                            </fieldset>
                                                        </td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>First name：</td>
                                                        <td width="25%"><input class="text" type="text" name="fname" value="${musician.fname}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Last name：</td>
                                                        <td width="20%"><input class="text" type="text" name="lname" value="${musician.lname}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Gender：</td>
                                                        <td width="20%"><input class="text" type="text" name="gender" value="${musician.gender}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Phone number：</td>
                                                        <td width="20%"><input class="text" type="text" name="phoneNum" value="${musician.phoneNum}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>State：</td>
                                                        <td width="20%"><input class="text" type="text" name="state" value="${musician.state}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>City：</td>
                                                        <td width="20%"><input class="text" type="text" name="city" value="${musician.city}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Zip code：</td>
                                                        <td width="20%"><input class="text" type="text" name="zip" value="${musician.zip}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Address：</td>
                                                        <td width="20%"><input class="text" type="text" name="address" value="${musician.address}" disabled="disabled"/></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                </table>
                                            </form>
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
									
									<tr>
							
                                        <td><b>Salary</b>：
											<table width="60%" colspan="4" class="cont tr_color">
												<tr>
													<th>Date</th>
													<th>Salary</th>
													<th> </th>
												</tr>
												
												<tr align="center" class="d">
													<td>2022-01-10</td>
													<td>12000</td>
                                                    <td>
                                                        <a href="#">修改</a>&nbsp;&nbsp;
                                                        <a href="#">删除</a>
                                                    </td>
												</tr>
												
												<tr align="center" class="d">
													<td>2022-02-10</td>
													<td>10000</td>
													<td>
                                                        <a href="#">修改</a>&nbsp;&nbsp;
                                                        <a href="#">删除</a>
                                                    </td>
												</tr>
												
												<tr align="center" class="d">
													<td>2022-03-10</td>
													<td>14000</td>
													<td>
                                                        <a href="#">修改</a>&nbsp;&nbsp;
                                                        <a href="#">删除</a>
                                                    </td>
												</tr>
											
											</table>
										</td>
										<td></td>
									</tr>
									
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 添加产品结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                  
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