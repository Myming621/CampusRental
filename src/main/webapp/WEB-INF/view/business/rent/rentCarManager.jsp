<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>出租管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <%--<link rel="icon" href="favicon.ico">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
</head>
<body class="childrenBody">

<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>

<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">身份证号:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="identity" id="identity" autocomplete="off"
                       class="layui-input layui-input-inline"
                       placeholder="请输入身份证号" style="height: 30px;border-radius: 10px">
            </div>
            <button type="button"
                    class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm"
                    id="doSearch" style="margin-top: 4px">查询
            </button>
            <button type="reset"
                    class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm"
                    style="margin-top: 4px">重置
            </button>
        </div>
    </div>
</form>

<!-- 数据表格开始 -->
<div id="content" style="display: none;">
    <table id="carTable" lay-filter="carTable"></table>
    <div id="carBar" style="display: none;">
        <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-radius" lay-event="rentCar">出租汽车</a>
        <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="viewImage">查看车辆大图</a>
    </div>
</div>

<%--添加和修改的弹出层开始--%>
<div style="display: none;padding: 20px;" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">出租单号:</label>
            <div class="layui-input-block">
                <input type="text" name="rentid" lay-verify="required" readonly="readonly" placeholder="请输入出租单号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">起租时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="begindate" id="begindate" lay-verify="required" placeholder="请输入起租时间"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">还车时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="returndate" id="returndate" lay-verify="required" placeholder="请输入还车时间"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">身份证号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="identity" lay-verify="required" readonly="readonly" placeholder="请输入身份证号"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车牌号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnumber" lay-verify="required" readonly="readonly" placeholder="请输入车牌号"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出租价格:</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required" placeholder="请输入出租价格" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">操作员:</label>
                <div class="layui-input-inline">
                    <input type="text" name="opername" id="opername" lay-verify="required" placeholder="请输入操作员"
                           readonly="readonly" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: center;padding-right: 120px">
                <button type="button"
                        class="layui-btn layui-btn-normal layui-btn-md layui-icon layui-icon-release layui-btn-radius"
                        lay-filter="doSubmit" lay-submit="">提交
                </button>
                <button type="reset"
                        class="layui-btn layui-btn-warm layui-btn-md layui-icon layui-icon-refresh layui-btn-radius">重置
                </button>
            </div>
        </div>
    </form>
</div>

<%--查看大图弹出的层开始--%>
<div id="viewCarImageDiv" style="display: none;text-align: center">
    <img alt="出租图片" id="view_carimg">
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">


    //var tableIns;
    layui.use(['jquery', 'layer', 'form', 'table', 'laydate'], function () {
            var $ = layui.jquery;
            var layer = layui.layer;
            var form = layui.form;
            var table = layui.table;
            var dtree = layui.dtree;
            var laydate = layui.laydate;

            //渲染日期表格
            laydate.render({
                elem: '#begindate',
                type: 'datetime'
            });

            laydate.render({
                elem: '#returndate',
                type: 'datetime'
            });

            var tableIns;

            function initCarData() {
                //渲染数据表格
                tableIns = table.render({
                    elem: '#carTable', //渲染的⽬标对象
                    url: '${pageContext.request.contextPath}/car/loadAllCar.action?isrenting=0', //数据接⼝
                    title: '⻋辆列表',//数据导出来的标题
                    height: 'full-150',
                    page: true,//是否启⽤分⻚
                    cols: [[ //列表数据
                        {field: 'carnumber', title: '⻋牌号', align: 'center', width: '95'},
                        {field: 'cartype', title: '出租类型', align: 'center', width: '90'},
                        {field: 'color', title: '出租颜⾊', align: 'center', width: '90'},
                        {field: 'price', title: '汽⻋价格', align: 'center', width: '90'},
                        {field: 'rentprice', title: '出租价格', align: 'center', width: '90'},
                        {field: 'deposit', title: '出租押⾦', align: 'center', width: '90'},
                        {
                            field: 'isrenting', title: '出租状态', align: 'center', width: '90', templet: function (d) {
                                return d.isrenting == '1' ? '<fontcolor=blue>已出租</font>' : '<font color=red>未出租</font>';
                            }
                        },
                        {field: 'description', title: '出租描述', align: 'center', width: '150'},
                        {
                            field: 'carimg', title: '缩略图', align: 'center', width: '80', templet: function (d) {
                                return "<img width=40 height=40 src=${pageContext.request.contextPath}/file/downloadShowFile.action?path=" + d.carimg + "/>";
                            }
                        },
                        {field: 'createtime', title: '录⼊时间', align: 'center', width: '170'},
                        {fixed: 'right', title: '操作', toolbar: '#carBar', align: 'center', width: '220'},
                    ]]
                });
            }

            //根据身份证号码查询
            $("#doSearch").click(function () {
                var params = $("#searchFrm").serialize();
                $.post("${pageContext.request.contextPath}/rent/checkCustomerExit.action", params, function (obj) {
                    if (obj.code >= 0) { //此客户存在，code的返回值为0
                        $("#content").show();
                        initCarData(); //初始化未出租汽⻋的所有数据
                    } else {
                        layer.msg("客户身份证号不存在，请更正后在查询");
                        //隐藏数据表格
                        $("#content").hide();
                    }
                })
            });

            //监听⾏⼯具事件
            table.on('tool(carTable)', function (obj) {
                var data = obj.data; //获得当前⾏数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                if (layEvent === 'rentCar') { //汽⻋出租
                    //汽⻋出租，打开添加汽⻋出租⻚⾯
                    openRentCar(data);
                } else if (layEvent === 'viewImage') { //查看⼤图
                    showCarImage(data);
                }
            });

            //查看⼤图
            function showCarImage(data) {
                mainIndex = layer.open({
                    type: 1,
                    title: "【" + data.carnumber + '】的出租图⽚',
                    content: $("#viewCarImageDiv"),
                    area: ['1100px', '550px'],
                    success: function (index) {
                        $("#view_carimg").attr("src", "${pageContext.request.contextPath}/file/downloadShowFile.action?path=" + data.carimg);
                    }
                });
            }


            //*******************
            var mainIndex;

            //打开添加⻚⾯
            function openRentCar(data) {
                mainIndex = layer.open({
                    type: 1,
                    title: '添加汽⻋出租',
                    content: $("#saveOrUpdateDiv"),
                    area: ['690px', '380px'],
                    success: function (index) {
                        //清空表单数据
                        $("#dataFrm")[0].reset();
                        //请求数据,分别拿到出租价格，身份证号，⻋牌号
                        var price = data.rentprice;
                        var identity = $("#identity").val();
                        var carnumber = data.carnumber;

                        $.get("${pageContext.request.contextPath}/rent/initRentFrom.action", {
                            identity: identity,
                            price: price,
                            carnumber: carnumber
                        }, function (obj) {
                            //赋值
                            form.val("dataFrm", obj);
                        })
                    }
                });

            }

            //保存
            form.on("submit(doSubmit)", function (obj) {
                //序列化表单数据
                var params = $("#dataFrm").serialize();

                $.post("${pageContext.request.contextPath}/rent/saveRent.action",
                    params, function (obj) {
                        layer.msg(obj.msg);
                        //关闭弹出层
                        layer.close(mainIndex);
                        $("#content").hide();
                    })
            });
        }
    )


    //************************************************


    // });
</script>
</body>
</html>

