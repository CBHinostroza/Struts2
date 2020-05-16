
package BusinessServices;

import java.io.Serializable;


public class BeanTipoUsuario implements Serializable{

    public BeanTipoUsuario(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public BeanTipoUsuario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    private int codigo;
    private String tipo;
}
