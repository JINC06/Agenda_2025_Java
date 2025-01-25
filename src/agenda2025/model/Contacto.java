/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda2025.model;

/**
 *
 * @author julio.nava
 */
public class Contacto {
    
    private int idContacto;
    private String nombres;
    private String apellidos;
    private String direccion;

    public Contacto() {
    }

    public Contacto(int idContacto, String nombres, String apellidos, String direccion) {
        this.idContacto = idContacto;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public Contacto(String nombres, String apellidos, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }
    
    /**
     * @return the idContacto
     */
    public int getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
