/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package contrller;

import DAO.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "CrudEstoque", urlPatterns = {"/CrudEstoque"})
public class CrudEstoque extends HttpServlet {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String mensagem = "";

        try {
            String op = request.getParameter("op");

            if (op == null || op.isEmpty()) {
                throw new ServletException("Parâmetro 'op' é obrigatório.");
            }

            switch (op) {
                case "CADASTRAR":
                    mensagem = cadastrarProduto(request);
                    break;

                case "DELETAR":
                    mensagem = deletarProduto(request);
                    break;

                case "ATUALIZAR":
                    mensagem = atualizarProduto(request);
                    break;
                case "CONSULTAR_ID_ATUALIZAR":
                    consultarPorIdParaAtualizar(request, response);
                    return;

                case "CONSULTAR_ID":
                    consultarPorId(request, response);
                    return;

                case "CONSULTAR_CATEGORIA":
                    consultarPorCategoria(request, response);
                    return;

                case "CONSULTAR_TODOS":
                    consultarTodos(request, response);
                    return;

                default:
                    mensagem = "Operação inválida: " + op;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            mensagem = "Erro: " + ex.getMessage();
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta.jsp");
        dispatcher.forward(request, response);
    }

    private String cadastrarProduto(HttpServletRequest request) throws ParseException, ClassNotFoundException, SQLException {
        String nome = request.getParameter("txtnome");
        String categoria = request.getParameter("txtcategoria");
        String precoStr = request.getParameter("txtpreco");
        String dataStr = request.getParameter("txtdataValidade");
        String pesoStr = request.getParameter("txtpeso");
        String fornecedor = request.getParameter("txtfornecedor");
        String marca = request.getParameter("txtmarca");
        String codBarraStr = request.getParameter("txtcodigoDeBarra");
        String sku = request.getParameter("txtsku");

        double preco = precoStr != null && !precoStr.isEmpty() ? Double.parseDouble(precoStr) : 0.0;
        double peso = pesoStr != null && !pesoStr.isEmpty() ? Double.parseDouble(pesoStr) : 0.0;
        double codigoDeBarra = codBarraStr != null && !codBarraStr.isEmpty() ? Double.parseDouble(codBarraStr) : 0.0;

        Date dataValidade = parseDate(dataStr);

        Produto p = new Produto();
        p.setNome(nome);
        p.setCategoria(categoria);
        p.setPreco(preco);
        p.setDataValidade(dataValidade);
        p.setPeso(peso);
        p.setFornecedor(fornecedor);
        p.setMarca(marca);
        p.setCodigoDeBarra(codigoDeBarra);
        p.setSku(sku);

        produtoDAO.inserir(p);

        return "Produto cadastrado com sucesso!";
    }

    private String deletarProduto(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        int id = Integer.parseInt(request.getParameter("txtid"));
        Produto p = new Produto();
        p.setId(id);

        produtoDAO.deletar(p);
        return "Produto deletado com sucesso!";
    }

    private String atualizarProduto(HttpServletRequest request) throws ServletException, IOException, ParseException, ClassNotFoundException, SQLException {
        int id = Integer.parseInt(request.getParameter("txtid"));
        Produto existente = produtoDAO.consultarId(id);

        if (existente == null) {
            throw new ServletException("Produto não encontrado.");
        }

        String nome = request.getParameter("txtnome");
        String categoria = request.getParameter("txtcategoria");
        String precoStr = request.getParameter("txtpreco");
        String dataStr = request.getParameter("txtdataValidade");
        String pesoStr = request.getParameter("txtpeso");
        String fornecedor = request.getParameter("txtfornecedor");
        String marca = request.getParameter("txtmarca");
        String codBarraStr = request.getParameter("txtcodigoDeBarra");
        String sku = request.getParameter("txtsku");

        if (nome != null && !nome.isEmpty()) {
            existente.setNome(nome);
        }
        if (categoria != null && !categoria.isEmpty()) {
            existente.setCategoria(categoria);
        }
        if (precoStr != null && !precoStr.isEmpty()) {
            existente.setPreco(Double.parseDouble(precoStr));
        }
        if (dataStr != null && !dataStr.isEmpty()) {
            existente.setDataValidade(parseDate(dataStr));
        }
        if (pesoStr != null && !pesoStr.isEmpty()) {
            existente.setPeso(Double.parseDouble(pesoStr));
        }
        if (fornecedor != null && !fornecedor.isEmpty()) {
            existente.setFornecedor(fornecedor);
        }
        if (marca != null && !marca.isEmpty()) {
            existente.setMarca(marca);
        }
        if (codBarraStr != null && !codBarraStr.isEmpty()) {
            existente.setCodigoDeBarra(Double.parseDouble(codBarraStr));
        }
        if (sku != null && !sku.isEmpty()) {
            existente.setSku(sku);
        }

        produtoDAO.atualizar(existente);

        // Coloca uma mensagem para exibir na JSP
        request.setAttribute("mensagem", "Produto atualizado com sucesso!");

        // Redireciona para a JSP que mostra o resultado
        return "Produto atualizado com sucesso!";

    }

    private void consultarPorIdParaAtualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        int id = Integer.parseInt(request.getParameter("txtid"));
        Produto produto = produtoDAO.consultarId(id);
        if (produto == null) {
            request.setAttribute("mensagem", "Produto não encontrado para atualização.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("produto", produto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta_atualizar.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void consultarPorId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        int id = Integer.parseInt(request.getParameter("txtid"));
        Produto produto = produtoDAO.consultarId(id);
        request.setAttribute("produto", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta_consultarID.jsp");
        dispatcher.forward(request, response);
    }

    private void consultarPorCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String categoria = request.getParameter("txtcategoria");
        // Supondo que consultarCategoria retorne lista de produtos:
        List<Produto> produto = produtoDAO.consultarCategoria(categoria);
        request.setAttribute("produtosCategoria", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta_consultarCategoria.jsp");
        dispatcher.forward(request, response);
    }

    private void consultarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<Produto> lista = produtoDAO.consultarTodos();
        request.setAttribute("resposta_consultarTodos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("arquivosJSP/resposta_consultarTodos.jsp");
        dispatcher.forward(request, response);
    }

    private Date parseDate(String dataStr) throws ParseException {
        if (dataStr == null || dataStr.isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dataStr);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para CRUD de Produtos no Estoque";
    }

}
