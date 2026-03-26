'<%-- 
    Document   : newjsp
    Created on : 22 de mai. de 2025, 21:27:28
    Author     : famyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado</title>
<link rel="stylesheet" href="../estilos/resposta.css">
<link rel="stylesheet" href="../estilos/resposta.css">
</head>
<body>
    <h2>Resultado da Operação</h2>
    <div><%= request.getAttribute("mensagem") %></div>
    <br>
    <a href="index.html">Voltar ao início</a>
</body>
</html>
