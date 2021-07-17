package BBH.POO;

import java.util.Scanner;

import BBH.tools.Hashing.HashC;
import BBH.tools.elineales.Listas.ListLinked;

public class Producto implements Comparable<Producto>{

    private int idProducto;
    private String NombreProducto;
    private String descripcion;
    private Tienda tienda;
    private int cantidad;
	private double precio;
    private int iva; 
    private static int contador = 0;
    private int TProducto;
    public Producto(int idProducto) {
    	this.idProducto = idProducto;
	}
	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


    public Producto(String Nombre,int Cantidad,String descripcion, double precio) {
        this.NombreProducto = Nombre;
        this.cantidad = Cantidad;
    	this.descripcion = descripcion;
        this.precio = precio;
        contador++;
        this.idProducto = contador;
    }
    
    public Producto(String NombreProducto, int cantidad, String string2) {
		this.NombreProducto = NombreProducto;
	}
	public int getIdProducto() {
        return idProducto;
    }
    public static Producto IngresarProducto() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("<=======\tNUEVO PRODUCTO\t=======>");
    	System.out.println("Ingrese nombre del producto");
    	String NombreProducto = s.next();
    	System.out.println("Ingrese cantidad:");
    	int cantidad = s.nextInt();
    	System.out.println("Ingrese una descripcion");
    	String descripcion = s.next();
    	System.out.println("Ingrese precio unitario");
    	double precio = s.nextDouble();
    	return new Producto(NombreProducto,cantidad,descripcion,precio);
    	
    }
    public String ObtenerTipoProducto(){
		if(TProducto == 1) {
			return "Viveres";
		}
		if(TProducto == 2) {
			return "Higiene";
		}
		if(TProducto == 3) {
			return "Alimentos";
		}
		return null;
	}
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
    public static void ReporteProductos(ListLinked<Producto> producto) {
    	HashC<Producto> Reporte = new HashC<Producto>(10);
    	for(int i=0;i<producto.length();i++) {
    		Reporte.insertarEncadenamiento(producto.getNodeAt(i).getData().getIdProducto(), producto.getNodeAt(i).getData());
    	}
    	System.out.println("<========\tReporte de productos\t=======>");
    	System.out.println(Reporte);
    }
    public boolean equals(Object o) {
    	if(o instanceof Producto) {
    		Producto a = (Producto) o;
    		if(this.idProducto == a.idProducto) return true;
    	}
    	return false;
    }
    public int compareTo(Producto o) {
    	if(this.getPrecio()<o.getPrecio()) {
    		return -1;
    	}
    	if(this.getPrecio()==o.getPrecio()) {
    		return 0;
    	}
    	else {
    		return 1;
    	}
    }
    
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Producto.contador = contador;
	}
	public int getTProducto() {
		return TProducto;
	}
	public void setTProducto(int tProducto) {
		TProducto = tProducto;
	}
	public String getNombreProducto() {
		return NombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

}