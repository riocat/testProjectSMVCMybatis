<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/12
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <%@ include file="/commons/script.jsp"%>
    <%@ include file="/commons/style.jsp"%>
    <script type="text/javascript" src="/js/bussiness/toZtree.js"></script>
</head>
<body>
    <div>
        <div id="zTree" class="ztree" style="width: 300px;height: 300px;overflow: scroll;border-color: #333333;border-style: solid;border-width: thin;"></div>
    </div>
    <div>
        [ <a id="addParent" href="#" title="增加父节点" onclick="return false;">增加父节点</a> ]
        [ <a id="addLeaf" href="#" title="增加叶子节点" onclick="return false;">增加叶子节点</a> ]
        [ <a id="edit" href="#" title="编辑名称" onclick="return false;">编辑名称</a> ]<br/>
        [ <a id="remove" href="#" title="删除节点" onclick="return false;">删除节点</a> ]
    </div>

    <div id="dialog-form" title="权限信息详情" id="editDiv">
        <p class="validateTips">所有的表单字段都是必填的。</p>
        <form>
            <fieldset>
                <label for="permissionName">权限名称</label>
                <input type="text" name="permissionName" id="permissionName" class="text ui-widget-content ui-corner-all">
                <label for="permissionUrl">默认路径</label>
                <input type="text" name="permissionUrl" id="permissionUrl" value="" class="text ui-widget-content ui-corner-all">
            </fieldset>
        </form>
    </div>

</body>
</html>
