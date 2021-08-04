/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author rodka
 */
public class OComuna {

    private int Id = 0;
    private String Nombre = "";
    private boolean Estado = false;

    public OComuna(int aInt, String string, String string0, String string1, String string2, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public OComuna() {
    }
    
    public OComuna(int id, String nombre, boolean estado) {
        Id = id;
        Nombre = nombre;
        Estado = estado;
    }


}
