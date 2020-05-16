
package DataService.Despachadores;

import BusinessServices.BeanTipoUsuario;
import java.util.List;


public interface UsuarioTipoDao {
  
    public List<BeanTipoUsuario> ListarTipo();
    public BeanTipoUsuario BuscarTipo(int codigo);
}
