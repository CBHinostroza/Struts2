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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author bryan
 */
public class ActionProducto extends ActionSupport {

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
    private int cantidad;
    private String codigo;
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
    
    /**/
    private int codigo_categoria;

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
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

    @Override
    @SkipValidation
    public String execute() throws Exception {

        String target = "error";
        ProductoDao productoDao = new ProductoDaoImpl();

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
                producto = new BeanProducto();
                producto.setNombre(nombre);
                producto.setIdcategoria(codigo_categoria);
                producto.setIdproveedor(idproveedor);
                producto.setStockinicial(stockinicial);
                producto.setStockminimo(stockminimo);
                producto.setCodigobarra(codigobarra);

                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechasql = null;
                try {
                    java.util.Date fechaven1 = f.parse(f.format(fechaven));
                    fechasql = new java.sql.Date(fechaven1.getTime());
                } catch (Exception e) {
                    mensaje = "Error al formatear la fecha: " + e.getMessage();
                }
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
                    target = "error";
                }
                break;
            default:
                mensaje = "Error en la condicional switch";
                break;
        }

        /*Dando el formato fecha al ingresar 09/09/1999 para luego convertirlo al formato sql 1999-09-09 al guardar en la db*/
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        java.sql.Date fechasql = null;
//        try {
//            java.util.Date fechaven1 = f.parse(f.format(fechaven));
//            fechasql = new java.sql.Date(fechaven1.getTime());
//        } catch (Exception e) {
//            System.out.println("Error al formatear la fecha: " + e.getMessage());
//        }
        return target;
    }

    @SkipValidation
    public String MostrarCodigoProveedor(){
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
    
    @SkipValidation
    public String ListarCategoria(){
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
//    public String listarArreglo() throws Exception {
//
//        lista = new ArrayList();
//        String nombre = null, idbarra;
//        int idcategoria = 0, idproveedor = 0, stock_inicial = 0, stock_minimo = 0;
//        double precio_unitario = 0;
//
//        for (int x = 0; x < 10; x++) {
//
//            nombre = "Carlos  " + x;
//            idcategoria = 1;
//            idproveedor = 2;
//            stock_inicial = 3;
//            stock_minimo = 4;
//            idbarra = "12323asdasd" + x;
//            precio_unitario = 15.45;
//
//            lista.add(new BeanProducto(nombre, idcategoria, idproveedor, stock_inicial, stock_minimo, idbarra, precio_unitario));
//        }
//
//        cantidad = lista.size();
//        return SUCCESS;
//    }
    public String getNombre() {
        return nombre;
    }

    //Trim true es para suprimir espacios en blanco
    @RequiredStringValidator(message = "Ingrese el nombre", trim = true)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

//    //Trim true es para suprimir espacios en blanco
    @IntRangeFieldValidator(min = "1", message = "Ingrese un numero mayor o igual a 1")
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    //Trim true es para suprimir espacios en blanco
    @IntRangeFieldValidator(min = "1", message = "Ingrese un numero mayor o igual a 1")
    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
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

    @DateRangeFieldValidator(message = "Ingrese una fecha valida")
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStockminimo() {
        return stockminimo;
    }

    @IntRangeFieldValidator(min = "25", message = "Ingrese un numero mayor o igual 25")
    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }

    public int getStockinicial() {
        return stockinicial;
    }

    @IntRangeFieldValidator(min = "50", max = "1000", message = "Ingrese un numero entre el rango de ${min} a ${max}")
    public void setStockinicial(int stockinicial) {
        this.stockinicial = stockinicial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
