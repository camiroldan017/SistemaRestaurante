package modulo;

public class ProductoPedido {
	private String producto;
	private double precio;
	
	public ProductoPedido(String producto, double precio) {
		super();
		this.producto = producto;
		this.precio = precio;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ProductoPedido [producto=" + producto + ", precio=" + precio + "]";
	}
	
	
	
	

}
