package Actions;

import BusinessServices.BeanTipoUsuario;
import BusinessServices.BeanUsuario;
import DataService.Despachadores.Impl.UsuarioDaoImpl;
import DataService.Despachadores.Impl.UsuarioTipoDaoImpl;
import DataService.Despachadores.UsuarioDao;
import DataService.Despachadores.UsuarioTipoDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class ActionUsuario extends ActionSupport {

    private int codigo;
    private int codtipo;
    private String correo;
    private List<BeanTipoUsuario> listatipo;
    private BeanUsuario usuario;
    private String accion;
    private List<BeanUsuario> listausuario;
    private String username;
    private String password;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsername() {
        return username;
    }

//    @RequiredStringValidator(message = "Ingrese el nombre")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

//    @RequiredStringValidator(message = "Ingrese el password")
    public void setPassword(String password) {
        this.password = password;
    }

    public List<BeanUsuario> getListausuario() {
        return listausuario;
    }

    public void setListausuario(List<BeanUsuario> listausuario) {
        this.listausuario = listausuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<BeanTipoUsuario> getListatipo() {
        return listatipo;
    }

    public void setListatipo(List<BeanTipoUsuario> listatipo) {
        this.listatipo = listatipo;
    }

    public int getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(int codtipo) {
        this.codtipo = codtipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }

    private String confirm_password;

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
//

    @Override
    public void validate() {

        if (getUsername().equals("")) {
            addFieldError("username", getText("Ingrese el nombre"));
        } else if (getPassword().equals("")) {
            addFieldError("password", "Ingrese la clave");
        } else if (getCorreo().equals("")) {
            addFieldError("correo", "Ingrese el correo");
        } else if (getCodtipo() == 0) {
            addFieldError("listatipo", "Seleccione el tipo");
        }
        if (!getConfirm_password().equals(getPassword())) {
            addFieldError("confirm_password", "Contraseñas no coinciden");
        }

    }

    @SkipValidation//PASAR VALIDACION
    public String ListarTipoUsuario() throws Exception {
        String ir = "error";
        UsuarioTipoDao usuariotipo = new UsuarioTipoDaoImpl();
        listatipo = usuariotipo.ListarTipo();
        if (listatipo != null) {
            ir = "success";
        } else {
            mensaje = "error en el metodo listar tipo usuario";
        }
        return ir;

    }

//    @InputConfig(methodName="ListarUsuario")
    public String RegistrarUsuario() throws Exception {
        usuario = new BeanUsuario();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String target = "error";
        if (accion.equals("INS")) {
            usuario.setNombre(username);
            usuario.setContraseña(password);
            usuario.setCorreo(correo);
            usuario.setCod_tipo(codtipo);
            mensaje = usuarioDao.RegistrarUsuario(usuario);
            if (mensaje == null) {
                listausuario = usuarioDao.ListarUsuarios();
                if (listausuario != null) {
                    target = "registrar";
                } else {
                    mensaje = "Error en metodo listar usuario";
                }
            } else {
//                 target = "input";
                mensaje = "Error en metodo Registrar Usuario";
            }
        }

        return target;
    }

    @SkipValidation
    public String BuscarUsuario() {
        String target = "error";
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        if (accion.equals("GET")) {
            usuario = usuarioDao.Buscar(codigo);
            if (usuario != null) {
                target = "success";
            } else {
                mensaje = "Error en el metodo Buscar Usuario";
            }
        }
        return target;
    }

    @SkipValidation
    public String EditarUsuario() throws Exception {
        usuario = new BeanUsuario();
        String target = "error";
        UsuarioDao usuariodao = new UsuarioDaoImpl();
        if (accion.equals("UPD")) {
            usuario.setCodigo(codigo);
            usuario.setNombre(username);
            usuario.setContraseña(password);
            usuario.setCorreo(correo);
            usuario.setCod_tipo(codtipo);
            mensaje = usuariodao.EditarUsuario(usuario);
            if (mensaje == null) {
                listausuario = usuariodao.ListarUsuarios();
                if (listausuario != null) {
                    target = "success";
                } else {
                    mensaje = "Error en metodo listar usuario";
                }
            }
        }
        return target;
    }

    @SkipValidation
    public String ListarUsuario() throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String target = "error";
        if (accion.equals("QRY")) {
            listausuario = usuarioDao.ListarUsuarios();
            if (listausuario != null) {
                target = "lista";
            } else {
                mensaje = "Error en metodo listar usuario";
            }
        }
        return target;
    }

    @SkipValidation
    public String EliminarUsuario() throws Exception {
        String target = "error";
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        if (accion.equals("DEL")) {
            mensaje = usuarioDao.EliminarUsuario(codigo);
            if (mensaje == null) {
                listausuario = usuarioDao.ListarUsuarios();
                if (listausuario != null) {
                    target = "success";
                } else {
                    mensaje = "Error en metodo listar usuario";
                }
            }
        }
        return target;
    }
}
