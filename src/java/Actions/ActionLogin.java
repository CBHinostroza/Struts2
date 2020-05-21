package Actions;

import BusinessServices.BeanUsuario;
import DataService.Despachadores.Impl.UsuarioDaoImpl;
import DataService.Despachadores.UsuarioDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;



public class ActionLogin extends ActionSupport  {


//
//    
 
    
    private BeanUsuario usuario;
    private String accion;
    private String username;
    private String password;
    private String mensaje;

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void validate(){
        if(getUsername().equals("") && getPassword().equals("")){
            addActionError("Ingrese los datos");
        }
        else if(getUsername().equals("")){
            addActionError("Ingrese el usuario");
        }
        else if(getPassword().equals("")){
            addActionError("Ingrese el password");
        }
    }
    
    public String login() {
//        clearActionErrors();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String target = "error";
        usuario = new BeanUsuario();
        usuario.setNombre(username);
        usuario.setContraseña(password);
        int x = usuarioDao.ValidarAcceso(usuario);
        switch (x) {
            case 1:
                target = "success";
                break;
            case 2:
                target = "success";
                break;
            case 10:
                addActionError("Usuario/Password incorrectos");
                target = "input";
                break;
            default:
                mensaje = "Usuario no encontrado";
                break;
        }

        return target;
    }

  

  
}
