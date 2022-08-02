<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "图书 java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <script src="Js/jquery-3.3.1.min.js"></script>
    <script>
        // 获取系统当前时间
        // function getCurrentDate() {
        //     var dateObj = new Date();
        //     var year = dateObj.getFullYear();
        //     var month = dateObj.getMonth()+1;
        //     var date = dateObj.getDate();
        //     var dateStr = year+"-"+(month>=10?month:"0"+month)+"-"+(date>=10?date:"0"+date);
        //     return dateStr;
        // }

        /**
         * 获取归还时间
         * @param count - 借阅时间
         * 通过毫秒数来计算
         */
        // function getBackDate(count) {
        //     // 获取系统当前时间
        //     var dateObj = new Date();
        //     // 拴成毫秒数
        //     var mills = dateObj.getMilliseconds();
        //     //
        //     mills += count*24*60*60*1000;
        //     // 转换成日期
        //     dateObj.setMilliseconds(mills);
        //     // 时间转成字符串
        //     var year = dateObj.getFullYear();
        //     var month = dateObj.getMonth()+1;
        //     var date = dateObj.getDate();
        //     var dateStr = year+"-"+(month>=10?month:"0"+month)+"-"+(date>=10?date:"0"+date);
        //     return dateStr;
        // }

        // console.log(getCurrentDate());
        // console.log(getBackDate(30));

        // function date2string(str) {
        //     var dateObj = new Date();
        //     dateObj.setMilliseconds(str);
        //     var year = dateObj.getFullYear();
        //     var month = dateObj.getMonth()+1;
        //     var date = dateObj.getDate();
        //     var dateStr = year+"-"+(month>=10?month:"0"+month)+"-"+(date>=10?date:"0"+date);
        //     return dateStr;
        // }


        $(function(){
            $("#btnQueryInstrument").prop("disabled","disabled");
            $("#btnSubmit").prop("disabled","disabled");
            var musicalWork = null;
            $("#btnQuery").click(function(){
                // 1.获取用户输入的身份证号
                var content = $("#musicalWorkName").val();
                //判断为null ,""
                if(!content){
                    alert("Input musical work name");
                    return;
                }
                // 2.调用js-ajax()/post()/get
                var url="musicalwork.let?type=doajax&name="+content;
                $.get(url,function(data,status) {
                    console.log(data);
                    // 将json字符串 --> json对象
                    musicalWork = JSON.parse(data);
                    console.log(musicalWork);

                    // 给组件赋值
                    $("#musicalWork_id").val(musicalWork[0].id);
                    $("#musicalWork_name").val(musicalWork[0].name);
                    $("#musicalWork_type").val(musicalWork[0].type.name);
                    $("#musicalWork_author").val(musicalWork[0].author);
                });

                // 关闭查询用户功能
                $(this).prop("disabled","disabled");
                // 开启查询按钮功能
                $("#btnQueryInstrument").removeAttr("disabled");
            });

            // 保存所有天剑过的书名
            var instrumentNameList = new Array();
            console.log(instrumentNameList);

            $("#btnQueryInstrument").click(function(){
                var name = $("#instrumentContent").val();
                var url = "instrument.let?type=doajax&name="+name;
                $.get(url,function(data,status){
                    console.log(data);

                    var instrument = JSON.parse(data);
                    console.log(instrument);

                    if(instrument.length===0){
                        alert("No such instrument!");
                        $("#instrumentContent").val("");
                        return;
                    }

                    // 判断这个instrument是否已经存在
                    if(instrumentNameList.indexOf(name)>=0){
                        alert("This instrument already exists!");
                        return;
                    }

                    // 添加instrument name到数组
                    instrumentNameList.push(name);

                    // 创建行
                    var tr = $("<tr align=\"center\" class=\"d\">");
                    // 创建多个列
                    var tdCheck = $("<td><input type=\"checkbox\" value=\""+instrument[0].id+"\" class=\"ck\" checked /></td>");
                    var tdName = $("<td>"+instrument[0].name+"</td>");
                    var tdType = $("<td>"+instrument[0].type+"</td>");
                    var tdStatus = $("<td>"+instrument[0].status+"</td>");

                    // 行加列
                    tr.append(tdCheck);
                    tr.append(tdName);
                    tr.append(tdType);
                    tr.append(tdStatus);

                    // 表加行
                    $("#tdMusicalWork").append(tr);
                    $("#musicalWorkContent").val("");
                    $("#btnSubmit").removeAttr("disabled");
                });
            });

            // 全选/全不选功能
            $("#ckAll").click(function(){
                $(".ck").prop("checked",$(this).prop("checked"));
            });

            // submit按钮对应的动作
            $("#btnSubmit").click(function(){
                var ids = new Array();
                var count = 0;
                $(".ck").each(function () {
                    if($(this).prop("checked")){
                        ids.push($(this).val());
                        count++;
                    }
                });
                if(count===0){
                    alert("Please select a instrument!");
                    return;
                }
                location.href="require.let?type=add&mid="+musicalWork[0].id+"&ids="+ids.join("_");
                console.log(ids.join("_"));
                console.log(musicalWork[0].id);
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">General > Plan Repertoire </h3></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="20" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 会员信息开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <fieldset>
                                    <legend>Musical Work</legend>
                                    <table width="100%" border="0" class="cont"  >

                                        <tr>
                                            <td width="10%" class="run-right"> Musical work name</td>
                                            <td colspan="7"><input class="text" type="text" id="musicalWorkName" name="musicalWorkName" placeholder="Input a musical work name"/>
                                                 <input type="button" id="btnQuery" value="Search" style="width: 80px;"/></td>

                                            </td>

                                        </tr>

                                        <tr>
                                            <td width="10%" class="run-right">ID</td>
                                            <td width="17%"><input class="text" type="text" id="musicalWork_id" disabled/></td>

                                            <td width="10%" class="run-right">Name:</td>
                                            <td width="17%"><input class="text" type="text" id="musicalWork_name" disabled/></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td width="10%" class="run-right">Type</td>
                                            <td width="17%"><input class="text" type="text" id="musicalWork_type" disabled/></td>

                                            <td width="10%" class="run-right">Author:</td>
                                            <td width="17%"><input class="text" type="text" id="musicalWork_author" disabled/></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                    </table>
                                </fieldset>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                      
                        <!--空行-->
                        <tr>
                            <td height="40" colspan="3">
                            </td>
                        </tr>
                        
                        <!--图书搜索条-->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <fieldset>
                                    <legend>Find a instrument</legend>
                                    <table width="100%" border="1" class="cont"  >
                                        <tr>
                                            <td colspan="8">
                                               
                                                Instrument name:&nbsp;&nbsp;<input class="text" type="text" id="instrumentContent" name="instrumentContent" placeholder="Input a instrument name"/>
                                                <input type="button" id="btnQueryInstrument" value="Confirm" style="width: 80px;"/>
                                                <input type="button" id="btnSubmit" value="Finish" style="width: 80px;"/>
                                            </td>
                                         
                                        </tr>
                                       
                                    </table>
                                </fieldset>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <tr><td height="20" colspan="3"></td></tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color" id="tdMusicalWork">

                                                    <tr>
                                                        <th><input type="checkbox" id="ckAll" checked/>All/None</th>
                                                        <th>Name</th>
                                                        <th>Type</th>
                                                        <th>Status</th>
                                                    </tr>
                                                   
                                                </table>
                                            </form>
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