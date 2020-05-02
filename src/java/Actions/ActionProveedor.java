
package Actions;

import com.opensymphony.xwork2.ActionSupport;


public class ActionProveedor extends ActionSupport{
   
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    @Override
    public String execute(){
        mensaje = "Bienvenido a strutus2 desde la action proveedor";
        return SUCCESS;
    }
    
}
