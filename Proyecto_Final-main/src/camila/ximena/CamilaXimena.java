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

  enum EstadoPago {
        PENDIENTE, PAGADO, CANCELADO
    }

    enum TipoDePago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }

    enum CategoriaProducto {
        TECNOLOGIA, ROPA, ALIMENTO, HOGAR
    }
    enum EstadoPago {
        PENDIENTE, PAGADO, CANCELADO
    }

    enum TipoDePago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }

    enum CategoriaProducto {
        TECNOLOGIA, ROPA, ALIMENTO, HOGAR
    }
    enum EstadoPago {
        PENDIENTE, PAGADO, CANCELADO
    }

    enum TipoDePago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }

    enum CategoriaProducto {
        TECNOLOGIA, ROPA, ALIMENTO, HOGAR
    }
    enum EstadoPago {
        PENDIENTE, PAGADO, CANCELADO
    }

    enum TipoDePago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }

    enum CategoriaProducto {
        TECNOLOGIA, ROPA, ALIMENTO, HOGAR
    }

    interface MetodoPago {
        void procesarPago(double monto);

        void imprimirDetalles();

        TipoDePago getTipo();
    }

  
    static class PagoEfectivo implements MetodoPago {
        public void procesarPago(double monto) {
            System.out.println("Procesando pago en efectivo por: $" + monto);
            
        }

        public void imprimirDetalles() {
            System.out.println("Pago realizado en efectivo.");
        }

        public TipoDePago getTipo() {
            return TipoDePago.EFECTIVO;
        }
    }

    static class PagoTarjeta implements MetodoPago {
        private String numeroTarjeta;

        public PagoTarjeta(String numeroTarjeta) {
            this.numeroTarjeta = numeroTarjeta;
        }

        public void procesarPago(double monto) {
            System.out.println("Cargando $" + monto + " a la tarjeta: ****-****-****-" + numeroTarjeta.substring(numeroTarjeta.length() - 4));
        }

        public void imprimirDetalles() {
            System.out.println("Pago realizado con tarjeta terminada en: ****-" + numeroTarjeta.substring(numeroTarjeta.length() - 4));
        }

        public TipoDePago getTipo() {
            return TipoDePago.TARJETA;
        }
    }

    static class PagoTransferencia implements MetodoPago {
        private String numeroCuenta;

        public PagoTransferencia(String numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        public void procesarPago(double monto) {
            System.out.println("Realizando transferencia de $" + monto + " a la cuenta: " + numeroCuenta);
            // Lógica específica para la transferencia
        }

        public void imprimirDetalles() {
            System.out.println("Pago realizado por transferencia a la cuenta: " + numeroCuenta);
        }

        public TipoDePago getTipo() {
            return TipoDePago.TRANSFERENCIA;
        }
    }

    
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
     static class DetalleVenta {
        Producto producto;
        int cantidad;

        public DetalleVenta(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public double subtotal() {
            return producto.precio * cantidad;
        }

        public String descripcion() {
            return cantidad + " x " + producto.nombre + " = $" + subtotal();
        }
    }

}

