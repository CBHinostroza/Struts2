/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import static Actions.ActionLogin.RecuperarSession;
import BusinessServices.BeanCategoria;
import BusinessServices.BeanProducto;
import DataService.Despachadores.CategoriaDao;
import DataService.Despachadores.Impl.CategoriaDaoImpl;
import DataService.Despachadores.Impl.ProductoDaoImpl;
import DataService.Despachadores.ProductoDao;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author bryan
 */
public class ActionProducto extends ActionSupport {

    /*Esta variable minDate lo usare para tomar la fecha actual del sistema
    y llamarlo mediante una expression OGNL desde el actionproducto-validation.xml*/
    private final Date minDate = new java.util.Date();

    public Date getMinDate() {
        Calendar calendar = Calendar.getInstance(); //Instancio la clase calendar que es igual a la clase date de java.util
        calendar.setTime(this.minDate); //Le indico con que fecha vamos a trabajar, en este caso tomo la fecha actual del sistema
        calendar.add(Calendar.YEAR, 3); //Le sumo años a la fecha actual
        return calendar.getTime(); // retorno la fecha sumada en años en formato por default (Mon May 18 22:50:29 COT 2020), struts2 ya se encarga de validar
    }
    

    private String nombre;
    private int idproveedor;
    private int stockminimo;
    private int stockinicial;
    private Date fecharegistro;
    private String codigobarra;
    private Date fechaven;
    private double preciounitario;
    private BeanProducto producto;
    private int codigo;
    private List<BeanProducto> lista;
    private String accion;
    private String mensaje;
    private int codigo_categoria;

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }

    public int getStockinicial() {
        return stockinicial;
    }

    public void setStockinicial(int stockinicial) {
        this.stockinicial = stockinicial;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public Date getFechaven() {
        return fechaven;
    }

    public void setFechaven(Date fechaven) {
        this.fechaven = fechaven;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BeanProducto getProducto() {
        return producto;
    }

    public void setProducto(BeanProducto producto) {
        this.producto = producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<BeanProducto> getLista() {
        return lista;
    }

    public void setLista(List<BeanProducto> lista) {
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

    /*Variable y metodos de acceso solo para el metodo Listar Categoria del Select List en RegistrarProducto.jsp*/
    private List<BeanCategoria> listarcategoria;

    public List<BeanCategoria> getListarcategoria() {
        return listarcategoria;
    }

    public void setListarcategoria(List<BeanCategoria> listarcategoria) {
        this.listarcategoria = listarcategoria;
    }

//   @InputConfig(methodName="ListarCategoria")
    @SkipValidation
    public String ListarProducto() {
        String target = "error";
        boolean estado = RecuperarSession(); /*
        Recuperando la session, si es true significa que no hay una session y si es falso
        si existe un objeto de tipo name en la session
        */
        if (estado == true) {
            target = "login";
        } else {
            ProductoDao productoDao = new ProductoDaoImpl();
            if (accion.equals("QRY")) {
                lista = productoDao.listarProducto();
                if (lista != null) {
                    target = "lista";
                } else {
                    mensaje = "Error en el metodo listar producto";
                }
            }
        }

        return target;

    }

    @SkipValidation
    public String ListarCategoria() {
        String ir = "error";
        CategoriaDao categoriaDao = new CategoriaDaoImpl();
        listarcategoria = categoriaDao.listar();
        if (listarcategoria != null) {
            ir = "lista";
        } else {
            mensaje = "Error en el metodo ListarTerritorio del action proveedor";
        }

        return ir;
    }

    public String RegistrarProducto() {
        String target = "error";
        
        ProductoDao productoDao = new ProductoDaoImpl();
        if (accion.equals("INS")) {
            producto = new BeanProducto();
            producto.setNombre(nombre);
            producto.setIdcategoria(codigo_categoria);
            producto.setIdproveedor(idproveedor);
            producto.setStockinicial(stockinicial);
            producto.setStockminimo(stockminimo);
            producto.setCodigobarra(codigobarra);
            /*Como el dato date que traemos desde la vista es tipo java, no se va almacenar en la base de datos
            porque necesita un tipo de dato Date SQL en su formato 1999-09-09,
            asi que primero obtenemos el tiempo transcurrido en dias 
            y lo guardamos en una variable de tipo Date sql, pero porque guardarlo a tipo Date SQL? si
            ese tipo de dato FECHA VEN es un tipo de dato java.util.Date? es cierto,
            pero lo que hace la magia es existe el casteo, en el metodo Registra Producto, el getFechaVen() esta
            casteado a tipo de dato java.sql.Date, es de esta manera que logra guardarse en la DB*/
            java.sql.Date fechasql = new java.sql.Date(fechaven.getTime());
            producto.setFechaven(fechasql);
            producto.setPreciounitario(preciounitario);
            mensaje = productoDao.Registrar(producto);
            if (mensaje == null) {
                lista = productoDao.listarProducto();
                if (lista != null) {
                    target = "lista";
                } else {
                    mensaje = "Error en el metodo listar producto";
                }
            } else {
                mensaje = "Error en el metodo Registrar Producto";
            }
        }

        return target;
    }

    @SkipValidation
    public String EliminarProducto() {
        String target = "error";
        ProductoDao productoDao = new ProductoDaoImpl();
        if (accion.equals("DEL")) {
            mensaje = productoDao.Eliminar(codigo);
            if (mensaje == null) {
                lista = productoDao.listarProducto();
                if (lista != null) {
                    target = "lista";
                } else {
                    mensaje = "Error en el metodo listar producto";
                }
            } else {
                mensaje = "Error en el metodo Eliminar Producto";
            }
        }
        return target;
    }

    @SkipValidation
    public String EditarProducto() {
        String target = "error";
        ProductoDao productoDao = new ProductoDaoImpl();
        if (accion.equals("UPD")) {
            producto = new BeanProducto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setIdcategoria(codigo_categoria);
            producto.setIdproveedor(idproveedor);
            producto.setStockinicial(stockinicial);
            producto.setStockminimo(stockminimo);
            producto.setCodigobarra(codigobarra);
            /*Como el dato date que traemos desde la vista es tipo java, no se va almacenar en la base de datos
            porque necesita un tipo de dato Date SQL en su formato 1999-09-09,
            asi que primero obtenemos el tiempo transcurrido en dias 
            y lo guardamos en una variable de tipo Date sql, pero porque guardarlo a tipo Date SQL? si
            ese tipo de dato FECHA VEN es un tipo de dato java.util.Date? es cierto,
            pero lo que hace la magia es existe el casteo, en el metodo Editar Producto, el getFechaVen() esta
            casteado a tipo de dato java.sql.Date, es de esta manera que logra guardarse en la DB*/
            java.sql.Date fechasql = new java.sql.Date(fechaven.getTime());
            producto.setFechaven(fechasql);
            producto.setPreciounitario(preciounitario);
            mensaje = productoDao.Editar(producto);
            if (mensaje == null) {
                lista = productoDao.listarProducto();
                if (lista != null) {
                    target = "lista";
                } else {
                    mensaje = "Error en el metodo listar producto";
                }
            } else {
                mensaje = "Error en el metodo Editar Producto";
            }
        }
        return target;
    }

    @SkipValidation
    public String ObtenerProducto() {
        String target = "error";
        ProductoDao productoDao = new ProductoDaoImpl();
        if (accion.equals("GET")) {
            producto = productoDao.Buscar(codigo);
            if (producto != null) {
                target = "editar";
            } else {
                mensaje = "Error en el metodo Buscar Productoddddd";
            }
        }
        return target;
    }

    @SkipValidation
    public String MostrarCodigoProveedor() {
        /*Si no indico todo este codigo, me dara error porque al retornar al formulario producto cuando
        ya haya seleccionado el codigo y dado clik en agregar, esa pagina jsp me pedira una lista tipo listarcategoria*/
        String ir = "error";
        CategoriaDao categoriaDao = new CategoriaDaoImpl();
        listarcategoria = categoriaDao.listar();
        if (listarcategoria != null) {
            ir = "lista";
        } else {
            mensaje = "Error en el metodo ListarTerritorio del action proveedor";
        }
        return ir;
    }
    
   
    
}
