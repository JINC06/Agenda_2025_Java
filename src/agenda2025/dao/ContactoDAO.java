/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda2025.dao;

import agenda2025.db.ConnectionDB;
import agenda2025.model.Contacto;
import agenda2025.model.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio.nava
 */
public class ContactoDAO {
    
    public static void create(Contacto contacto) {
        ConnectionDB conexion = new ConnectionDB();
        try (Connection cnx = conexion.getConnection()) 
        {
            PreparedStatement preparedStatement = null;
            try {
                
                String query = "insert into contacto (nombres, apellidos, direccion) values (?, ?, ?)";
                preparedStatement = cnx.prepareStatement(query);
                preparedStatement.setString(1, contacto.getNombres());
                preparedStatement.setString(2, contacto.getApellidos());
                preparedStatement.setString(3, contacto.getDireccion());
                preparedStatement.executeUpdate();
                
                System.out.println("Contacto creado");
                
            }catch(Exception ex){
                System.out.println("Ocurrió un error al guardar el contacto: " + ex.toString());
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static List<Contacto> getAll() {
        List<Contacto> contactos = new ArrayList<>();
        
        ConnectionDB conexion = new ConnectionDB();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try (Connection cnx = conexion.getConnection()) 
        {
            String query = "select id_contacto, nombres, apellidos, direccion from contacto";
            preparedStatement = cnx.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                
                int idContacto = rs.getInt("id_contacto");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                
                Contacto contacto = new Contacto(idContacto, nombres, apellidos, direccion);
                contactos.add(contacto);
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return contactos;
    }
    
    public static void delete(int idContacto) {
        ConnectionDB conexion = new ConnectionDB();
        try (Connection cnx = conexion.getConnection()) 
        {
            PreparedStatement preparedStatement = null;
            try {
                
                String query = "delete from contacto where id_contacto = ?";
                preparedStatement = cnx.prepareStatement(query);
                preparedStatement.setInt(1, idContacto);
                preparedStatement.executeUpdate();
                
                System.out.println("Contacto eliminado");
                
            }catch(Exception ex){
                System.out.println("Ocurrió un error al eliminar el contacto: " + ex.toString());
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static void edit(Contacto contacto) {
        ConnectionDB conexion = new ConnectionDB();
        try (Connection cnx = conexion.getConnection()) 
        {
            PreparedStatement preparedStatement = null;
            try {
                
                String query = "update contacto set nombres = ?, apellidos = ?, direccion  = ? where id_contacto = ?";
                preparedStatement = cnx.prepareStatement(query);
                preparedStatement.setString(1, contacto.getNombres());
                preparedStatement.setString(2, contacto.getApellidos());
                preparedStatement.setString(3, contacto.getDireccion());
                preparedStatement.setInt(4, contacto.getIdContacto());
                preparedStatement.executeUpdate();
                
                System.out.println("Contacto actualizado");
                
            }catch(Exception ex){
                System.out.println("Ocurrió un error al actualizar el contacto: " + ex.toString());
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static void createFullContacto(Contacto contacto, List<Telefono> listTelefono) {
        
        ConnectionDB conexion = new ConnectionDB();
        try(Connection cnx = conexion.getConnection();)
        {
            try{
                //Para evitar que se haga commit en cada transaccion
                if(cnx.getAutoCommit()){
                    cnx.setAutoCommit(false);
                }
                
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                
                String queryInsertContacto = "insert into contacto (nombres, apellidos, direccion) values (?, ?, ?)";
                preparedStatement = cnx.prepareStatement(queryInsertContacto);
                preparedStatement.setString(1, contacto.getNombres());
                preparedStatement.setString(2, contacto.getApellidos());
                preparedStatement.setString(3, contacto.getDireccion());
                preparedStatement.executeUpdate();
                
                String queryLastID = "select LAST_INSERT_ID()";
                preparedStatement = cnx.prepareStatement(queryLastID);
                resultSet = preparedStatement.executeQuery();
                int idContacto = 0;
                if(resultSet.next()) {
                    idContacto = resultSet.getInt(1);
                }
                
                for(Telefono telefono : listTelefono) {
                    String queryInsertTelefono = "insert into telefono (numero_telefono, tipo_telefono, contacto) values (?, ?, ?)";
                    preparedStatement = cnx.prepareStatement(queryInsertTelefono);
                    preparedStatement.setString(1, telefono.getNumeroTelefono());
                    preparedStatement.setInt(2, telefono.getTipoTelefono());
                    preparedStatement.setInt(3, idContacto);
                    preparedStatement.executeUpdate();
                }
                
                cnx.commit();
                
            }catch(Exception ex) {
                cnx.rollback();
            }
            
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
