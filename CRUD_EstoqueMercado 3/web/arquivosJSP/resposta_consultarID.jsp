<%-- 
    Document   : consultarID
    Created on : 29 de mai. de 2025, 21:40:58
    Author     : famyo
--%>

<%@ page import="model.Produto" %>
<%
    Produto prod = (Produto) request.getAttribute("produto");
%>
<html>
    <head><title>Produto por ID</title><link rel="stylesheet" href="../estilos/resposta_consultarID.css">
</head>
    <body>
        <% if (prod != null) {%>
        <h2>Produto encontrado:</h2>
        <ul>
            <li>ID: <%= prod.getId()%></li>
            <li>Nome: <%= prod.getNome()%></li>
            <li>Categoria: <%= prod.getCategoria()%></li>
            <li>Preço: <%= prod.getPreco()%></li>
            <li>Data de Validade: <%= prod.getDataValidade()%></li>
            <li>Peso: <%= prod.getPeso()%></li>
            <li>Fornecedor: <%= prod.getFornecedor()%></li>
            <li>Marca: <%= prod.getMarca()%></li>
            <li>Código de Barras: <%= prod.getCodigoDeBarra()%></li>
            <li>SKU: <%= prod.getSku()%></li>
        </ul>
        <% } else { %>
        <p>Produto não encontrado.</p>
        <% }%>
        <a href="index.html">Voltar</a>
    </body>
</html>
