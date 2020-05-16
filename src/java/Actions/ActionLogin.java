
package Actions;

import BusinessServices.BeanUsuario;
import DataService.Despachadores.Impl.UsuarioDaoImpl;
import DataService.Despachadores.UsuarioDao;
import com.opensymphony.xwork2.ActionSupport;

public class ActionLogin extends ActionSupport{
    
    private String username;
    private String password;

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
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    private BeanUsuario usuario;

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void validate(){
        if(getUsername().equals("") && getPassword().equals("")){
            addFieldError("username", "Ingrese los datos");
        }
        else if(getUsername().equals("")){
             addFieldError("username", "Ingrese el nombre");
        }
        else if(getPassword().equals("")){
            addFieldError("password", "Ingrese la clave");
        }
    }
    
    public String login(){
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuario = new BeanUsuario();
        usuario.setNombre(username);
        usuario.setContraseña(password);
        String target = "error";
        int x = usuarioDao.ValidarAcceso(usuario);
        
        switch (x) {
            case 1:
                target = "success";
                break;
            case 2:
                target = "success";
                break;
            case 10:
                mensaje = "Usuario/Password incorrecto";
                break;
            default:
                mensaje = "Usuario no encontrado";
                break;
        }
        return target;
    }
}
