package logica;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Logica {
	
	public static void main(String[] args) {
		
		List <Entrada> eventoPalco = new ArrayList <Entrada> ();
		List <Entrada> eventoPlatea = new ArrayList <Entrada> ();
		List <Entrada> eventoGaleria = new ArrayList <Entrada> ();
		
		
		//----------------------MENU PRINCIPAL------------------------------
		int iniciadorMenu = 0;	
		do {
			System.out.println("Bienvenido, ingrese el numero de la opción: \n"
					+ "1. Comprar entrada\n"
					+ "2. Entrar como administrador\n"
					+ "3. Salir\n"
					+ "---------------------------");
			Scanner teclado = new Scanner(System.in);
			iniciadorMenu = teclado.nextInt();
			switch(iniciadorMenu) {
				case 1:
					menuUsuario(eventoPalco, eventoPlatea, eventoGaleria);
					break;
				case 2:
					menuAdmin(eventoPalco, eventoPlatea, eventoGaleria);
					break;
				case 3:
					System.out.println("Hasta luego, que tenga un buen día");
					break;
				default:
					System.out.println("Debe seleccionar una opcion del menu");
			}
		}while(iniciadorMenu != 3);
	}
	
	//---------------------------MENU ADMINISTRADOR-----------------------
	private static void menuAdmin(List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria) {		
		int iniciadorMenuAdmin = 0;
		do {
			System.out.println("\nBienvenido a su dashboard, seleccione una opción: \n"
					+ "1. Ver cantidad de entradas vendidas\n"
					+ "2. Ver cantidad de entradas disponibles para venta\n"
					+ "3. Ver dinero recaudado\n"
					+ "4. Salir\n"
					+ "---------------------------");
			Scanner teclado = new Scanner(System.in);
			iniciadorMenuAdmin = teclado.nextInt();
			switch(iniciadorMenuAdmin) {
				case 1:
					entradasVendidas(eventoPalco, eventoPlatea, eventoGaleria);
					break;
				case 2:
					entradasDisponibles(eventoPalco, eventoPlatea, eventoGaleria);
					break;
				case 3:
					verRecaudacion(eventoPalco, eventoPlatea, eventoGaleria);
					break;
				case 4:
					System.out.println("Hasta luego, que tenga un buen día\n");
					break;
				default:
					System.out.println("Debe seleccionar una opcion del menu");
			}
		}while(iniciadorMenuAdmin != 4);
		
	}

	private static void entradasVendidas(List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria) {
		System.out.printf("Cantidad de entradas vendidas: %nPalco: %d%nPlatea: %d%nGaleria: %d%n%n",eventoPalco.size(), eventoPlatea.size(), eventoGaleria.size());
	}

	private static void entradasDisponibles(List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria) {
		int entradaDisponiblePalco = 15 - eventoPalco.size();
		int entradaDisponiblePlatea = 30 - eventoPlatea.size();
		int entradaDisponibleGaleria = 55 - eventoGaleria.size();
		System.out.printf("Entradas disponibles en: %nPalco: %d%nPlatea: %d%nGaleria: %d%n%n",entradaDisponiblePalco, entradaDisponiblePlatea, entradaDisponibleGaleria);		
	}
	
	private static void verRecaudacion(List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria) {
		int recaudacionPalco = eventoPalco.size() * 50000;
		int recaudacionPlatea = eventoPlatea.size() * 30000;
		int recaudacionGaleria = eventoGaleria.size() * 5000;
		int total = recaudacionPalco + recaudacionPlatea + recaudacionGaleria;
		System.out.printf("El total recaudado por las ventas es => $%d %nPalco: $%d pesos%nPlatea: $%d pesos.%nGaleria: $%d pesos.%n%n", total, recaudacionPalco, recaudacionPlatea, recaudacionGaleria);	
	}

	//----------------------------MENU USUARIO-----------------------------
	private static void menuUsuario(List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria) {
		
		int tipoAsiento;
		do{		
			Entrada entrada = new Entrada();
			
			System.out.println("\nSeleccione el asiento a comprar:"
					+ "\n1. Palco"
					+ "\n2. Platea"
					+ "\n3. Galeria"
					+ "\n4. Salir");
			Scanner teclado = new Scanner( System.in);
			tipoAsiento = teclado.nextInt();
		
			switch(tipoAsiento) {
			case 1:
				if(eventoPalco.size() == 15) {
					System.out.println("Lo sentimos, no hay asientos disponibles en palco! :(\n");
				}else {					
					ingresoDatos(entrada,tipoAsiento, eventoPalco, eventoPlatea, eventoGaleria);	
				}
				break;
			case 2:
				if(eventoPlatea.size() == 30) {
					System.out.println("Lo sentimos, no hay asientos disponibles en platea! :(\n");
				}else {
					ingresoDatos(entrada, tipoAsiento, eventoPlatea, eventoPlatea, eventoGaleria);					
				}
				break;
			case 3:
				if(eventoGaleria.size() == 55){
					System.out.println("Lo sentimos, no hay asientos disponibles en galeria! :(\n");
				}else {
				ingresoDatos(entrada, tipoAsiento, eventoGaleria, eventoPlatea, eventoGaleria);
				}
				break;
			case 4:
				System.out.println("Hasta luego :)\n\n");
				break;
			default:
				System.out.println("Debe seleccionar una opcion disponible, vuelva a intentar!\n");
			}
		}while(tipoAsiento != 4);
	}
	
	private static void ingresoDatos(Entrada entrada, int tipoAsiento, List<Entrada> eventoPalco, List<Entrada> eventoPlatea, List<Entrada> eventoGaleria ) {
		Scanner teclado = new Scanner( System.in);
		System.out.println("Para comprar una entrada debe ingresar sus datos:");
		System.out.println("Ingrese su nombre:");
		entrada.nombre = teclado.next();
		System.out.println("Ingrese su apellido:");
		entrada.apellido = teclado.next();
		System.out.println("Ingrese su rut:");
		entrada.rut = teclado.next();
		
		System.out.printf("Su compra fue realizada con exito! con los siguientes datos: \n"
				+ "Nombre: %s %s%n"
				+ "Rut: %s%n",
				entrada.getNombre(),
				entrada.getApellido(),
				entrada.getRut());
		
		if(tipoAsiento == 1) {
			eventoPalco.add(entrada);
		}else if(tipoAsiento == 2) {
			eventoPlatea.add(entrada);
		}else {
			eventoGaleria.add(entrada);
		}
	}

}
