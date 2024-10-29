/**
 * 
 */
package servicios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Logica de los metodos de club
 * 
 * @author nrojlla 161024
 */
public class ClubImplementacion implements ClubInterfaz {
	Scanner sc = new Scanner(System.in);
	ConexionInterfaz ci = new ConexionPostgresqlImplementacion();

	@Override
	public void DarAltaClub() throws IOException {

		try (Connection conexion = ci.GenerarConexion()) {

			if (conexion != null) {
				System.out.println("·················");
				System.out.println("Creación del club");
				System.out.println("·················");
				System.out.println("Ingrese nombre del club");
				String nombre = sc.nextLine();
				System.out.println("Ingrese Descripcion del club");
				String descripcion = sc.nextLine();
				System.out.println("Ingrese correo:");
				String correo = sc.nextLine();
				System.out.println("Ingrese contraseña:");
				String contrasenia = sc.nextLine();

				Long id = util.Util.GenerarIdClub(conexion);
				LocalDateTime creacion = LocalDateTime.now();

				String insertQuery = "INSERT INTO \"dlk_motos\".club (id_club, nombre_club, descripcion_club, creacion_club,correo_club,contra_club) VALUES (?,?,?,?,?,?) ";

				try (PreparedStatement ps = conexion.prepareStatement(insertQuery)) {

					ps.setLong(1, id);
					ps.setString(2, nombre);
					ps.setString(3, descripcion);
					ps.setTimestamp(4, java.sql.Timestamp.valueOf(creacion));// convertir el localDateTime a Timesstamp
					ps.setString(5, correo);
					ps.setString(6, contrasenia);

					ps.executeUpdate();

					System.out.println("Club creado y guardado con éxito en la base de datos.");
				}

			} else {
				System.out.println("No se pudo establecer la conexión, conexion nula.");
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
		}
	}

	public void BajaClub() throws IOException {

		try (Connection conexion = ci.GenerarConexion()) {

			if (conexion != null) {
				System.out.println("Ingrese nombre del club:");
				String nombre = sc.nextLine();

				String eliminarClub = "DELETE FROM \"dlk_motos\".club WHERE nombre_club = ?";

				try (PreparedStatement ps = conexion.prepareStatement(eliminarClub)) {
					ps.setString(1, nombre);

					int filasEliminadas = ps.executeUpdate();
					if (filasEliminadas > 0) {
						System.out.println("Club eliminado con éxito.");
					} else {
						System.out.println("No se encontró el club.");
					}
				} catch (SQLException e) {
					System.out.println("Error al eliminar el club: " + e.getMessage());
				}
			} else {
				System.out.println("No se pudo realizar la conexión.");
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
		}
	}

	@Override
	public void ModificarClub() throws IOException {
		MenuInterfaz mi = new MenuImplementacion();
		ConsultaInterfaz cz = new ConsultaPostgresqlImplementacion();

		try (Connection conexion = ci.GenerarConexion()) {

			if (conexion != null) {

				System.out.println("Ingrese nombre del club:");
				String nombre = sc.nextLine();

				String buscarClubPorNombre = "SELECT * FROM \"dlk_motos\".club WHERE nombre_club = ?";

				try (PreparedStatement ps = conexion.prepareStatement(buscarClubPorNombre)) {
					ps.setString(1, nombre);
					ResultSet resultSet = ps.executeQuery();

					if (resultSet.next()) {

						boolean esCerrado = false;
						do {

							byte opcion = mi.MenuModificarClub();

							switch (opcion) {
							case 0:
								System.out.println("Volviste");
								esCerrado = true;
								break;
							case 1:
								System.out.println("Ingrese su nuevo nombre:");
								String nuevoNombre = sc.nextLine();
								cz.ModificarNombreClub(nuevoNombre, nombre, conexion);
								System.out.println("Para seguir modificando, ingrese de nuevo con su nuevo nombre.");
								esCerrado = true;
								break;
							case 2:
								System.out.println("Ingrese su nueva descripcion:");
								String nuevaDescripcion = sc.nextLine();
								cz.ModificarDescripcionClub(nuevaDescripcion, nombre, conexion);
								break;
							case 3:
								System.out.println("Ingrese su nueva descripcion:");
								String nuevoCorreo = sc.nextLine();
								cz.ModificarCorreoClub(nuevoCorreo, nombre, conexion);							
								break;
							case 4:
								System.out.println("Ingrese su nueva descripcion:");
								String nuevaContrasenia = sc.nextLine();
								cz.ModificarContraseniaClub(nuevaContrasenia, nombre, conexion);	
								break;
							default:
								System.out.println("Error, opción no válida: " + opcion);
								break;
							}

						} while (!esCerrado);

					} else {
						System.out.println("No se encontró el nombre ingresado.");
					}
				} catch (SQLException e) {
					System.out.println("Error al buscar el nombre del club: " + e.getMessage());
				}
			} else {
				System.out.println("No se pudo realizar la conexión.");
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
		}
	}

}
