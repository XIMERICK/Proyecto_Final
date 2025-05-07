/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package camila.ximena;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * @author USER
 */
public class CamilaXimena {

    enum EstadoPago { PENDIENTE, COMPLETADO, CANCELADO }

    enum TipoDePago { EFECTIVO, TARJETA_DEBITO }

    enum CategoriaProducto { ASEO, CARNICOS, LACTEOS, ABARROTES }
    
    static class Cliente {
        int id;
        String nombre;
        String direccion;
        String telefono;

        public Cliente(int id, String nombre, String direccion, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
        }
    }

}



/**
 *
 * @author konna
 */
public class CamilaXimena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
