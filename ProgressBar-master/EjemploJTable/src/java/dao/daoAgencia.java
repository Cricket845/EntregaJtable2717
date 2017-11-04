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
import modelo.Agencia;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Victor1
 */
public class daoAgencia {
    //Conexion cx;
    Conexion cx;
    String tabla="agencia";
    public daoAgencia(){
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
                varSql = "SELECT * FROM agencia WHERE IdUsuario= "+IdUsuario+";";
                System.out.println(varSql);
                sql = "SELECT COUNT(*) as TotalRecordCount FROM agencia" ;
              
            PreparedStatement varPst = cx.conectar().prepareStatement(varSql);
            PreparedStatement tt = cx.conectar().prepareStatement(sql);
            ResultSet rs = tt.executeQuery();
            
            if (rs.next()) {
                total = Integer.parseInt(rs.getString("TotalRecordCount"));
            }
            ResultSet varResultado = varPst.executeQuery();
            while (varResultado.next()) {
                varJsonObjectP.put("IdAgencia", varResultado.getInt("IdAgencia"));
                varJsonObjectP.put("IdUsuario", varResultado.getInt("IdUsuario"));
                varJsonObjectP.put("Nombre", varResultado.getString("Nombre"));
                varJsonObjectP.put("Estado", varResultado.getString("Estado"));
                varJsonObjectP.put("Direccion", varResultado.getString("Direccion"));
                varJsonObjectP.put("Telefono", varResultado.getString("Telefono"));
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
    public JSONObject insert(Agencia a) {
        JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        try {
            insertarBD(a);
            String varSql = "SELECT * FROM " + tabla + ";";
            PreparedStatement varPst = cx.conectar().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            while (varResultado.next()) {
                varJsonObjectRegistro.put("IdAgencia", varResultado.getInt("IdAgencia"));
                varJsonObjectRegistro.put("IdUsuario", varResultado.getInt("IdUsuario"));
                varJsonObjectRegistro.put("Nombre", varResultado.getString("Nombre"));
                varJsonObjectRegistro.put("Estado", varResultado.getString("Estado"));
                varJsonObjectRegistro.put("Direccion", varResultado.getString("Direccion"));
                varJsonObjectRegistro.put("Telefono", varResultado.getString("Telefono"));
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
    private void insertarBD(Agencia a) {
        try {
            String sql = "INSERT INTO " + tabla + " "
                    + "(IdUsuario,Nombre,Estado,Direccion,Telefono) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
            varPst.setInt(1, a.getIdUsuario());
            varPst.setString(2, a.getNombre());
            varPst.setString(3, a.getEstado());
            varPst.setString(4, a.getDireccion());
            varPst.setString(5, a.getTelefono());
            varPst.execute();
            varPst.close();
            varPst = null;
            cx.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
    }
    public JSONObject update(Agencia a) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            System.out.println("ID" + a.getIdAgencia());
            String sql = "UPDATE " + tabla + " "
                    + "SET  "
                    + " IdUsuario= ?,"
                    + " Nombre= ?,"
                    + " Estado= ?,"
                    + " Direccion= ?,"
                    + " Telefono= ?"
                    + " WHERE IdAgencia= ? ";           
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
             varPst.setInt(1, a.getIdUsuario());
            varPst.setString(2, a.getNombre());
            varPst.setString(3, a.getEstado());
            varPst.setString(4, a.getDireccion());
            varPst.setString(5, a.getTelefono());           
            varPst.setInt(6, a.getIdAgencia());   
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

    public JSONObject delete(String IdAgencia) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String sql = "DELETE FROM  " + tabla + " "
                    + "WHERE IdAgencia =?;";
            PreparedStatement varPst = cx.conectar().prepareStatement(sql);
            varPst.setInt(1, Integer.parseInt(IdAgencia));
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
