package modulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaRestaurante {
	private List<Cliente> lstClientes;
	private List<Mesa> lstMesas;
	private List<Reserva> lstReservas;

	public SistemaRestaurante() {
		super();
		this.lstClientes = new ArrayList<Cliente>();
		this.lstMesas = new ArrayList<Mesa>();
		this.lstReservas = new ArrayList<Reserva>();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public List<Mesa> getLstMesas() {
		return lstMesas;
	}

	public List<Reserva> getLstReservas() {
		return lstReservas;
	}

	@Override
	public String toString() {
		return "SistemaRestaurante \n lstClientes=\n" + lstClientes + ", lstMesas=" + lstMesas + ", lstReservas="
				+ lstReservas + "\n";
	}

	// Metodos

	public Cliente traerCliente(long dni) {
		Cliente auxCliente = null;
		int i = 0;

		while (i < lstClientes.size() && auxCliente == null) {
			if (lstClientes.get(i).getDni() == dni) {
				auxCliente = lstClientes.get(i);
			}
			i++;
		}
		return auxCliente;
	}

	public boolean agregarCliente(String nombre, String apellido, long dni, String telefono) throws Exception {
		if (traerCliente(dni) != null) {
			throw new Exception("Error: el cliente ya existe ");
		}
		int id;

		if (lstClientes.isEmpty()) {
			id = 1;
		} else {
			id = lstClientes.get(lstClientes.size() - 1).getIdCliente() + 1;
		}
		return lstClientes.add(new Cliente(id, nombre, apellido, dni, telefono));
	}

	public Mesa traerMesa(int numeroMesa) {
		Mesa auxMesa = null;
		int i = 0;

		while (i < lstMesas.size() && auxMesa == null) {
			if (lstMesas.get(i).getNumeroMesa() == numeroMesa) {
				auxMesa = lstMesas.get(i);
			}
			i++;
		}
		return auxMesa;
	}

	public boolean agregarMesa(int numeroMesa, int capacidad) throws Exception {
		if (traerMesa(numeroMesa) != null) {
			throw new Exception("Error: la mesa " + numeroMesa + " ya existe");
		}
		int id;

		if (lstMesas.isEmpty()) {
			id = 1;
		} else {
			id = lstMesas.get(lstMesas.size() - 1).getIdMesa() + 1;
		}
		return lstMesas.add(new Mesa(id, numeroMesa, capacidad));
	}

	public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {
		Reserva auxReserva = null;
		int i = 0;

		while (i < lstReservas.size() && auxReserva == null) {
			if (getLstReservas().get(i).getMesa().getNumeroMesa() == numeroMesa
					&& fechaReserva.equals(lstReservas.get(i).getFechaReserva())) {
				auxReserva = lstReservas.get(i);
			}
			i++;
		}
		return auxReserva;
	}

	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales)
			throws Exception {
		if (traerReserva(mesa.getNumeroMesa(), fechaReserva) != null) {
			throw new Exception("Error la mesa ya tiene reserva para ese dia");
		}
		int id;

		if (lstReservas.isEmpty()) {
			id = 1;
		} else {
			id = lstReservas.get(lstReservas.size() - 1).getIdReserva() + 1;
		}
		return lstReservas.add(new Reserva(id, cliente, fechaReserva, mesa, cantComensales));

	}

	public List<Reserva> traerReservas(LocalDate desde, LocalDate hasta) {
		List<Reserva> lstAux = new ArrayList<Reserva>();

		for (Reserva auxReserva : lstReservas) {
			if ((auxReserva.getFechaReserva().isAfter(desde) || auxReserva.getFechaReserva().equals(desde))
					&& (auxReserva.getFechaReserva().isBefore(hasta) || auxReserva.getFechaReserva().equals(hasta))) {
				lstAux.add(auxReserva);
			}
		}
		return lstAux;
	}

}
