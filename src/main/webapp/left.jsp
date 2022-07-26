<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "Orchestra java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <script src="./Js/prototype.lite.js" type="text/javascript"></script>
    <script src="./Js/moo.fx.js" type="text/javascript"></script>
    <script src="./Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    }
            }
        }
    </script>
</head>

<body>
    <table width="100%" height="200" border="0" cellpadding="0" cellspacing="0" >
        <tr>
            <td width="182" valign="top">
                <div id="container">
                    <!--
                    <h1 class="type"><a href="javascript:void(0)">Customer</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./customer_add.jsp" target="main">New customer</a></li>
                            <li><a href="./customer_list.jsp" target="main">List</a></li>
                            <li><a href="./book_edit.jsp" target="main">Book</a></li>
                        </ul>
                    </div>

                    -->

                    <!-- Concert -->
                    <h1 class="type"><a href="javascript:void(0)">Concert</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./concert.let?type=addpre" target="main">Add</a></li>
                            <li><a href="./concert.let?type=query&pageIndex=1" target="main">List</a></li>
                        </ul>
                    </div>

                    <!-- Musician -->
                    <h1 class="type"><a href="javascript:void(0)">Musician</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./musician_add.jsp" target="main">Add</a></li>
                            <li><a href="./musician.let?type=query&pageIndex=1" target="main">List</a></li>
                        </ul>
                    </div>

                    <!-- Musical work -->
                    <h1 class="type"><a href="javascript:void(0)">Musical Work</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./musicalwork.let?type=addpre" target="main">Add</a></li>
                            <li><a href="./musicalwork.let?type=query&pageIndex=1" target="main">List</a></li>
                        </ul>
                    </div>

                    <!-- Instrument -->
                    <h1 class="type"><a href="javascript:void(0)">Instrument</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./instrument_add.jsp" target="main">Add</a></li>
                            <li><a href="./instrument.let?type=query&pageIndex=1" target="main">List</a></li>
                        </ul>
                    </div>

                    <h1 class="type"><a href="javascript:void(0)">General Edit</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <!-- 编制曲目 -->
                            <li><a href="./repertoire_edit.jsp" target="main">Plan Repertoire</a></li>
                            <!-- 配置musician -->
                            <li><a href="./participate_edit.jsp" target="main">Musicians => Concert</a></li>
                            <!-- 为musical work配置instruments -->
                            <li><a href="./require_edit.jsp" target="main">Instruments => MusicalWork</a></li>
                            <!-- 为musical work配置instruments -->
                            <li><a href="./play_edit.jsp" target="main">Instruments => Musician</a></li>
                        </ul>
                    </div>

                    <!-- Settings -->
                    <h1 class="type"><a href="javascript:void(0)">Settings</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./set_pwd.jsp" target="main">Reset Password</a></li>
                        
                        </ul>
                    </div>
                   
                    <!-- *********** -->
                   
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="javascript:void(0)" target="main">友情连接</a></li>
                            <li><a href="javascript:void(0)" target="main">在线留言</a></li>
                            <li><a href="javascript:void(0)" target="main">网站投票</a></li>
                            <li><a href="javascript:void(0)" target="main">邮箱设置</a></li>
                            <li><a href="javascript:void(0)" target="main">图片上传</a></li>
                        </ul>
                    </div>
                    <!-- *********** -->
                </div>
            </td>
        </tr>
    </table>
</body>
</html>
