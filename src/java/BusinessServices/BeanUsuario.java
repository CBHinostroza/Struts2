
package BusinessServices;

import java.io.Serializable;
import java.sql.Date;

public class BeanUsuario  implements Serializable {

    
    private int codigo;
    private String nombre;
    private String contraseña;
    private String correo;
    private Date utlima_sesion;
    private int cod_tipo;
    private String tipo;

    public BeanUsuario(int codigo, String nombre, String correo, Date utlima_sesion, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.utlima_sesion = utlima_sesion;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BeanUsuario(int codigo, String nombre, String contraseña, String correo, Date utlima_sesion, int cod_tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.utlima_sesion = utlima_sesion;
        this.cod_tipo = cod_tipo;
    }

    public BeanUsuario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getUtlima_sesion() {
        return utlima_sesion;
    }

    public void setUtlima_sesion(Date utlima_sesion) {
        this.utlima_sesion = utlima_sesion;
    }

    public int getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }
  
}

    

    