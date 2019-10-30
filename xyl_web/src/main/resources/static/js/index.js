//填充表格数据
function setTableData(_table, fieldName, list){
  if(list == undefined){
    return;
  }
  var _tr = $("<tr></tr>");
  _table.append(_tr);
  //字段名
  _tr.append("<td>"+fieldName+"</td>");
  //具体释义
  var _cont = $("<td></td>");
  _tr.append(_cont);
  //循环内容 
  for (var i = 0; i < list.length; i++) {
      var _span = $("<span></span>");
      _span.text(list[i]);
      _cont.append(_span);
  }
}
//填充div块数据
function setDivData(_div,list){
  _div.empty();
  for (var i = 0; i < list.length; i++) {
    var _span = $("<span></span>");
    _span.text(list[i]);
    _div.append(_span);
  }
};

function isExist(str){
   if(str != undefined){
     return str;
   }else{
     return '';
   }
}
$(function () {
  $.ajax({
    type: "get",
    url: 'demo.json',
    // url: "http://10.1.2.158:8098/api/pad/dfhy/export/pdf/email?id=15415&email=1002374996@qq.com",
    dataType: "JSON",
    async: false,
    success: function (data) {
      //基本信息
      var result = data;
      $(".createTime").text(result.createDate);
      $(".name").text(isExist(result.name));
      $(".sex").text(isExist(result.sex));
      $(".phone").text(isExist(result.phone));
      $(".vip").text(isExist(result.vip));
      $(".job").text(isExist(result.job));
      $(".birthday").text(isExist(result.birthday));
      $(".marriage").text(isExist(result.marriage));
      $(".allergy").text(isExist(result.allergy));
      $(".disease").text(isExist(result.disease));
      $(".takemedicine").text(isExist(result.takemedicine));
      $(".healthquestion").text(isExist(result.healthquestion));
      
      //五官
      if(result.eye == undefined && result.ear == undefined && result.nose == undefined && result.mouth == undefined && result.tongue == undefined){
        $(".sense-organs").remove();
      }
      var senseTable = $(".sense-organs table tbody");
      senseTable.empty();
      setTableData(senseTable, "眼", result.eye);
      setTableData(senseTable, "耳", result.ear);
      setTableData(senseTable, "鼻", result.nose);
      setTableData(senseTable, "口", result.mouth);
      setTableData(senseTable, "舌", result.tongue);


      //五脏
      if (result.liver == undefined && result.heart == undefined && result.spleen == undefined && result.lung == undefined && result.kidney == undefined) {
        $(".internal-organs").remove();
      }
      var internalTable = $(".internal-organs table tbody");
      internalTable.empty();
      setTableData(internalTable, "肝", result.liver);
      setTableData(internalTable, "心", result.heart);
      setTableData(internalTable, "脾", result.spleen);
      setTableData(internalTable, "肺", result.lung);
      setTableData(internalTable, "肾", result.kidney);
      //两便
      console.log(result.bodywaste);
      if(result.bodywaste != undefined){
        var bodywaste = $(".bodywaste .cont");
        setDivData(bodywaste, result.bodywaste);
      }else{
        $(".bodywaste").remove();
      }
      
      //生理状况
      if (result.physiology != undefined) {
        var physiology = $(".physiology .cont");
        setDivData(physiology, result.physiology);
      } else {
        $(".physiology").remove();
      }
      //情志状况
      if (result.emotion != undefined) {
        var emotion = $(".emotion .cont");
        setDivData(emotion, result.emotion);
      } else {
        $(".emotion").remove();
      } 
      
      //其它躯体反应
      if (result.other != undefined) {
        var other = $(".other .cont");
        setDivData(other, result.other);
      } else {
        $(".other").remove();
      }
    }

  })
})
