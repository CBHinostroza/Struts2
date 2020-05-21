package BusinessServices;

import java.io.Serializable;
import java.util.Date;


public class BeanProducto implements Serializable {

    private int codigo;
    private String nombre;
    private String nombrecategoria;
    private String nombreproveedor;
    private int idcategoria;
    private int idproveedor;
    private int stockinicial;
    private Date fechaRegistro;
    private int stockminimo;
    private String codigobarra;
    private Date fechaven;
    private String fechaven2;

    public String getFechaven2() {
        return fechaven2;
    }

    public void setFechaven2(String fechaven2) {
        this.fechaven2 = fechaven2;
    }

    public BeanProducto(int codigo, String nombre, int idcategoria, int idproveedor, int stockinicial, int stockminimo, String codigobarra, String fechaven2, double preciounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
        this.stockinicial = stockinicial;
        this.stockminimo = stockminimo;
        this.codigobarra = codigobarra;
        this.fechaven2 = fechaven2;
        this.preciounitario = preciounitario;
    }
    private double preciounitario;

    public BeanProducto(int codigo, String nombre, String nombrecategoria, String nombreproveedor, int stockinicial, Date fechaRegistro, int stockminimo, String codigobarra, Date fechaven, double preciounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombrecategoria = nombrecategoria;
        this.nombreproveedor = nombreproveedor;
        this.stockinicial = stockinicial;
        this.fechaRegistro = fechaRegistro;
        this.stockminimo = stockminimo;
        this.codigobarra = codigobarra;
        this.fechaven = fechaven;
        this.preciounitario = preciounitario;
    }

    public BeanProducto(int codigo, String nombre, int idcategoria, int idproveedor, int stockinicial, int stockminimo, String codigobarra, Date fechaven, double preciounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
        this.stockinicial = stockinicial;
        this.stockminimo = stockminimo;
        this.codigobarra = codigobarra;
        this.fechaven = fechaven;
        this.preciounitario = preciounitario;
    }

    public BeanProducto() {
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

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
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

    public int getStockinicial() {
        return stockinicial;
    }

    public void setStockinicial(int stockinicial) {
        this.stockinicial = stockinicial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
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

}
