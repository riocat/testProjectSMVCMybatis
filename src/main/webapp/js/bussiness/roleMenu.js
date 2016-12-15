/**
 * Created by Administrator on 2016/12/15.
 */
var ztree;

var setting = {
    data: {
        simpleData: {
            enable: true
        }
    }
};

function loadZtreeData(){
    $.ajax({
        url : '/test/getMenu',
        method : 'GET',
        // dataType : 'json', 指回调函数参数类型 预期的服务器响应的数据类型
        contentType : 'application/json;charset=UTF-8',
        success : function(responseData) {
            if (responseData.result == 'success') {
                $(responseData.data).each(function(index,element){
                    if(element.isParent == true){
                        element.open = true;
                    }
                });
                ztree = $.fn.zTree.init($("#zTree"), setting, responseData.data);
            }
        }
    });
}

$(function(){
    loadZtreeData();
});