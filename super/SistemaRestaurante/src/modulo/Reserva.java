package modulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Mesa mesa;
	private int cantComensales;
	private List<ProductoPedido> lstPedidos;
	
	public Reserva(int idReserva, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception {
		super();
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.mesa = mesa;
		setCantComensales(cantComensales);
		this.lstPedidos = new ArrayList<ProductoPedido>();
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReservaDate(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getCantComensales() {
		return cantComensales;
	}

	public void setCantComensales(int cantComensales) throws Exception {
		if(validarComensales(cantComensales) != true) {
			throw new Exception("Error: la cant de comensales sobrepasa a lade la mesa");
		}
		this.cantComensales = cantComensales;
	}

	public List<ProductoPedido> getLstPedidos() {
		return lstPedidos;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", fechaReservaDate=" + fechaReserva
				+ ", mesa=" + mesa + ", cantComensales=" + cantComensales + ", lstPedidos=" + lstPedidos + "\n";
	}

	private boolean validarComensales(int cantComensales) {
		
		return (mesa.getCapacidad() >= cantComensales);
			
		
	}
	
	
	
	

}
