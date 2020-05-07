/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores;

import BusinessServices.BeanTerritorio;
import java.util.List;

/**
 *
 * @author bryan
 */
public interface TerritorioDao {
    
    public List<BeanTerritorio> ListarTerritorio();
}
