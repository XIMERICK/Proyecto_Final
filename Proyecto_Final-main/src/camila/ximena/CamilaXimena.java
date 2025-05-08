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
      static class Venta {
        int id;
        Cliente cliente;
        List<DetalleVenta> detalles;
        Date fecha;
        MetodoPago metodoPago;
        EstadoPago estadoPago;

        public Venta(int id, Cliente cliente) {
            this.id = id;
            this.cliente = cliente;
            this.fecha = new Date();
            this.detalles = new ArrayList<>();
            this.estadoPago = EstadoPago.PENDIENTE;
        }

        public void agregarDetalle(DetalleVenta detalle) {
            detalles.add(detalle);
        }

        public double total() {
            return detalles.stream().mapToDouble(DetalleVenta::subtotal).sum();
        }

        public void setMetodoPago(MetodoPago metodoPago) {
            this.metodoPago = metodoPago;
        }

        public void procesarPago() {
            if (this.metodoPago != null) {
                this.metodoPago.procesarPago(total());
                this.estadoPago = EstadoPago.PAGADO;
                this.metodoPago.imprimirDetalles();
            } else {
                System.out.println("No se ha asignado un método de pago.");
            }
        }

        public void imprimirFactura() {
            System.out.println("Venta #" + id + " - Cliente: " + cliente.nombre);
            for (DetalleVenta d : detalles) {
                System.out.println(d.descripcion());
            }
            System.out.println("TOTAL: $" + total());
            System.out.println("Estado del Pago: " + estadoPago);
            if (metodoPago != null) {
                System.out.println("Método de Pago: " + metodoPago.getTipo());
                metodoPago.imprimirDetalles();
            }
        }
        
    }
      
    static class Pedido {
        int id;
        Cliente cliente;
        List<Producto> productos;
        Date fecha;

        public Pedido(int id, Cliente cliente) {
            this.id = id;
            this.cliente = cliente;
            this.fecha = new Date();
            this.productos = new ArrayList<>();
        }

        public void agregarProducto(Producto p) {
            productos.add(p);
        }
    }
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Ana Torres", "Calle Luna 45", "312345678");
        Cliente cliente2 = new Cliente(2, "Carlos Pérez", "Avenida Sol 10", "987654321");
        Cliente cliente3 = new Cliente(3, "Ximena Orozco", "Eucalipto", "3245640493");
        Cliente cliente4 = new Cliente(4, "Erick Cano", "Puertas del Sol", "1056432675");
        Cliente cliente5 = new Cliente(5, "Maria Nieves", "Avenida 12 de Octubre", "86353627");

        Proveedor proveedor1 = new Proveedor(1, "Proveedor Bimbo", "321-111-222");
        Categoria categoriaAbarrotes = new Categoria(1, CategoriaProducto.Abarrotes);
        
        Proveedor proveedor2 = new Proveedor(2, "Proveedor Carnecol", "321-567-3456");
        Categoria categoriaCarnicos = new Categoria(2, CategoriaProducto.Carnicos);
        
        Proveedor proveedor3 = new Proveedor(3, "Los Cedros", "878-70-00");
        Categoria categoriaAseo = new Categoria(3, CategoriaProducto.Carnicos);
        
        Proveedor proveedor4 = new Proveedor(4, "Colanta", "313-456-7876");
        Categoria categoriaLacteos = new Categoria(4, CategoriaProducto.Lacteos);
        
       // Crear productos
        Producto arroz = new Producto(1, "arroz", 1500.0, categoriaAbarrotes, proveedor);
        Producto papel = new Producto(2, "papel", 25.0, categoriaAseo, proveedor);
        Producto Leche = new Producto(3, "Leche", 20.0, categoriaLacteos, proveedorTextil);

       
      
        Inventario inv1 = new Inventario(laptop, 10);
        Inventario inv2 = new Inventario(mouse, 50);
        Inventario inv3 = new Inventario(camiseta, 100);

        // Crear venta 1
        Venta venta1 = new Venta(1, cliente);
        venta1.agregarDetalle(new DetalleVenta(laptop, 1));
        venta1.agregarDetalle(new DetalleVenta(mouse, 2));

        System.out.println("--- Factura Venta 1 ---");
        venta1.imprimirFactura();

        // Asignar y procesar pago con tarjeta para venta 1
        PagoTarjeta pagoTarjeta1 = new PagoTarjeta("1234-5678-9012-3456");
        venta1.setMetodoPago(pagoTarjeta1);
        System.out.println("\n--- Realizando Pago Venta 1 ---");
        venta1.procesarPago();
        System.out.println("\n--- Factura Venta 1 con Pago ---");
        venta1.imprimirFactura();

        // Crear venta 2
        Venta venta2 = new Venta(2, cliente2);
        venta2.agregarDetalle(new DetalleVenta(camiseta, 3));

        System.out.println("\n--- Factura Venta 2 ---");
        venta2.imprimirFactura();

        // Asignar y procesar pago en efectivo para venta 2
        PagoEfectivo pagoEfectivo2 = new PagoEfectivo();
        venta2.setMetodoPago(pagoEfectivo2);
        System.out.println("\n--- Realizando Pago Venta 2 ---");
        venta2.procesarPago();
        System.out.println("\n--- Factura Venta 2 con Pago ---");
        venta2.imprimirFactura();

        // Crear pedido
        Pedido pedido = new Pedido(1, cliente);
        pedido.agregarProducto(laptop);
        pedido.agregarProducto(mouse);
        pedido.agregarProducto(camiseta);
        System.out.println("\n--- Pedido Cliente 1 ---");
        for (Producto p : pedido.productos) {
            System.out.println("- " + p.nombre);
        }
    }
}

