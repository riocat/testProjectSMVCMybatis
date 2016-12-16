/**
 * Created by Administrator on 2016/12/14.
 */
var ztree;

var setting = {
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

function loadZtreeData(){
    $.ajax({
        url : '/test/getZtreeData',
        method : 'GET',
        // dataType : 'json', 指回调函数参数类型 预期的服务器响应的数据类型
        contentType : 'application/json;charset=UTF-8',
        success : function(responseData) {
            if (responseData.result == 'success') {
                $(responseData.data).each(function(index,element){
                    if(element.isParent == true){
                        element.nocheck = true;
                        element.open = true;
                    }
                });
                ztree = $.fn.zTree.init($("#zTree"), setting, responseData.data);
            }
        }
    });
}

function addRole(){
    var pids = [];
    var nodes = ztree.getCheckedNodes(true);
    for(i =0;i<nodes.length;i++){
        pids.push(nodes[i].id);
    }
    $.ajax({
        url : '/test/addRolePerimssion',
        method : 'POST',
        //dataType : 'json', //指回调函数参数类型 预期的服务器响应的数据类型
        // http://www.iteye.com/problems/110986
        data:JSON.stringify({name:$('#roleName').val(),pids:pids}),
        contentType : 'application/json;charset=UTF-8',
        success : function(responseData) {
            location.href="/";
        }
    });
}

$(function(){
    loadZtreeData();
});
