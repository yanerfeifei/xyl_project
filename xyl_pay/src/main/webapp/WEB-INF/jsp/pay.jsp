<%--
  Created by IntelliJ IDEA.
  User: meridian
  Date: 2019/10/10
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试支付</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
    <script type="text/javascript" src="../../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/js/qrcode.js"></script>
    <script type="text/javascript" src="../../static/js/qrcode.min.js"></script>
</head>
<body>

<input id="text" type="text" value="${code}" style="width:80%" /><br />
<div id="qrcode" style="width:100px; height:100px; margin-top:15px;"></div>

</body>
<script type="text/javascript">
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 100,
        height : 100
    });

    function makeCode () {
        var elText = document.getElementById("text");
        if (!elText.value) {
            alert("Input a text");
            elText.focus();
            return;
        }
        qrcode.makeCode(elText.value);
    }
    makeCode();

    $("#text").
    on("blur", function () {
        makeCode();
    }).
    on("keydown", function (e) {
        if (e.keyCode == 13) {
            makeCode();
        }
    });
</script>
</html>
