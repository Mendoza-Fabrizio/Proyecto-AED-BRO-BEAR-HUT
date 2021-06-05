public class Producto implements Comparable<Producto>{

    private String idProducto;
    private String descripcion;
    private int precio;
    private int iva; 
    private String nota;

    public Producto(String idProducto, String descripcion, int precio, int iva, String nota) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.nota = nota;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
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
        return idProducto + "|"
                + descripcion + "|"
                + precio + "|"
                + iva + "|"
                + nota;
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