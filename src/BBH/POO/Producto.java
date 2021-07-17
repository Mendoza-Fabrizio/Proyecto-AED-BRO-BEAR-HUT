package BBH.POO;

import BBH.tools.Hashing.HashC;
import BBH.tools.elineales.Listas.ListLinked;

public class Producto implements Comparable<Producto>{

    private int idProducto;
    private String descripcion;
    private String tienda;
    public Producto(String descripcion, int precio, String tienda) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.tienda=tienda;
	}
	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	private int precio;
    private int iva; 
    private String nota;

    public Producto(int idProducto, String descripcion, int precio, int iva, String nota) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.nota = nota;
    }

    public int getIdProducto() {
        return idProducto;
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

    public int getPrecio() {
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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

}