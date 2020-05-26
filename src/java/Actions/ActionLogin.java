package Actions;

import BusinessServices.BeanUsuario;
import DataService.Despachadores.Impl.UsuarioDaoImpl;
import DataService.Despachadores.UsuarioDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.validation.SkipValidation;



public class ActionLogin extends ActionSupport implements SessionAware, ApplicationAware  {

    private BeanUsuario usuario;
    private String accion;
    private String username;
    private String password;
    private String mensaje;
    private Map<String,Object> session;
    private Map<String,Object> application;

    public Map<String, Object> getApplication() {
        return application;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

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
     public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String target;
        usuario = new BeanUsuario();
        usuario.setNombre(username);
        usuario.setContraseña(password);
        int x = usuarioDao.ValidarAcceso(usuario);
        switch (x) {
            case 1:
                session.put("name",username);
                application.put("tipo","ADMIN");
                target = "success";
                break;
            case 2:
                session.put("name",username);
                application.put("tipo","USER");
                target = "success";
                break;
            case 10:
                addActionError("Usuario/Password incorrectos");
                target = "input";
                break;
            default:
                addActionError("Usuario no registrado");
                target = "input";
//                mensaje = "Usuario no encontrado";
                break;
        }
        return target;
    }
    
    @SkipValidation
    public String logout() throws Exception{
        String ir;
        if(session.containsKey("name")){ //SI ES QUE EXISTE UN OBJETO DE TIPO NAME EN LA SESSION
            session.remove("name");
            ir = "success";
        }
        else{
            ir = "login";
        }
        return ir;    
    }
    
    @SkipValidation
    public String menu() throws Exception{
        String ir;
        if(session.containsKey("name")){ //SI ES QUE EXISTE UN OBJETO DE TIPO NAME EN LA SESSION
            ir = "success";
        }
        else{
            ir = "login";
        }
        return ir;   
    }
    
  
    public static boolean RecuperarSession(){
        boolean estado = false;
        HttpSession ses = ServletActionContext.getRequest().getSession();
        if(ses.getAttribute("name")==null){ //Si es que no existe un atributo de tipo name en la session, el estado sera true, caso contrario sera false
            estado  = true;
        }
        return estado;
    }
   


   


  
}
