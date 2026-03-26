<%-- 
    Document   : consultarCategoria
    Created on : 29 de mai. de 2025, 21:41:42
    Author     : famyo
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Produto" %>
<html>
<head>
    <title>Resultado da Consulta por Categoria</title>
<link rel="stylesheet" href="../estilos/resposta_consultarCategoria.css">
</head>
<body>
    <h2>Resultado da Consulta por Categoria</h2>

    <%
        List<Produto> lista = (List<Produto>) request.getAttribute("produtosCategoria");
        if (lista == null || lista.isEmpty()) {
    %>
            <p>Nenhum produto encontrado para a categoria informada.</p>
    <%
        } else {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Categoria</th>
                <th>Preço</th>
                <th>Data de Validade</th>
                <th>Peso</th>
                <th>Fornecedor</th>
                <th>Marca</th>
                <th>Código de Barra</th>
                <th>SKU</th>
            </tr>
            <%
                for (Produto p : lista) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNome() %></td>
                    <td><%= p.getCategoria() %></td>
                    <td><%= p.getPreco() %></td>
                    <td><%= p.getDataValidade() %></td>
                    <td><%= p.getPeso() %></td>
                    <td><%= p.getFornecedor() %></td>
                    <td><%= p.getMarca() %></td>
                    <td><%= p.getCodigoDeBarra() %></td>
                    <td><%= p.getSku() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br/><br/>
    <a href="index.html">Voltar ao Início</a>
</body>
</html>
