/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda2025.model;

/**
 *
 * @author julio.nava
 */
public class TipoTelefono {
    
    private int idTipoTelefono;
    private String descripcion;

    public TipoTelefono() {
    }

    public TipoTelefono(int idTipoTelefono, String descripcion) {
        this.idTipoTelefono = idTipoTelefono;
        this.descripcion = descripcion;
    }
    
    /**
     * @return the idTipoTelefono
     */
    public int getIdTipoTelefono() {
        return idTipoTelefono;
    }

    /**
     * @param idTipoTelefono the idTipoTelefono to set
     */
    public void setIdTipoTelefono(int idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
