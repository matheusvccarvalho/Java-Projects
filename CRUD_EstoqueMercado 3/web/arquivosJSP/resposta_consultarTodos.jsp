<%-- 
    Document   : respota_consultarTodos
    Created on : 25 de mai. de 2025, 20:15:25
    Author     : famyo
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Produto" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="estilos/consultarTodos.css">

    <link rel="stylesheet" href="../estilos/resposta_consultarTodos.css">
</head>
    <body>
        <h1>Lista de Produtos</h1>

        <%
            List<Produto> lista = (List<Produto>) request.getAttribute("resposta_consultarTodos");
            if (lista == null || lista.isEmpty()) {
        %>
        <p style="text-align:center;">Nenhum produto encontrado.</p>
        <%
        } else {
        %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Categoria</th>
                    <th>Fornecedor</th>
                    <th>Marca</th>
                    <th>SKU</th>
                    <th>Código de Barra</th>
                    <th>Data de Validade</th>
                    <th>Quantidade</th>
                    <th>Peso</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Produto prod : lista) {
                %>
                <tr>
                    <td><%= prod.getId()%></td>
                    <td><%= prod.getNome()%></td>
                    <td><%= prod.getPreco()%></td>
                    <td><%= prod.getCategoria()%></td>
                    <td><%= prod.getFornecedor()%></td>
                    <td><%= prod.getMarca()%></td>
                    <td><%= prod.getSku()%></td>
                    <td><%= prod.getCodigoDeBarra()%></td>
                    <td><%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(prod.getDataValidade())%></td>
                    <td><%= prod.getQuantidade()%></td>
                    <td><%= prod.getPeso()%> kg</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %>
        <a href="index.html">Voltar ao início</a>

    </body>
</html>
