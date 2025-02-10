
import agenda2025.model.Contacto;
import agenda2025.model.Telefono;
import agenda2025.service.ContactoService;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julio.nava
 */
public class Main {
    
    public static void main(String[] args) {
        
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setNombres("Bruce");
        nuevoContacto.setApellidos("Wayne");
        nuevoContacto.setDireccion("139 Kane Street");
        
        List<Telefono> listTelefonos = new ArrayList<>();
        
        Telefono telefonoFijo = new Telefono();
        telefonoFijo.setTipoTelefono(1); //-- FIJO
        telefonoFijo.setNumeroTelefono("+16002541223");
        listTelefonos.add(telefonoFijo);
        
        Telefono telefonoCelular = new Telefono();
        telefonoCelular.setTipoTelefono(2); //-- CELULAR
        telefonoCelular.setNumeroTelefono("+16002541224");
        listTelefonos.add(telefonoCelular);
        
        ContactoService.createFullContacto(nuevoContacto, listTelefonos);
        
    }
    
}
