/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessServices.BeanProveedor;
import DataService.Despachadores.ProveedorDao;
import DataService.Despachadores.conexion.ConectaDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProveedorDaoImpl implements ProveedorDao {

    Connection cn = null;

    @Override
    public List<BeanProveedor> listarProvedor() {
        cn = ConectaDB.conectar();
        List<BeanProveedor> list = null;
        ResultSet rs = null;
        CallableStatement cstm = null;
        String sql = "call sp_ListarProveedor()";
        try {

            cstm = cn.prepareCall(sql);
            list = new LinkedList<>(); //Inicializamos el objeto lista de proveedores, que recibira un objeto proveedor
            rs = cstm.executeQuery();
            while (rs.next()) { //Mientra haya una fila entonces

                BeanProveedor proveedor = new BeanProveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)); //Obteniendo los datos y guardando la objeto proveedor
                list.add(proveedor); //agregando los registro obtenido al objeto lista mientras haya una fila

            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo listar: " + e.getMessage());
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
                System.out.println("Error al cerrar las conexiones metodo Listar: " + e.getMessage());
            }
        }

        return list;
    }

    @Override
    public String Registrar(BeanProveedor proveedor) {
        String resultado = null;
        CallableStatement cstm = null;
        cn = ConectaDB.conectar();
        String sql = "call sp_RegistroProveedor(?,?,?,?,?)";
        try {

            cstm = cn.prepareCall(sql);
            cstm.setString(1, proveedor.getNombre());
            cstm.setString(2, proveedor.getDireccion());
            cstm.setInt(3, proveedor.getCodigo_territorio());
            cstm.setString(4, proveedor.getTelefono());
            cstm.setString(5, proveedor.getEmail());
            cstm.executeQuery();

        } catch (SQLException e) {
            resultado = "Error en el metodo Registrar proveedor: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                resultado = "Error al desconectar: " + e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public BeanProveedor Buscar(int codigo) {
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
