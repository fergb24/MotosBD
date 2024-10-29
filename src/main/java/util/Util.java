package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase Util con métodos útiles para la aplicación.
 * 
 * @author nrojlla 151024
 */
public class Util {

	/**
	 * Genera un nuevo ID para el club.
	 * 
	 * @param conexion Conexión a la base de datos
	 * @return El nuevo ID generado o null si ocurre un error
	 */
	public static Long GenerarIdUsuario(Connection conexion) {
		Long nuevoId = null; // Usar Long para permitir null

		if (conexion != null) {
			try (Statement stmt = conexion.createStatement()) {
				// Consulta para obtener el máximo ID existente
				String query = "SELECT COALESCE(MAX(id_usuario), 0) FROM \"dlk_motos\".usuario";

				try (ResultSet rs = stmt.executeQuery(query)) {
					if (rs.next()) {
						nuevoId = rs.getLong(1) + 1; // Incrementa el máximo ID existente
					} else {
						nuevoId = 1L; // Asignar 1 si no hay resultados
					}
				}
			} catch (SQLException s) {
				System.err.println("Error al obtener el nuevo ID: " + s.getMessage());
			}
		} else {
			System.err.println("La conexión es nula. No se puede generar el ID.");
		}

		return nuevoId; // Devuelve el nuevo ID, que puede ser null
	}

	/**
	 * Genera un nuevo ID para el club.
	 * 
	 * @param conexion Conexión a la base de datos
	 * @return El nuevo ID generado o null si ocurre un error
	 */
	public static long GenerarIdClub(Connection conexion) {

		Long nuevoId = null;
		if (conexion != null) {

			try (Statement stmt = conexion.createStatement()) {

				String query = "SELECT COALESCE(MAX(id_club),0) FROM \"dlk_motos\".club";

				try (ResultSet rs = stmt.executeQuery(query)) {
					if (rs.next()) {
						nuevoId = rs.getLong(1) + 1;
					} else {
						nuevoId = 1L;
					}
				}
			} catch (SQLException s) {
				System.err.println("Error al obtener el nuevo ID: " + s.getMessage());
			}

		} else {
			System.err.println("La conexión es nula. No se puede generar el ID.");
		}

		return nuevoId;
	}

}
