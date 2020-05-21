
package DataService.Despachadores;

import BusinessServices.BeanUsuario;
import java.util.List;

public interface UsuarioDao {
    
    public List<BeanUsuario> ListarUsuarios();
    public String RegistrarUsuario(BeanUsuario usuario);
    public int ValidarAcceso(BeanUsuario usuario);
    public String EliminarUsuario(int codigo);
    public BeanUsuario Buscar(int codigo);
    public String EditarUsuario(BeanUsuario usuario);
}
