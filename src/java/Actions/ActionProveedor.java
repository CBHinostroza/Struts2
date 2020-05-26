package Actions;

import static Actions.ActionLogin.RecuperarSession;
import BusinessServices.BeanProveedor;
import BusinessServices.BeanTerritorio;
import DataService.Despachadores.Impl.ProveedorDaoImpl;
import DataService.Despachadores.Impl.TerritorioDaoImpl;
import DataService.Despachadores.ProveedorDao;
import DataService.Despachadores.TerritorioDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class ActionProveedor extends ActionSupport {

    private int codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private BeanProveedor proveedor;
    private List<BeanProveedor> lista;
    private List<BeanTerritorio> ListarTerritorio;
    private String accion;
    private String mensaje;
    private int codigo_territorio;


    /*A esta variable lo llamamos desde la vista registrar proveedor y le damos el valor key devuelto desde es ListadoTerritorio*/
    public List<BeanTerritorio> getListarTerritorio() {
        return ListarTerritorio;
    }

    public void setListarTerritorio(List<BeanTerritorio> ListarTerritorio) {
        this.ListarTerritorio = ListarTerritorio;
    }

    public int getCodigo_territorio() {
        return codigo_territorio;
    }

    public void setCodigo_territorio(int codigo_territorio) {
        this.codigo_territorio = codigo_territorio;
    }

    @SkipValidation
    public String ListarProveedor() throws Exception {
        String target = "error";
        boolean estado = RecuperarSession();
        /*
        Recuperando la session, si es true significa que no hay una session y si es falso
        si existe un objeto de tipo name en la session
         */
        if (estado) { //Si es true
            target = "login";
        } else { //Si es falso    
            ProveedorDao proveedorDao = new ProveedorDaoImpl();
            lista = proveedorDao.listarProvedor();
            if (lista != null) {
                target = "lista";
            } else {
                mensaje = "Error en el metodo listar proveedor";
            }
            return target;
        }
        
        return target;
    }

    @Override
    @SkipValidation
    public String execute() throws Exception {
        String target = "error";
        ProveedorDao proveedorDao = new ProveedorDaoImpl();
        switch (accion) {
            case "INS":
                proveedor = new BeanProveedor();
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
                proveedor.setCodigo_territorio(codigo_territorio);
                proveedor.setEmail(email);
                proveedor.setTelefono(telefono);
                mensaje = proveedorDao.Registrar(proveedor);
                if (mensaje == null) {
                    lista = proveedorDao.listarProvedor();
                    if (lista != null) {
                        target = "lista";
                    } else {
                        mensaje = "Error en el metodo listar proveedor";
                    }
                } else {
                    mensaje = "Error en el metodo Registrar proveedor";
                }
                break;
            case "GET":
                proveedor = proveedorDao.Buscar(codigo);
                if (proveedor != null) {
                    TerritorioDao territorioDao = new TerritorioDaoImpl();
                    ListarTerritorio = territorioDao.ListarTerritorio();
                    if (ListarTerritorio != null) {
                        target = "editar";
                    } else {
                        mensaje = "Error en el metodo ListarTerritorio";
                    }
                } else {
                    mensaje = "Error en el metodo Buscar Proveedor";
                }
                break;
            case "UPD":
                proveedor = new BeanProveedor();
                proveedor.setCodigo(codigo);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
                proveedor.setCodigo_territorio(codigo_territorio);
                proveedor.setTelefono(telefono);
                proveedor.setEmail(email);
                mensaje = proveedorDao.Editar(proveedor);
                if (mensaje == null) {
                    lista = proveedorDao.listarProvedor();
                    if (lista != null) {
                        target = "lista";
                    } else {
                        mensaje = "Error en el metodo listar proveedor";
                    }
                } else {
                    mensaje = "Error en el metodo Editar Proveedor";
                }
                break;
            case "DEL":
                mensaje = proveedorDao.Eliminar(codigo);
                if (mensaje == null) {
                    lista = proveedorDao.listarProvedor();
                    if (lista != null) {
                        target = "lista";
                    } else {
                        mensaje = "Error en el metodo listar proveedor";
                    }
                } else {
                    mensaje = "Error en el metodo Eliminar Proveedor";
                }
                break;
            default:
                mensaje = "Error en la condicional switch del action proveedor";
                break;
        }
        return target;
    }

    @SkipValidation
    public String BuscarProveedor() {
        String target = "error";
        boolean estado = RecuperarSession();
        /*
        Recuperando la session, si es true significa que no hay una session y si es falso entonces
        si existe un objeto de tipo name en la session
         */
        if (estado == true) {
            target = "login";
        } else {
            ProveedorDao proveedorDao = new ProveedorDaoImpl();
            switch (accion) {
                case "QRY":
                    lista = proveedorDao.listarProvedor();
                    if (lista != null) {
                        target = "lista";
                    } else {
                        mensaje = "Error en el metodo listar proveedor";
                    }
                    break;
                default:
                    mensaje = "Error en la condicional switch";
                    break;
            }
            return target;
        }

        return target;
    }

    @SkipValidation
    public String mostrarDistritos() {
        String ir = "error";
        TerritorioDao territorioDao = new TerritorioDaoImpl();
        ListarTerritorio = territorioDao.ListarTerritorio();
        if (ListarTerritorio != null) {
            ir = "lista";
        } else {
            mensaje = "Error en el metodo ListarTerritorio";
        }
        return ir;
    }

    public List<BeanProveedor> getLista() {
        return lista;
    }

    public void setLista(List<BeanProveedor> lista) {
        this.lista = lista;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
