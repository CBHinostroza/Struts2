/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessServices.BeanProducto;
import DataService.Despachadores.ProductoDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProductoDaoImpl implements ProductoDao {

    Connection cn = null;

    @Override
    public List<BeanProducto> listarProducto() {
        cn = ConectaDB.conectar();
        List<BeanProducto> listar = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        String sql = "call sp_ListarProductos()";
        try {
            cstm = (CallableStatement) cn.prepareCall(sql);
            rs = cstm.executeQuery();
            listar = new LinkedList<>(); //Inicializamos el objeto lista de productos, que recibira un objeto producto
            while (rs.next()) { //Mientra haya una fila entonces
                BeanProducto producto = new BeanProducto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getDate(9), rs.getDouble(10));
                listar.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error metodo Listar producto: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }

        return listar;
    }

    @Override
    public String Registrar(BeanProducto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BeanProducto Buscar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Editar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Eliminar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
