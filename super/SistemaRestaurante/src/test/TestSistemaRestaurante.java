package test;

import java.time.LocalDate;

import modulo.SistemaRestaurante;

public class TestSistemaRestaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaRestaurante s1 = new SistemaRestaurante();
		
		
		try {
			s1.agregarCliente("Lucas", "Encinas", 123445l, "112345678");
			s1.agregarCliente("Santiago", "Perez", 123443l, "112345677");
			s1.agregarCliente("Matias", "Garcia", 123444l, "112345673");
			s1.agregarCliente("Nicolas", "Rodriguez", 123446l, "112345672");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarCliente("Lucas", "Encinas", 123445l, "112345678");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarMesa(1, 4);
			s1.agregarMesa(2, 6);
			s1.agregarMesa(3, 3);
			s1.agregarMesa(4, 2);
			s1.agregarMesa(5, 5);
			s1.agregarMesa(6, 6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarReserva(s1.traerCliente(123445l), LocalDate.of(2024, 11, 15), s1.traerMesa(2), 5);
			s1.agregarReserva(s1.traerCliente(123444l), LocalDate.of(2024, 9, 12), s1.traerMesa(3), 2);
			s1.agregarReserva(s1.traerCliente(123443l), LocalDate.of(2024, 11, 12), s1.traerMesa(1), 1);
			s1.agregarReserva(s1.traerCliente(123446l), LocalDate.of(2024, 10, 12), s1.traerMesa(6), 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(s1.traerReservas(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 10, 13)));
		
		
	}

}
