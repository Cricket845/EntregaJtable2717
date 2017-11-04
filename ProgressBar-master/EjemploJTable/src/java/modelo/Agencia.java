/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Victor1
 */
public class Agencia {
    int IdAgencia;
    int IdUsuario;
     String Nombre;
    String Estado;
    String Direccion;
    String Telefono;
   public  Agencia(){
    }

    public Agencia(int IdAgencia, int IdUsuario, String Nombre, String Estado, String Direccion, String Telefono) {
        this.IdAgencia = IdAgencia;
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public Agencia(int IdUsuario, String Nombre, String Estado, String Direccion, String Telefono) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public int getIdAgencia() {
        return IdAgencia;
    }

    public void setIdAgencia(int IdAgencia) {
        this.IdAgencia = IdAgencia;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Agencia{" + "IdAgencia=" + IdAgencia + ", IdUsuario=" + IdUsuario + ", Nombre=" + Nombre + ", Estado=" + Estado + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
    }
    
}
