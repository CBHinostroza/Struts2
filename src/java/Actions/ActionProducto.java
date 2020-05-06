/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import BusinessServices.BeanProducto;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bryan
 */
public class ActionProducto extends ActionSupport {

    public String getNombre() {
        return nombre;
    }

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

    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    private ArrayList<BeanProducto> lista;

    public ArrayList<BeanProducto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<BeanProducto> lista) {
        this.lista = lista;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private int cantidad;

    

    public String registro() throws Exception {
        producto = new BeanProducto();
        producto.setNombre(nombre);
        producto.setIdcategoria(idcategoria);
        producto.setIdproveedor(idproveedor);
        producto.setStockinicial(stockinicial);
        producto.setStockminimo(stockminimo);
        producto.setCodigobarra(codigobarra);
        /*Dando el formato fecha al ingresar 09/09/1999 para luego convertirlo al formato sql 1999-09-09 al guardar en la db*/
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date fechasql = null;
        try {
            java.util.Date fechaven1 = f.parse(f.format(fechaven));
            fechasql = new java.sql.Date(fechaven1.getTime());
        } catch (Exception e) {
            System.out.println("Error al formatear la fecha: " + e.getMessage());
        }
        producto.setFechaven(fechasql);
        producto.setPreciounitario(preciounitario);

        lista = new ArrayList();
        String nombre = null, idbarra = null;
        int idcategoria = 0, idproveedor = 0, stock_inicial = 0, stock_minimo = 0;
        double precio_unitario = 0;

        /*MOSTRANDO EL ARREGLO TAMBIEN*/
        for (int x = 0; x < 10; x++) {

            nombre = "Carlos  " + x;
            idcategoria = 1;
            idproveedor = 2;
            stock_inicial = 3;
            stock_minimo = 4;
            idbarra = "12323asdasd" +x;
            precio_unitario = 15.45;

            lista.add(new BeanProducto(nombre, idcategoria, idproveedor, stock_inicial, stock_minimo, idbarra, precio_unitario));
        }

        cantidad = lista.size();
        
        
        return SUCCESS;
    }
    public String listarArreglo() throws Exception {

        lista = new ArrayList();
        String nombre = null, idbarra;
        int idcategoria = 0, idproveedor = 0, stock_inicial = 0, stock_minimo = 0;
        double precio_unitario = 0;

        for (int x = 0; x < 10; x++) {

            nombre = "Carlos  " + x;
            idcategoria = 1;
            idproveedor = 2;
            stock_inicial = 3;
            stock_minimo = 4;
            idbarra = "12323asdasd"+x;
            precio_unitario = 15.45;

            lista.add(new BeanProducto(nombre, idcategoria, idproveedor, stock_inicial, stock_minimo, idbarra, precio_unitario));
        }

        cantidad = lista.size();
        return SUCCESS;
    }

}
