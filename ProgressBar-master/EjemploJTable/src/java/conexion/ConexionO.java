/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor1
 */
public class ConexionO {
    String forName = "oracle.jdbc.OracleDriver";
    public Connection cx;
    public Connection conectar() {
        try {            
            Class.forName(forName);
            cx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");          
          
            
            System.out.println("SE CONECTO");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO"+ex);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();            
        }
    }
    public static void main(String[] args) {
         Conexion c = new Conexion();
         c.conectar();
        if (c!=null) {
            System.out.println("");
        }else{
            System.out.println("");
        }
    }
}
