package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.ClubDto;

@Repository
public class ClubRepositorio {

	@Autowired
	private DataSource dataSource;

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
