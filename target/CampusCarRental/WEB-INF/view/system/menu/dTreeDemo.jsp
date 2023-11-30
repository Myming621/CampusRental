<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<body>

<ul id="menuTree" class="dtree" data-id="0"></ul>

</body>
<script type="text/javascript">

    var menuTree;
    layui.extend({
        dtree:
            '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
    }).use(['jquery', 'layer', 'form', 'dtree'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var dtree = layui.dtree;
        /* // 初始化树
         menuTree = dtree.render({
         elem: "#menuTree",
         dataStyle: "layuiStyle", //使⽤layui⻛格的数据格式
         response: {message: "msg", statusCode: 0}, //修改response中返回
        数据的定义
         dataFormat: "list", //配置data的⻛格为list
         url: "data.json" // 使⽤url加载（可与data加载同时存在）
         });*/
        dtree.render({
            elem: "#menuTree",
            data: [{
                "id": 2, "title": "基础管理", "icon": "&#xe653;", "href": "", "spread": true, "target": "",
                "children": [{
                    "id": 6, "title": "客户管理", "icon": "&#xe770;", "href": "../bus/toCustomerManager.action",
                    "spread": false, "target": "", "children": [], "checkArr": "0", "parentId": 2
                },
                    {
                        "id": 7,
                        "title": "⻋辆管理",
                        "icon": "&#xe657;",
                        "href": "../bus/toCarManager.action",
                        "spread": false,
                        "target": "",
                        "children": [],
                        "checkArr": "0",
                        "parentId": 2
                    }], "checkArr": "0", "parentId": 1
            },
                {
                    "id": 3,
                    "title": "业务管理",
                    "icon": "&#xe663;",
                    "href": "",
                    "spread": true,
                    "target": "",
                    "children": [{
                        "id": 8,
                        "title": "汽⻋出租",
                        "icon": "&#xe65b;",
                        "href": "../bus/toRentCarManager.action",
                        "spread": true,
                        "target": "",
                        "children": [],
                        "checkArr": "0",
                        "parentId": 3
                    },
                        {
                            "id": 9,
                            "title": "出租单管理",
                            "icon": "&#xe6b2;",
                            "href": "../bus/toRentManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 3
                        },
                        {
                            "id": 10,
                            "title": "汽⻋⼊库",
                            "icon": "&#xe65a;",
                            "href": "../bus/toCheckCarManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 3
                        }, {
                            "id": 11,
                            "title": "检查单管理",
                            "icon": "&#xe705;",
                            "href": "../bus/toCheckManager.action",
                            "spread": true,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 3
                        }],
                    "checkArr": "0",
                    "parentId": 1
                },
                {
                    "id": 4,
                    "title": "系统管理",
                    "icon": "&#xe716;",
                    "href": "",
                    "spread": false,
                    "target": "",
                    "children": [{
                        "id": 12,
                        "title": "菜单管理",
                        "icon": "&#xe60f;",
                        "href": "../sys/toMenuManager.action",
                        "spread": false,
                        "target": null,
                        "children": [],
                        "checkArr": "0",
                        "parentId": 4
                    },
                        {
                            "id": 13,
                            "title": "⻆⾊管理",
                            "icon": "&#xe66f;",
                            "href": "../sys/toRoleManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 4
                        },
                        {
                            "id": 14,
                            "title": "⽤户管理",
                            "icon": "&#xe770;",
                            "href": "../sys/toUserManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 4
                        },
                        {
                            "id": 15,
                            "title": "⽇志管理",
                            "icon": "&#xe655;",
                            "href": "../sys/toLogInfoManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 4
                        },
                        {
                            "id": 16,
                            "title": "公告管理",
                            "icon": "&#xe645;",
                            "href": "../sys/toNewsManager.action",
                            "spread": false,
                            "target": "",
                            "children": [],
                            "checkArr": "0",
                            "parentId": 4
                        }],
                    "checkArr": "0",
                    "parentId": 1
                },
                {
                    "id": 5,
                    "title": "统计分析",
                    "icon": "&#xe629;",
                    "href": null,
                    "spread": false,
                    "target": null,
                    "children": [{
                        "id": 17,
                        "title": "客户地区统计",
                        "icon": "&#xe63c;",
                        "href": "../stat/toCustomerAreaStat.action",
                        "spread": false,
                        "target": "",
                        "children": [],
                        "checkArr": "0",
                        "parentId": 5
                    }, {
                        "id": 18,
                        "title": "公司年度⽉份销售额",
                        "icon": "&#xe62c;",
                        "href": "../stat/toCompanyYearGradeStat.action",
                        "spread": false,
                        "target": "",
                        "children": [],
                        "checkArr": "0",
                        "parentId": 5
                    }, {
                        "id": 19,
                        "title": "业务员年度销售额",
                        "icon": "&#xe62d;",
                        "href": "../stat/toOpernameYearGradeStat.action",
                        "spread": false,
                        "target": "",
                        "children": [],
                        "checkArr": "0",
                        "parentId": 5
                    }],
                    "checkArr": "0",
                    "parentId": 1
                }],
            /* data:[
            {"id":"001","title": "湖南省","checkArr": "0","parentId": "0"},
            {"id":"002","title": "湖北省","checkArr": "0","parentId": "0"},
            {"id":"003","title": "⼴东省","checkArr": "0","parentId": "0"},
            {"id":"004","title": "浙江省","checkArr": "0","parentId": "0"},
            {"id":"005","title": "福建省","checkArr": "0","parentId": "0"},
            {"id":"001001","title": "⻓沙市","checkArr": "0","parentId":
           "001"},
            {"id":"001002","title": "株洲市","checkArr": "0","parentId":
           "001"},
            {"id":"001003","title": "湘潭市","checkArr": "0","parentId":
           "001"},
            {"id":"001004","title": "衡阳市","checkArr": "0","parentId":
           "001"},
            {"id":"001005","title": "郴州市","checkArr": "0","iconClass":
           "dtree-icon-caidan_xunzhang","parentId": "001"}
            ],*/
            /* data:[
             {"id":"001","title": "湖南省","checkArr": "0","parentId": "0"},
             {"id":"002","title": "湖北省","checkArr": "0","parentId": "0"},
             {"id":"003","title": "⼴东省","checkArr": "0","parentId": "0"},
             {"id":"004","title": "浙江省","checkArr": "0","parentId": "0"},
             {"id":"005","title": "福建省","checkArr": "0","parentId": "0"},
             {"id":"001001","title": "⻓沙市","checkArr": "0","parentId":
            "001"},
             {"id":"001002","title": "株洲市","checkArr": "0","parentId":
            "001"},
             {"id":"001003","title": "湘潭市","checkArr": "0","parentId":
            "001"},
             {"id":"001004","title": "衡阳市","checkArr": "0","parentId":
            "001"},
             {"id":"001005","title": "郴州市","checkArr": "0","iconClass":
            "dtree-icon-caidan_xunzhang","parentId": "001"}],*/
            dataStyle: "layuiStyle", //使⽤layui⻛格的数据格式
            dataFormat: "list", //配置data的⻛格为list
            response: {message: "msg", statusCode: 0} //修改response中返回数据的定义
        });
    });

</script>
</html>
