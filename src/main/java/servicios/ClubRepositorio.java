package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.ClubDto;

/**
 * Clase para poder acceder y modificar los datos de la BBDD,
 * concretamente los existentes en la tabla club
 * RPG-071124
 */
@Repository
public class ClubRepositorio {

	@Autowired
	private DataSource dataSource;

	/**
	 * Metodo mediante el cual el usuario podra introducir los valores que quiera en los 
	 * campos de la tabla club para dar de esta forma la alta de un nuevo club con dichos valores
	 * RPG-071124
	 * @param id
	 * @param nombre
	 * @param email
	 * @return
	 */
	public ClubDto introducirDatos(long id, String nombre, String email) {

		String sql = "INSERT INTO \"dlk_motos\".club (id, nombre, email) VALUES (?, ?, ?) ";
		ClubDto club = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setLong(1, id);
			ps.setString(2, nombre);
			ps.setString(3, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club;
	}

	/**
	 * Se introduce el email de un club para darlo de baja. Este metodo busca y compara el email
	 * previamente introducido con los existentes en la BBDD para ver si estos coinciden
	 * RPG-071124
	 * @param email
	 * @return
	 */
	public ClubDto encontrarCorreo(String email) {
		String sql = "SELECT * FROM \"dlk_motos\".club WHERE email = ?";
		ClubDto club = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				club = new ClubDto();
				club.setEmail(resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club;
	}

	/**
	 * Metodo el cual se permite que un club se de de baja en nuestra aplicacion
	 * RPG-071124
	 * @param email
	 */
	public void eliminarClub(String email) {

		String sql = "DELETE FROM \"dlk_motos\".club WHERE email = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, email);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Club con email " + email + " eliminado correctamente.");
			} else {
				System.out.println("No se encontró ningún club con el email " + email + ".");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
