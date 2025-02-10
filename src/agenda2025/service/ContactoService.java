/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda2025.service;

import agenda2025.dao.ContactoDAO;
import agenda2025.model.Contacto;
import agenda2025.model.Telefono;
import java.util.List;

/**
 *
 * @author julio.nava
 */
public class ContactoService {
    
    public static void create(Contacto contacto) {
        //Validaciones previas
        ContactoDAO.create(contacto);
    }
    
    public static List<Contacto> getAll() {
        //Validaciones previas
        return ContactoDAO.getAll();
    }
    
    public static void delete(int idContacto) {
        //Validaciones previas
        ContactoDAO.delete(idContacto);
    }
    
    public static void edit(Contacto contacto) {
        //Validaciones previas
        ContactoDAO.edit(contacto);
    }
    
    public static void createFullContacto(Contacto contacto, List<Telefono> listTelefono) {
        //Validaciones previas
        ContactoDAO.createFullContacto(contacto, listTelefono);
    }
    
}
