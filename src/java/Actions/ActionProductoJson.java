/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import BusinessServices.BeanProducto;
import DataService.Despachadores.Impl.ProductoDaoImpl;
import DataService.Despachadores.ProductoDao;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.json.simple.JSONObject;

/**
 *
 * @author bryan
 */
public class ActionProductoJson extends ActionSupport {

    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String EditarProductoJSONAJAX() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
//        response.setContentType("text/html;charset=UTF-8");
        JSONObject json = new JSONObject();
        BeanProducto producto = new BeanProducto();
        ProductoDao productodao = new ProductoDaoImpl();
        producto = productodao.Buscar(codigo);
//        Map mapear = new HashMap();
//        mapear.put("nombre",producto.getNombre());
        json.put("nombre", producto.getNombre());
//        System.out.print(producto.getNombre());
        out.print(json);
//        out.flush();
        out.close();

        return SUCCESS;
    }
}
