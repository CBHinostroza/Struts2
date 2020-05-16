package DataService.Despachadores.Impl;

import BusinessServices.BeanUsuario;
import DataService.Despachadores.UsuarioDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioDaoImpl implements UsuarioDao {

    Connection cn = null;
    @Override
    public List<BeanUsuario> ListarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @Override
    public String RegistrarUsuario(BeanUsuario usuario) {
        String resultado = null;
        cn = ConectaDB.conectar();
        CallableStatement cstm = null;
        String sql = "call sp_RegistrarUsuario(?,?,?,?)";
        ResultSet rs = null;
//        String newpassword =  DigestUtils.md5Hex(usuario.getContraseña()); /*Guardando la contraseña de manera encriptada*/
        try {
            cstm = cn.prepareCall(sql);
            cstm.setString(1, usuario.getNombre());
            cstm.setString(2,usuario.getContraseña()); /*Registrando la contraseña de manera encriptada*/
            cstm.setString(3, usuario.getCorreo());
            cstm.setInt(4,usuario.getCod_tipo());
            cstm.executeUpdate();

        } catch (SQLException e) {
           resultado = "Error metodo Registrar Usuario: " + e.getMessage();
        }
        finally{
            try {
                if(cstm!=null){
                    cstm.close();
                }
                if(rs !=null){
                    rs.close();
                }
                if(cn!=null){
                    cn.close();
                }
                
            } catch (SQLException e) {
                resultado = "Error al cerrar las conexiones metodo Registrar Usuario: " + e.getMessage();
            }
        }
        
        return resultado;
    }

    @Override
    public int ValidarAcceso(BeanUsuario usuario) {
        cn = ConectaDB.conectar();
        CallableStatement cstm = null;
        String sql = "{call sp_ValidarUsuario(?)}";
        ResultSet rs = null;
        int CodTipoUsuario = 0;
//        String newpassword = DigestUtils.md5Hex(usuario.getContraseña()); /*Guardando el dato de manera encriptada*/
        try {
            cstm = cn.prepareCall(sql);
            cstm.setString(1, usuario.getNombre());
            rs = cstm.executeQuery();

            if (rs.next()) { //Si es que hay un registro significa que existe el usuario
                if (usuario.getContraseña().equals(rs.getString(2))) {/*Comparando de contraseña a contraseña de manera encriptada*/
                    CodTipoUsuario = rs.getInt(3);
                }
                else{
                     CodTipoUsuario = 10;
                }
            } else {
                CodTipoUsuario = 0;
            }

        } catch (SQLException e) {
             System.out.println("Error en el metodo Validar Acceso: " + e.getMessage());
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (cn != null) {
                    cn.close();
                }

            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones metodo Validar Acceso: " + e.getMessage());
            }
        }
        return CodTipoUsuario;
    }

}
