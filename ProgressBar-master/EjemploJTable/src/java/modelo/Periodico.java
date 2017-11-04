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
public class Periodico {
    int IdPeriodico;
    int IdUsuario;
    String Nombre;
    String Estado;
    String Tipo;
    String Precio;
    public Periodico (){
    }

    public Periodico(int IdPeriodico, int IdUsuario, String Nombre, String Estado, String Tipo, String Precio) {
        this.IdPeriodico = IdPeriodico;
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Precio = Precio;
    }

    public Periodico(int IdUsuario, String Nombre, String Estado, String Tipo, String Precio) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Precio = Precio;
    }

    public int getIdPeriodico() {
        return IdPeriodico;
    }

    public void setIdPeriodico(int IdPeriodico) {
        this.IdPeriodico = IdPeriodico;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return "Periodico{" + "IdPeriodico=" + IdPeriodico + ", IdUsuario=" + IdUsuario + ", Nombre=" + Nombre + ", Estado=" + Estado + ", Tipo=" + Tipo + ", Precio=" + Precio + '}';
    }

}
