<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "Orchestra java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <script src="Js/jquery-3.3.1.min.js"></script>
    <script>
       //图片预览
       function getFullPath(obj){
           if (obj){
               //ie
               if (window.navigator.userAgent.indexOf("MSIE") >= 1){
                   obj.select();
                   return document.selection.createRange().text;
               }else if (window.navigator.userAgent.indexOf("Firefox") >= 1){
                   //firefox　
                   return window.URL.createObjectURL(obj.files.item(0));
               }else if(navigator.userAgent.indexOf("Chrome")>0){
                   //chrome
                   return window.URL.createObjectURL(obj.files.item(0));
               }
               return obj.value;
           }
       }
       $(function(){
           $("#pic").change(function(){
               var path = getFullPath($(this)[0]);
               console.log(path);
               $("#imgPic").prop("src",path);
           });
       });
    </script>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;"><b>Musical work</b> > <b>Add</b></h3></td>
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
                                            <form action="musicalwork.let?type=add" method="post" >
                                                <table width="100%"class="cont">

                                                    <!-- SSN号码
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="2%">Id：</td>
                                                        <td width="25%"><input class="text" style="width:50px;" type="text" name="id" /></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    -->

                                                    <!-- 名 -->
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="2%">Name：</td>
                                                        <td width="20%"><input class="text" type="text" name="name"/></td>
                                                        
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <!-- 姓 -->
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Authro：</td>
                                                        <td width="20%"><input class="text" type="text" name="author"/></td>
                                                        
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <!-- 性别 -->
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Type：</td>
                                                        <td width="20%"><input class="text" type="text" name="typeId"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Description:</td>
                                                        <td colspan="2"><textarea cols="150" rows="20" name="desc"></textarea></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td></td>
                                                        <td colspan="3"><input class="btn" type="submit" value="Submit" /></td>
                                 
                                                    </tr>
                                                </table>
                                            </form>
                                        </td>
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