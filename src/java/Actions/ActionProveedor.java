package Actions;

import BusinessServices.BeanProveedor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class ActionProveedor extends ActionSupport {

    private int codigo;
    private String nombre;
    private String direccion;
    private int codigo_territorio;
    private String telefono;
    private String email;
    private BeanProveedor proveedor;

    @Override
    public String execute() throws Exception {
        proveedor = new BeanProveedor();
        proveedor.setNombre(nombre);
        proveedor.setDireccion(direccion);
        proveedor.setCodigo_territorio(codigo_territorio);
        proveedor.setEmail(email);
        proveedor.setTelefono(telefono);
        return SUCCESS;
    }
    

    public String listar() throws Exception {
        return SUCCESS;
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

    @RequiredStringValidator(message = "Ingrese el nombre.")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @RequiredStringValidator(message = "Ingrese la direccion.")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BeanProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(BeanProveedor proveedor) {
        this.proveedor = proveedor;
    }

}
