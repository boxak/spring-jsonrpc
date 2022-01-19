<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring RPC TEST</title>
    <script src="js/jsonrpcjs-0.1.8.min.js"></script>
    <script type="text/javascript">
        var rpc = new jsonrpc.JsonRpc("RPC/jsonRPCService");
        
function ceshi(){
    var name = document.getElementById("name").value;
    rpc.call('getUserById',name, {
        success : callback,
        failure : errorcallback,
    });
    
    
    function callback(r){
        var id=r.id;
        var name = r.name;
        alert(name);
    }
    function errorcallback(r){
        alert(r);
    }
}
        
    </script>
</head>
<body>

<h1>Spring RPC test</h1>
 Please type in your name:<input type="text" id="name" size="17">
<input type="button" value="Hello" id="but1" onclick="ceshi()">
</body>
</html>
