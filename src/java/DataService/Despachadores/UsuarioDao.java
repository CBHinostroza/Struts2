
package DataService.Despachadores;

import BusinessServices.BeanUsuario;
import java.util.List;

public interface UsuarioDao {
    
    public List<BeanUsuario> ListarUsuarios();
    public String RegistrarUsuario(BeanUsuario usuario);
    public int ValidarAcceso(BeanUsuario usuario);
    
}
