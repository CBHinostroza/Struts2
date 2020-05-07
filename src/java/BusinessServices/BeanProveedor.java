package BusinessServices;

import java.io.Serializable;


public class BeanProveedor implements Serializable{

    private int codigo;
    private String nombre;
    private String direccion;
    private String distrito;
    private int codigo_territorio;
    private String telefono;
    private String email;

    public BeanProveedor(int codigo, String nombre, String direccion, String distrito, String telefono, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
        this.telefono = telefono;
        this.email = email;
    }

    public BeanProveedor(int codigo, String nombre, String direccion, int codigo_territorio, String telefono, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo_territorio = codigo_territorio;
        this.telefono = telefono;
        this.email = email;
    }

    public BeanProveedor() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_territorio() {
        return codigo_territorio;
    }

    public void setCodigo_territorio(int codigo_territorio) {
        this.codigo_territorio = codigo_territorio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
