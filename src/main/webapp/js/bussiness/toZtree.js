/**
 * Created by Administrator on 2016/12/12.
 */
var ztree;
var setting = {
    view: {
        selectedMulti: false
    },
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false
    },
    data: {
        keep: {
            parent:true,
            leaf:true
        },
        simpleData: {
            enable: true
        }
    },
    callback: {
        beforeRemove: beforeRemove,
        beforeRename: beforeRename,
    }
};

function beforeRemove(treeId, treeNode) {
    className = (className === "dark" ? "":"dark");
    showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
    return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}

function beforeRename(treeId, treeNode, newName) {
    if (newName.length == 0) {
        alert("节点名称不能为空.");
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        setTimeout(function(){zTree.editName(treeNode)}, 10);
        return false;
    }
    return true;
}
var newCount = 1;
function add(e) {
    var zTree = $.fn.zTree.getZTreeObj("zTree"),
        isParent = e.data.isParent,
        nodes = zTree.getSelectedNodes(),
        treeNode = nodes[0];
    var permissionName = prompt("请输入名称","自定义名称");
    var permissionUrl = prompt("请输入路径","自定义路径");
    $("#editDiv").hide();
    var permissionData;
    if (treeNode) {
        permissionData = {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:permissionName, url:permissionUrl};
        treeNode = zTree.addNodes(treeNode, permissionData);
    } else {
        permissionData = {id:(100 + newCount), pId:0, isParent:isParent, name:permissionName, url:permissionUrl};
        treeNode = zTree.addNodes(null, permissionData);
    }
    if (!treeNode) {
        alert("叶子节点被锁定，无法增加子节点");
    } else {
        permissionData.id=null;
        $.ajax({
            url : '/test/addTreeNode',
            method : 'POST',
            // dataType : 'json', 指回调函数参数类型 预期的服务器响应的数据类型
            data : JSON.stringify(permissionData),
            contentType : 'application/json;charset=UTF-8',
            success : function(responseData) {
                if (responseData.result != 'success') {
                    alert("添加失败");
                }
                loadZtreeData();
            }
        });
    }
};
function edit() {
    var zTree = $.fn.zTree.getZTreeObj("zTree"),
        nodes = zTree.getSelectedNodes(),
        treeNode = nodes[0];
    if (nodes.length == 0) {
        alert("请先选择一个节点");
        return;
    }
    zTree.editName(treeNode);
};
function remove(e) {
    var zTree = $.fn.zTree.getZTreeObj("zTree"),
        nodes = zTree.getSelectedNodes(),
        treeNode = nodes[0];
    if (nodes.length == 0) {
        alert("请先选择一个节点");
        return;
    }
    var callbackFlag = $("#callbackTrigger").attr("checked");
    zTree.removeNode(treeNode, callbackFlag);
};

function loadZtreeData(){
    $.ajax({
        url : '/test/getZtreeData',
        method : 'GET',
        // dataType : 'json', 指回调函数参数类型 预期的服务器响应的数据类型
        contentType : 'application/json;charset=UTF-8',
        success : function(responseData) {
            if (responseData.result == 'success') {
                zTreeObj = $.fn.zTree.init($("#zTree"), setting, responseData.data);
            }
        }
    });
}

$(function(){
    $("#editDiv").hide();
    loadZtreeData();
    $("#addParent").bind("click", {isParent:true}, add);
    $("#addLeaf").bind("click", {isParent:false}, add);
    $("#edit").bind("click", edit);
    $("#remove").bind("click", remove);
});

