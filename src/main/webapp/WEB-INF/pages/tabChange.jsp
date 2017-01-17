<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/11
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/commons/script.jsp"%>
    <%@ include file="/commons/style.jsp"%>
    <script>
        $(function(){
            $.ajax({
                url : '/test/getProgressData',
                method : 'GET',
                contentType : 'application/json;charset=UTF-8',
                success : function(responseData) {
                    if (responseData.result == 'success') {
                        $('#data1').css({"width":responseData.data}).attr("aria-valuenow",responseData.data);
                    }
                }
            });
        });
    </script>
</head>
<body>
    <div style="min-width: 500px;height: 300px;">
        <div style="display: table;width:  100%;height: 300px;">
            <div style="display: table-cell;width: 100%;height: 100%;text-align: center;margin:0 auto;vertical-align: middle;">
                <button id="query" class="btn btn-primary" type="button" style=""> dsfsd</button>
            </div>
        </div>
    </div>
    <div style="width: 500px;height: 100px;">
        <div style="display: table;width: 100%;height: 100%;">
            <div style="display: table-cell;width: 200px;height: 100%;text-align: center;vertical-align: middle;">
                <div class="progress">
                    <div class="progress-bar" role="progressbar" id="data1" aria-valuemin="0" aria-valuemax="100">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
