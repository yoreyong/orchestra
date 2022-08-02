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

        $(function(){
            $("#btnQueryMusician").prop("disabled","disabled");
            $("#btnSubmit").prop("disabled","disabled");
            var concert = null;
            $("#btnQuery").click(function(){
                // 1.获取用户输入的身份证号
                var content = $("#concertId").val();
                //判断为null ,""
                if(!content){
                    alert("Input concert ID");
                    return;
                }
                // 2.调用js-ajax()/post()/get
                var url="concert.let?type=doajax&id="+content;
                $.get(url,function(data,status) {
                    // json字符串
                    // {"balance":200.0,"id":1,"idNumber":"300312199506150011","name":"andy","pwd":"andyliu","regDate":1627794000000,"tel":"13374645654","type":{"amount":"8","discount":80.0,"id":2,"keepDay":50,"name":"白银会员","recharge":200},"typeId":2}
                    console.log(data);
                    // 将json字符串 --> json对象
                    concert = JSON.parse(data);
                    console.log(concert);
                    console.log(concert.concert_name+","+concert.concertType.name+","+concert.place+","+concert.concert_date+","+concert.start_time);
                    // 给组件赋值
                    $("#concert_name").val(concert.concert_name);
                    $("#concert_type").val(concert.concertType.name);
                });

                // 关闭查询用户功能
                $(this).prop("disabled","disabled");
                // 开启查询按钮功能
                $("#btnQueryMusician").removeAttr("disabled");
            });

            // TODO-YY
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