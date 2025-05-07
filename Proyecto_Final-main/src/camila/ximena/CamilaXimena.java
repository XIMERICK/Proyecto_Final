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
    
    static class Proveedor {
        int id;
        String razonSocial;
        String telefono;
        String direccion;

        public Proveedor(int id, String razonSocial, String telefono, String direccion) {
            this.id = id;
            this.razonSocial = razonSocial;
            this.telefono = telefono;
            this.direccion = direccion;
        }
    }

    static class Categoria {
        int id;
        CategoriaProducto nombre_producto;
        String cantidad;

        public Categoria(int id, CategoriaProducto nombre, String cantidad) {
            this.id = id;
            this.nombre_producto = nombre_producto;
            this.cantidad = cantidad;
        }
    }

    static class Producto {
        int id;
        String nombre;
        double precio;
        Categoria categoria;
        Proveedor proveedor;

        public Producto(int id, String nombre, double precio, Categoria categoria, Proveedor proveedor) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.categoria = categoria;
            this.proveedor = proveedor;
        }
    }
    
     static class Inventario {
        Producto producto;
        int cantidad;

        public Inventario(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

    }

}

