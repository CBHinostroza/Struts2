package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Atajos {

    public java.util.Date SumarYrestarDias(java.util.Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public java.util.Date SumarYrestarMeses(java.util.Date fecha, int meses) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, meses);
        return calendar.getTime();
    }
    
    public java.util.Date SumarYrestarAños(java.util.Date fecha, int meses) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, meses);
        return calendar.getTime();
    }
    
    
    public static void main(String args[]) {
        Atajos productoDao = new Atajos();
        SimpleDateFormat f = new SimpleDateFormat();
        java.util.Date fechaactual = new java.util.Date();
        System.out.println(productoDao.SumarYrestarDias(fechaactual, 20));
        System.out.println(fechaactual.getTime());
        System.out.println(fechaactual);
        System.out.println();
        //Formateado
        System.out.println(f.format(productoDao.SumarYrestarDias(fechaactual, 20)));
        System.out.println(f.format(fechaactual.getTime()));
        System.out.println(f.format(fechaactual));
        System.out.println();
        //MESES
        System.out.println(f.format(productoDao.SumarYrestarMeses(fechaactual, 20)));
        System.out.println();
        //AÑOS
        System.out.println(f.format(productoDao.SumarYrestarAños(fechaactual, 20)));
        System.out.println();
        /*Obteniedo el tiempo transcurrido en dias de la fecha actual
        y guardandolo en una variable de tipo Date sql
        */
        java.sql.Date fechasql = new java.sql.Date(fechaactual.getTime());
        System.out.println(fechasql);
    }
    
    

}
