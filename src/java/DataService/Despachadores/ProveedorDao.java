/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores;

import BusinessServices.BeanProveedor;
import java.util.List;

/**
 *
 * @author bryan
 */
public interface ProveedorDao {

    public List<BeanProveedor> listarProvedor();

    public String Registrar(BeanProveedor proveedor);

    public BeanProveedor Buscar(int codigo);

    public String Editar(int codigo);

    public String Eliminar(int codigo);
}
