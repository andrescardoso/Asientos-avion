package Ejercicio2;

public class VueloDeAvion{
	
	private EstadoAsiento[] asientos;
	int[] numerosDeAsientosReservados;
	
	public VueloDeAvion(int cantidadDeAsientos) {
		this.asientos = new EstadoAsiento[cantidadDeAsientos];	
		for (int i = 0; i < cantidadDeAsientos; i++) {
			asientos[i]=EstadoAsiento.DISPONIBLE; // INICIALIZO TODO EN DISPONIBLE PARA DESPUÉS PODER CAMBIAR VALORES
		}
	}
	
	// MÉTODOS
	public void reservar(int[] numerosDeAsientosReservados) {
		for (int i = 0; i < numerosDeAsientosReservados.length; i++) {
			if(consultarEstado(numerosDeAsientosReservados[i]).equals(EstadoAsiento.DISPONIBLE)) {
				asientos[numerosDeAsientosReservados[i]]=EstadoAsiento.RESERVADO;
			}
		}
		System.out.println("Asientos reservados");
	}
	
	public int[] obtenerNumerosDeAsientosDisponibles() {
		int[] numerosDeAsientosDisponibles = new int[this.contarAsientosDisponibles()];		
		int j=0;
			for (int i = 0; i < asientos.length; i++) {
				if (asientos[i]==EstadoAsiento.DISPONIBLE){
					numerosDeAsientosDisponibles[j]=i;
					j++;
				}
			}
			for (int i = 0; i < numerosDeAsientosDisponibles.length; i++) {
				System.out.print(numerosDeAsientosDisponibles[i]+" ");
			}
		return numerosDeAsientosDisponibles;
	}
	
	public int contarAsientosDisponibles() {
		int cont=0;
		for (int i = 0; i < asientos.length; i++) {
			if(asientos[i].equals(EstadoAsiento.DISPONIBLE)) 
				cont++;
		}
		return cont;
	}
	
	public int contarAsientosVendidosEntre(int desdeNumeroAsiento, int hastaNumeroAsiento) {
		int cont=0;
		for (int i = desdeNumeroAsiento; i < hastaNumeroAsiento; i++) {
			if(asientos[i]==EstadoAsiento.VENDIDO) {
				cont++;
			}
		}
		return cont;
	}
	
	public void vender(int numeroDeAsiento) {
		if(asientos[numeroDeAsiento].equals(EstadoAsiento.DISPONIBLE)) {
		System.out.println("Asiento "+numeroDeAsiento+" vendido correctamente.");
		this.asientos[numeroDeAsiento]=EstadoAsiento.VENDIDO;
		}
		else if (asientos[numeroDeAsiento].equals(EstadoAsiento.RESERVADO)) {
			System.out.println("El asiento estaba reservado pero ha sido vendido.");
		}
		else
			System.out.println("El asiento ya ha sido vendido.");
	}
	
	public EstadoAsiento consultarEstado(int numeroDeAsiento) {
		return asientos[numeroDeAsiento];
	}
	
	// MAIN
	public static void main(String[] args) {

		VueloDeAvion obj = new VueloDeAvion(60);
		obj.vender(0);
		obj.vender(8);
		obj.vender(14);
		obj.vender(14); // REBOTA POR YA HABERLE ASIGNADO ESTADOASIENTO.VENDIDO A ESTA POSICIÓN
		obj.vender(24);
		System.out.println(obj.contarAsientosDisponibles());
		System.out.println(obj.contarAsientosVendidosEntre(5, 20));
		System.out.println(obj.obtenerNumerosDeAsientosDisponibles());
	   } 
}