/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores;

import BusinessServices.BeanProducto;
import java.util.List;

/**
 *
 * @author bryan
 */
public interface ProductoDao {
    
    public List<BeanProducto> listarProducto();
    public String Registrar(BeanProducto producto);
    public BeanProducto Buscar(int codigo);
    public String Editar(int codigo);
    public String Eliminar(int codigo);
}
