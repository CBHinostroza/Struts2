/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import BusinessServices.BeanCategoria;
import BusinessServices.BeanProducto;
import DataService.Despachadores.CategoriaDao;
import DataService.Despachadores.Impl.CategoriaDaoImpl;
import DataService.Despachadores.Impl.ProductoDaoImpl;
import DataService.Despachadores.ProductoDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.sql.Date;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author bryan
 */
public class ActionProducto extends ActionSupport {

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

    @RequiredStringValidator(message = "Ingrese el nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
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
    private String nombre;
    private int idcategoria;
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

    /*Variable y metodos de acceso solo para el metodo Listar Categoria del Select List en RegistrarProducto.jsp*/
    private List<BeanCategoria> listarcategoria;

    public List<BeanCategoria> getListarcategoria() {
        return listarcategoria;
    }

    public void setListarcategoria(List<BeanCategoria> listarcategoria) {
        this.listarcategoria = listarcategoria;
    }

    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @SkipValidation
    @Override
    public String execute() throws Exception {

        String target = "error";
        ProductoDao productoDao = new ProductoDaoImpl();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        java.sql.Date fechasql = null;
        switch (accion) {
            case "QRY":
                lista = productoDao.listarProducto();
                if (lista != null) {
                    target = "lista";
                } else {
                    mensaje = "Error en el metodo listar producto";
                }
                break;
            case "INS":
                if (estado == true) { /*SI EL ESTADO ES TRUE VA REGISTRAR UN NUEVO PROVEEDOR*/
                    producto = new BeanProducto();
                    producto.setNombre(nombre);
                    producto.setIdcategoria(codigo_categoria);
                    producto.setIdproveedor(idproveedor);
                    producto.setStockinicial(stockinicial);
                    producto.setStockminimo(stockminimo);
                    producto.setCodigobarra(codigobarra);
                    producto.setFechaven(fechaven);
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
                } else {/*SI EL ESTADO ES FALSE VA MOSTRAR EL FORMULARIO REGISTRO PROVEEDOR, CON LA LISTAS DESPEGABLES*/
                    CategoriaDao categoriaDao = new CategoriaDaoImpl();
                    listarcategoria = categoriaDao.listar();
                    if (listarcategoria != null) {
                        target = "registrar";
                    } else {
                        mensaje = "Error en el metodo ListarTerritorio del action proveedor";
                    }
                }
                break;
            case "GET":
                producto = productoDao.Buscar(codigo);
                if (producto != null) {
                    CategoriaDao categoriaDao = new CategoriaDaoImpl();
                    listarcategoria = categoriaDao.listar();
                    if (listarcategoria != null) {
                        target = "editar";
                    } else {
                        mensaje = "Error en el metodo ListarTerritorio del action proveedor";
                    }
                } else {
                    mensaje = "Error en el metodo Buscar Productoddddd";
                }
                break;
            case "UPD":
                producto = new BeanProducto();
                producto.setCodigo(codigo);
                producto.setNombre(nombre);
                producto.setIdcategoria(codigo_categoria);
                producto.setIdproveedor(idproveedor);
                producto.setStockinicial(stockinicial);
                producto.setStockminimo(stockminimo);
                producto.setCodigobarra(codigobarra);
                producto.setFechaven(fechaven);
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
                break;
            case "DEL":
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
                break;
            default:
                mensaje = "Error en la condicional switch";
                break;
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

//    @SkipValidation
//    public String ListarCategoria() {
//        String ir = "error";
//        CategoriaDao categoriaDao = new CategoriaDaoImpl();
//        listarcategoria = categoriaDao.listar();
//        if (listarcategoria != null) {
//            ir = "lista";
//        } else {
//            mensaje = "Error en el metodo ListarTerritorio del action proveedor";
//        }
//
//        return ir;
//    }

  

}
