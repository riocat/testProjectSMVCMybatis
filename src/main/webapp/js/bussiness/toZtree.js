/**
 * Created by Administrator on 2016/12/12.
 */
var ztree;
var setting = {};
var zNodes = [
    {name:"test1", open:true, children:[
        {name:"test1_1"}, {name:"test1_2"}]},
    {name:"test2", open:true, children:[
        {name:"test2_1"}, {name:"test2_2"}]}
];
$(function(){
    zTreeObj = $.fn.zTree.init($("#zTree"), setting, zNodes);
});

