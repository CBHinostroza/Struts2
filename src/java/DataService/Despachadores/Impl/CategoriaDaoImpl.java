/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessServices.BeanCategoria;
import DataService.Despachadores.CategoriaDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class CategoriaDaoImpl implements CategoriaDao{

    Connection cn = null;
    @Override
    public List<BeanCategoria> listar() {
        List<BeanCategoria> lista = null;
        cn = ConectaDB.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from tbl_categoria;";

        try {
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            lista = new LinkedList();
            while (rs.next()) {
                BeanCategoria territorio = new BeanCategoria();
                territorio.setCodigocategoria(rs.getInt(1));
                territorio.setCategoria(rs.getString(2));
                lista.add(territorio);
            }

        } catch (SQLException e) {
            System.out.println("Error en el metodo Listar Categoria: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (cn != null) {
                    cn.close();
                }

            } catch (SQLException e) {
                System.out.println("Error al desconectar: " + e.getMessage());
            }
        }
        return lista;
    }
    
}
