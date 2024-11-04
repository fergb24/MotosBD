package servicios;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dto.UsuarioDto;

/**
 * Repositorio para acceder a los datos de usuario en la base de datos. Esta
 * clase realiza operaciones de acceso a datos (DAO) directamente mediante SQL.
 * 
 * @author nrojlla 31102024
 */
@Repository
public class UsuarioRepositorio {

	// Inyección de DataSource que permite obtener conexiones a la base de datos
	@Autowired
	private DataSource dataSource;

	/**
	 * Método que busca un usuario en la base de datos por su correo electrónico.
	 * Este método ejecuta una consulta SQL para obtener la información del usuario
	 * cuyo correo coincide con el proporcionado.
	 * 
	 * @param correo Dirección de correo electrónico del usuario a buscar.
	 * @return `UsuarioDto` con los datos del usuario si se encuentra, o `null` si
	 *         no se encuentra el usuario.
	 */
	public UsuarioDto findByCorreo(String correo) {
		String sql = "SELECT * FROM \"dlk_motos\".usuario WHERE correo_usuario = ?";
		UsuarioDto usuario = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, correo);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				usuario = new UsuarioDto();
				usuario.setCorreo(resultSet.getString("correo_usuario"));
				usuario.setContrasenia(resultSet.getString("contra_usuario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
