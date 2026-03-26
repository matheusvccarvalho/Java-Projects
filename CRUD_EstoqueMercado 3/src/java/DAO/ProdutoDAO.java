/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model.Produto;
import util.EstoqueConexao;

/**
 *
 * @author famyo
 */
public class ProdutoDAO {

    public void inserir(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = EstoqueConexao.getConexao();
        String SQL = "insert into produto (nome, categoria, preco, dataValidade, peso, fornecedor, marca, codigoDeBarra, sku) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, prod.getNome());
        comando.setString(2, prod.getCategoria());
        comando.setDouble(3, prod.getPreco());
        comando.setDate(4, new java.sql.Date(prod.getDataValidade().getTime()));
        comando.setDouble(5, prod.getPeso());
        comando.setString(6, prod.getFornecedor());
        comando.setString(7, prod.getMarca());
        comando.setDouble(8, prod.getCodigoDeBarra());
        comando.setString(9, prod.getSku());
        comando.execute();
        con.close();
    }

    public void deletar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = EstoqueConexao.getConexao();
        String SQL = "delete from produto where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, prod.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = EstoqueConexao.getConexao();
        String SQL = "UPDATE produto SET nome = ?, categoria = ?, preco = ?, dataValidade = ?, peso = ?, fornecedor = ?, marca = ?, codigoDeBarra = ?, sku = ? WHERE id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, prod.getNome());
        comando.setString(2, prod.getCategoria());
        comando.setDouble(3, prod.getPreco());
        comando.setDate(4, new java.sql.Date(prod.getDataValidade().getTime()));
        comando.setDouble(5, prod.getPeso());
        comando.setString(6, prod.getFornecedor());
        comando.setString(7, prod.getMarca());
        comando.setDouble(8, prod.getCodigoDeBarra());
        comando.setString(9, prod.getSku());
        comando.setInt(10, prod.getId());
        comando.execute();
        con.close();
    }

    public Produto consultarId(Integer id) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM produto WHERE id = ?";

        try (Connection con = EstoqueConexao.getConexao(); PreparedStatement comando = con.prepareStatement(SQL)) {

            comando.setInt(1, id);
            try (ResultSet rs = comando.executeQuery()) {
                if (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setPreco(rs.getDouble("preco"));
                    p.setDataValidade(rs.getDate("dataValidade"));
                    p.setPeso(rs.getDouble("peso"));
                    p.setFornecedor(rs.getString("fornecedor"));
                    p.setMarca(rs.getString("marca"));
                    p.setCodigoDeBarra(rs.getDouble("codigoDeBarra"));
                    p.setSku(rs.getString("sku"));
                    return p;
                }
            }
        }
        return null;
    }

    public List<Produto> consultarCategoria(String categoria) throws SQLException, ClassNotFoundException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE categoria = ?";

        try (Connection conn = EstoqueConexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getObject("id", Integer.class)); // Wrapper
                    p.setNome(rs.getString("nome"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setPreco(rs.getObject("preco", Double.class)); // Wrapper
                    p.setDataValidade(rs.getDate("dataValidade"));
                    p.setPeso(rs.getObject("peso", Double.class)); // Wrapper
                    p.setFornecedor(rs.getString("fornecedor"));
                    p.setMarca(rs.getString("marca"));
                    p.setCodigoDeBarra(rs.getDouble("codigoDeBarra")); // Como String
                    p.setSku(rs.getString("sku"));

                    lista.add(p);
                }
            }
        }

        return lista;
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = EstoqueConexao.getConexao();
        String SQL = "select * from produto";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();
        List<Produto> lprod = new ArrayList<Produto>();
        int cont = 0;
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setDataValidade(rs.getDate("dataValidade"));
            prod.setPeso(rs.getDouble("peso"));
            prod.setFornecedor(rs.getString("fornecedor"));
            prod.setMarca(rs.getString("marca"));
            prod.setCodigoDeBarra(rs.getDouble("codigoDeBarra"));
            prod.setSku(rs.getString("sku"));
            lprod.add(prod);
        }
        con.close();
        return lprod;
    }

}
