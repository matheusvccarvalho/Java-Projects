<%-- 
    Document   : atualizar
    Created on : 28 de mai. de 2025, 21:58:48
    Author     : famyo
--%>

<%@ page import="model.Produto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Produto prod = (Produto) request.getAttribute("produto");
    String dataFormatada = "";
    if (prod.getDataValidade() != null) {
        dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(prod.getDataValidade());
    }
%>
<html>
<head><title>Atualizar Produto</title><link rel="stylesheet" href="../estilos/resposta_atualizar.css">
</head>
<body>
    <h2>Atualizar Produto</h2>
    <form action="CrudEstoque" method="post">
        <input type="hidden" name="op" value="ATUALIZAR">
        <input type="hidden" name="txtid" value="<%= prod.getId() %>">

        Nome: <input type="text" name="txtnome" value="<%= prod.getNome() %>"><br>
        Categoria: <input type="text" name="txtcategoria" value="<%= prod.getCategoria() %>"><br>
        Preço: <input type="text" name="txtpreco" value="<%= prod.getPreco() %>"><br>
        Data de Validade: <input type="date" name="txtdataValidade" value="<%= dataFormatada %>"><br>
        Peso: <input type="text" name="txtpeso" value="<%= prod.getPeso() %>"><br>
        Fornecedor: <input type="text" name="txtfornecedor" value="<%= prod.getFornecedor() %>"><br>
        Marca: <input type="text" name="txtmarca" value="<%= prod.getMarca() %>"><br>
        Código de Barras: <input type="text" name="txtcodigoDeBarra" value="<%= prod.getCodigoDeBarra() %>"><br>
        SKU: <input type="text" name="txtsku" value="<%= prod.getSku() %>"><br>

        <input type="submit" value="Atualizar">
    </form>
    <br><a href="index.html">Voltar</a>
</body>
</html>
