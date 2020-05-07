/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessServices.BeanTerritorio;
import DataService.Despachadores.TerritorioDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class TerritorioDaoImpl implements TerritorioDao {

    Connection cn = null;

    @Override
    public List<BeanTerritorio> ListarTerritorio() {
        List<BeanTerritorio> lista = null;
        cn = ConectaDB.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select  codigo, distrito from tbl_territorio where departamento like '%lima%' and provincia like '%lima%' order by 'distrito';";

        try {
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            lista = new LinkedList();
            while (rs.next()) {
                BeanTerritorio territorio = new BeanTerritorio();
                territorio.setCodigoterritorio(rs.getInt(1));
                territorio.setDistrito(rs.getString(2));
                lista.add(territorio);
            }

        } catch (SQLException e) {
            System.out.println("Error en el metodo Listar territorio: " + e.getMessage());
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
