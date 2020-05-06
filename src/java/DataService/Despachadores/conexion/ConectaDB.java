package DataService.Despachadores.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;



public class ConectaDB {

    public static Connection conectar() {
        Connection cn = null;
        try {
            String ruta = "com.mysql.jdbc.Driver";
            Class.forName(ruta);
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://LocalHost:3306/bdproductos", "root", "1234");
//            if(cn!=null){
//                 System.out.print(":)");
//            }
//            else{
//                 System.out.print(":(");
//            }

        } catch (Exception e) {
            System.out.print("Error en el metodo conectar:" + e.getMessage());
//            JOptionPane.showMessageDialog(null, "Error en el metodo conectar:" + e.getMessage());
        }

        return cn;
    }
}
