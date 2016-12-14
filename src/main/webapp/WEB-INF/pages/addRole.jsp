<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/14
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/commons/script.jsp"%>
    <%@ include file="/commons/style.jsp"%>
    <script type="text/javascript" src="/js/bussiness/addRole.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bussiness/addRole.css">
</head>
<body>
<div>
    <div id="zTree" class="ztree" style="width: 300px;height: 300px;overflow: scroll;border-color: #333333;border-style: solid;border-width: thin;"></div>
    <div class="centerForm">
        <form>
            <fieldset>
                <div>角色名： <input type="text" name="roleName" placeholder="角色名" id="roleName"></div>
                <div><button class="commitButton">添加</button></div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
