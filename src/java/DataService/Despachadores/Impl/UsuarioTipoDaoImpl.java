package DataService.Despachadores.Impl;

import BusinessServices.BeanTipoUsuario;
import DataService.Despachadores.UsuarioTipoDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioTipoDaoImpl implements UsuarioTipoDao {

    Connection cn = null;

    @Override
    public List<BeanTipoUsuario> ListarTipo() {
        List<BeanTipoUsuario> lista = null;
        cn = ConectaDB.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select codigo,tipo from tbl_tipo_usuario;";

        try {
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            lista = new LinkedList();
            while (rs.next()) {
                BeanTipoUsuario tipo = new BeanTipoUsuario();
                tipo.setCodigo(rs.getInt(1));
                tipo.setTipo(rs.getString(2));
                lista.add(tipo);
            }

        } catch (SQLException e) {
            System.out.println("Error en el metodo Listar Tipo: " + e.getMessage());
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

    @Override
    public BeanTipoUsuario BuscarTipo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
