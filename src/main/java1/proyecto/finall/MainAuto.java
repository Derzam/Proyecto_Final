package proyecto.finall;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MainAuto {

	// TODO Auto-generated constructor stub

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		Scanner lector2 = new Scanner(System.in);
		String opcion;
		String placa;
		String cedula;
		String modelo;
		String marca;
		
		Date date = new Date();

		LocalDate diaHoy = LocalDate.now();

		int numerOpcion;
		System.out.println("SISTEMA METROCARD");
		System.out.println("...............................");

		AutoDatos auto = new AutoDatos();
		AutoDatos[] nuevoAuto = new AutoDatos[20];
		int j = 0;

		do {
			System.out.println("Elija una opcion");
			System.out.println("1.- Cliente");
			System.out.println("2.- Empleado");
			System.out.println("3.- SALIR");

			numerOpcion = lector2.nextInt();

			if (numerOpcion == 1) {

				do {
					System.out.println("a. Consultar autos");
					System.out.println("b. Reservar autos");

					System.out.println("Elija una opcion");
					opcion = lector.nextLine();

					if (opcion.equals("a")) {
						System.out.println("Ingrese el modelo y/o marca del auto ");
						String modelo1 = lector.nextLine();

						for (int i = 0; i < nuevoAuto.length; i++) {

							AutoDatos buscarAuto = nuevoAuto[i];
							AutoDatos buscarAuto1 = nuevoAuto[i];
							if (buscarAuto != null || buscarAuto != null) {
								String marcaExistente = buscarAuto.getMarca();
								String modeloExistente = buscarAuto1.getModelo();
								boolean encontrar1 = modelo1.equals(marcaExistente);
								boolean encontrar2 = modelo1.equals(modeloExistente);

								if (encontrar1 == false || encontrar2 == true) {

									System.out.println(nuevoAuto[i]);

								} else if (encontrar1 == true || encontrar2 == false) {

									System.out.println(nuevoAuto[i]);
									System.out.println("Auto no encontrado");
								}

							}
						}

					} else if (opcion.equals("b")) {

						System.out.println("Placa del auto: ");
						placa = lector.nextLine();
						System.out.println("La cedula del cliente: ");
						cedula = lector.nextLine();

						for (int i = 0; i < nuevoAuto.length; i++) {
							AutoDatos autos = nuevoAuto[i];
							boolean encontrar = autos.getPlaca().contains(placa);
							boolean encontrarAuto = autos.getCedula().contains(cedula);

							if (encontrar == true || encontrarAuto == false) {
								if (autos.getEstado().equals("Disponible")) {
									autos.setEstado("reservado");
									System.out.println(nuevoAuto[i]);

									nuevoAuto[i].setCedula(cedula);

									System.out.println(
											"El auto ha sido reservado correctamente, debe pasar a retirarlo al patio de Autos ");

								}

							}

							nuevoAuto[i] = autos;
						}
					}
				} while (opcion.equals("c"));

			} else if (numerOpcion == 2) {

				System.out.println("a.Ingresar un auto");
				System.out.println("b. Alquilar un auto");
				System.out.println("c. Aplazar fecha de entrega");
				System.out.println("---------------------------");
				System.out.println("Elija una opcion");
				opcion = lector.nextLine();

				if (opcion.equals("a")) {

					System.out.println("Ingrese la siguiente información:");
					System.out.println("*************");
					System.out.println("PLaca");
					String placaP = lector.nextLine();
					System.out.println("Modelo");
					String modeloP = lector.nextLine();
					System.out.println("Marca");
					String marcaP = lector.nextLine();
					System.out.println("Año de fabricacion");
					String anioL = lector.nextLine();
					System.out.println("Pais de Fabricacion");
					String paisDeFabricacion = lector.nextLine();
					System.out.println("Cilindraje");
					double cilindraje = lector.nextDouble();
					System.out.println("Precio del auto");
					String precioL = lector.nextLine();

					auto.setPlaca(placaP);
					auto.setModelo(modeloP);
					auto.setMarca(marcaP);
					auto.setAnioDeFabricacion(anioL);
					auto.setPaisDeFabricacion(paisDeFabricacion);
					auto.setCilindraje(cilindraje);
					auto.setPrecio(precioL);

					nuevoAuto[j] = new AutoDatos();

					String elegir;
					System.out.println("Elija que tipo de auto es");
					System.out.println("***********");
					System.out.println("1. Automovil");
					System.out.println("2. Camioneta");
					elegir = lector.nextLine();
					switch (elegir) {
					case "1":
						System.out.println("Numero de Puertas");
						String numPuertas = lector.nextLine();
						auto.setNumeroDePuertas(numPuertas);

						j++;
						System.out.println("Ha sido guardado exitosamente.");
						break;
					case "2":
						System.out.println("Peso que soporta ");
						int peso = lector.nextInt();
						auto.setTiempoLectura(peso);
						nuevoAuto[j] = new AutoDatos();

						j++;
						System.out.println("Ha sido guardado exitosamente.");

						break;
					}

					nuevoAuto[j] = new AutoDatos();

					j++;
					System.out.println("Ha sido guardado exitosamente.");

				} else if (opcion.equals("b")) {
					System.out.println("Ingrese la placa del auto:");
					String placa2 = lector.nextLine();

					for (int i = 0; i < nuevoAuto.length; i++) {
						AutoDatos autos = nuevoAuto[i];
						boolean encontrar = autos.getPlaca().contains(placa2);

						if (encontrar == true) {

							if (autos.getEstado().equals("reservado")) {

								System.out.println(nuevoAuto[i]);

								System.out.println("1.-Alquilar");
								System.out.println("2.-No Alquilar");
								int escoger = lector.nextInt();
								if (escoger == 1) {
									autos.getEstado().equals("reservado");
									autos.setEstado("alquilado");

									diaHoy = LocalDate.now();
									diaHoy = diaHoy.plusDays(2);
									System.out.println("Fecha de Entrega:" + nuevoAuto[i].getFechaDeEntrega());

								} else if (escoger == 2) {
									autos.setEstado("Disponible");

								}
								System.out.println("El auto se ha reservado correctamente");
							}
						}
						nuevoAuto[i] = autos;
					}

				} else if (opcion.equals("c")) {
					System.out.println("Ingrese la placa del Auto");
					String placaAuto = lector.nextLine();
					System.out.println("Ingrese la cedula del cliente ");
					String cedulaCliente = lector.nextLine();

					for (int i = 0; i < nuevoAuto.length; i++) {
						AutoDatos autos = nuevoAuto[i];
						boolean encontrar = autos.getPlaca().contains(placaAuto);
						boolean encontrarAuto2 = autos.getCedula().contains(cedulaCliente);

						if (encontrar == true && encontrarAuto2 == true) {

							if (autos.getEstado().equals("alquilado")) {

								System.out.println(nuevoAuto[i]);

								System.out.println("1.-Aplazar");
								System.out.println("2.-No aplazar");
								int escoger = lector.nextInt();
								if (escoger == 1) {

									LocalDate diaPlazo = LocalDate.now();
									diaPlazo = diaHoy.plusDays(3);
									nuevoAuto[i].setFechaDeEntrega(diaPlazo);
									System.out.println("Fecha de Entrega:" + nuevoAuto[i].getFechaDeEntrega());

								} else if (escoger == 2) {
									System.out.println("El auto no ha sido encontrado ");
								}

							}
						}
						nuevoAuto[i] = autos;
					}
				}
			}

		} while (numerOpcion != 3);
		System.out.println("Metrocard");
		System.out.println("Hasta pronto");
	}

}