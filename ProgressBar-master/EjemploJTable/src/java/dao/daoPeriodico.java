/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexion.Conexion;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Periodico;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 *
 * @author Victor1
 */
public class daoPeriodico {
     //Conexion cx;
      Conexion cx;
    String tabla="periodico";
    
    public daoPeriodico(){
        cx=new Conexion();
    }
    public JSONObject select(int IdUsuario) {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        String varSql = "";
        String sql = "";
        
        int total = 0;
        try {
                varSql = "SELECT * FROM periodico WHERE IdUsuario= "+IdUsuario+";";
                System.out.println(varSql);
                sql = "SELECT COUNT(*) as TotalRecordCount FROM periodico" ;
              
            PreparedStatement varPst = cx.conectar().prepareStatement(varSql);
            PreparedStatement tt = cx.conectar().prepareStatement(sql);
            ResultSet rs = tt.executeQuery();
            
            if (rs.next()) {
                total = Integer.parseInt(rs.getString("TotalRecordCount"));
            }
            ResultSet varResultado = varPst.executeQuery();
            while (varResultado.next()) {
                varJsonObjectP.put("IdPeriodico", varResultado.getInt("IdPeriodico"));
                varJsonObjectP.put("IdUsuario", varResultado.getInt("IdUsuario"));
                varJsonObjectP.put("Nombre", varResultado.getString("Nombre"));
                varJsonObjectP.put("Estado", varResultado.getString("Estado"));
                varJsonObjectP.put("Tipo", varResultado.getString("Tipo"));
                varJsonObjectP.put("Precio", varResultado.getString("Precio"));
                varJsonArrayP.add(varJsonObjectP);
            }
            varResultado.close();
            varResultado = null;
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        varJsonObjectResultado.put("Result", "OK");
        varJsonObjectResultado.put("TotalRecordCount", total);
        varJsonObjectResultado.put("Records", varJsonArrayP);
        return varJsonObjectResultado;
    }
    public JSONObject insert(Periodico a) {
        JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        try {
            insertarBD(a);
            String varSql = "SELECT * FROM " + tabla + ";";
            PreparedStatement varPst = cx.conectar().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            while (varResultado.next()) {
                varJsonObjectRegistro.put("IdPeriodico", varResultado.getInt("IdPeriodico"));
                varJsonObjectRegistro.put("IdUsuario", varResultado.getInt("IdUsuario"));
                varJsonObjectRegistro.put("Nombre", varResultado.getString("Nombre"));
                varJsonObjectRegistro.put("Estado", varResultado.getString("Estado"));
                varJsonObjectRegistro.put("Tipo", varResultado.getString("Tipo"));
                varJsonObjectRegistro.put("Precio", varResultado.getString("Precio"));
            }
            varJsonObjectResultado.put("Result", "OK");
            varJsonObjectResultado.put("Record", varJsonObjectRegistro);
            varResultado.close();
            varResultado = null;
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
    }
    private void insertarBD(Periodico a) {
        try {
            String sql = "INSERT INTO " + tabla + " "
                    + "(IdUsuario,Nombre,Estado,Tipo,Precio) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
            varPst.setInt(1, a.getIdUsuario());
            varPst.setString(2, a.getNombre());
            varPst.setString(3, a.getEstado());
            varPst.setString(4, a.getTipo());
            varPst.setString(5, a.getPrecio());
            varPst.execute();
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
    }
    public JSONObject update(Periodico a) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            System.out.println("ID" + a.getIdPeriodico());
            String sql = "UPDATE " + tabla + " "
                    + "SET  "
                    + " IdUsuario= ?,"
                    + " Nombre= ?,"
                    + " Estado= ?,"
                    + " Tipo= ?,"
                    + " Precio= ?"
                    + " WHERE IdPeriodico= ? ";           
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
             varPst.setInt(1, a.getIdUsuario());
            varPst.setString(2, a.getNombre());
            varPst.setString(3, a.getEstado());
            varPst.setString(4, a.getTipo());
            varPst.setString(5, a.getPrecio());           
            varPst.setInt(6, a.getIdPeriodico());   
            varPst.executeUpdate();
            varJsonObjectResultado.put("Result", "OK");
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
    }

    public JSONObject delete(String IdPeriodico) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String sql = "DELETE FROM  " + tabla + " "
                    + "WHERE IdPeriodico =?;";
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
            varPst.setInt(1, Integer.parseInt(IdPeriodico));
            varPst.executeUpdate();
            varJsonObjectResultado.put("Result", "OK");
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
    }
}
