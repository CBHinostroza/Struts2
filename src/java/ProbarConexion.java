
import DataService.Despachadores.conexion.ConectaDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bryan
 */
public class ProbarConexion {
    
    public static void main(String[] args){
        ConectaDB.conectar();
    }
}
