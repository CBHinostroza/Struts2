package DataService.Despachadores.Impl;

import BusinessServices.BeanUsuario;
import DataService.Despachadores.UsuarioDao;
import DataService.Despachadores.conexion.ConectaDB;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl implements UsuarioDao {

    Connection cn = null;

    @Override
    public List<BeanUsuario> ListarUsuarios() {
        List<BeanUsuario> lista = null;
        CallableStatement cstm = null;
        String sql = "{ call sp_ListarUsuario()}";
        cn = ConectaDB.conectar();
        ResultSet rs = null;
        BeanUsuario usuario = null;
        try {
            cstm = cn.prepareCall(sql);
            rs = cstm.executeQuery();
            lista = new LinkedList<>();
            while (rs.next()) {
                usuario = new BeanUsuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                lista.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Error metodo ListarUsuarios: " + e.getMessage());
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
                System.out.println("Error al desconectar: " + e.getMessage());
            }
        }
        return lista;
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
            cstm.setString(2, usuario.getContraseña());
            /*Registrando la contraseña de manera encriptada*/
            cstm.setString(3, usuario.getCorreo());
            cstm.setInt(4, usuario.getCod_tipo());
            cstm.executeUpdate();

        } catch (SQLException e) {
            resultado = "Error metodo Registrar Usuario: " + e.getMessage();
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
                } else {
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

    @Override
    public String EliminarUsuario(int codigo) {
        String resultado = null;
        String sql = "{call sp_EliminarUsuario(?)}";
        CallableStatement cstm = null;
        cn = ConectaDB.conectar();
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            cstm.executeQuery();
        } catch (SQLException e) {
           resultado = "Error metodo Eliminar Usuario: " + e.getMessage();
        }
        finally{
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                resultado = "Error al desconectar metodo Eliminar Usuario: " + e.getMessage();
            }
        }
        
        return resultado;
        
    }

    @Override
    public BeanUsuario Buscar(int codigo) {

        BeanUsuario usuario = null;
        cn = ConectaDB.conectar();
        CallableStatement cstm = null;
        String sql = " call sp_BuscarUsuario(?)";
        ResultSet rs = null;

        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            rs = cstm.executeQuery();
            if (rs.next()) {
                usuario = new BeanUsuario();
                usuario.setCodigo(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setCod_tipo(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("Error al cerrar las conexiones metodo Buscar Usuario: " + e.getMessage());
            }
        }
        return usuario;
    }

    @Override
    public String EditarUsuario(BeanUsuario usuario) {
        String resultado = null;
        cn = ConectaDB.conectar();
        CallableStatement cstm = null;
        String sql = "{call sp_EditarUsuario(?,?,?,?,?)}";
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, usuario.getCodigo());
            cstm.setString(2, usuario.getNombre());
            cstm.setString(3, usuario.getContraseña());
            cstm.setString(4, usuario.getCorreo());
            cstm.setInt(5, usuario.getCod_tipo());
            cstm.executeUpdate();

        } catch (SQLException e) {
            resultado = "Error metodo EditarUsuario: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }

            } catch (SQLException e) {
                resultado = "Error al cerrar las conexiones metodo EditarUsuario: " + e.getMessage();
            }
        }

        return resultado;

    }

}
