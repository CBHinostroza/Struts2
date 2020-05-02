package Actions;

import com.opensymphony.xwork2.ActionSupport;

public class ActionSaludo extends ActionSupport {

    @Override
    public String execute() throws Exception {
        mensaje = "Hola mundo desdes la ActionSaludo, metodo execute";
        return SUCCESS;
    }

    public String mensaje() throws Exception {

        mensaje = "Hola mundo desde la Action Saludo, metodo Mensaje";
        return SUCCESS;
    }

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
