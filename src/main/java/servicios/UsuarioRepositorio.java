package servicios;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dto.UsuarioDto;

@Repository
public class UsuarioRepositorio {

    @Autowired
    private DataSource dataSource;

    public UsuarioDto findByCorreo(String correo) {
        String sql = "SELECT * FROM \"dlk_motos\".usuario WHERE correo = ?";
        UsuarioDto usuario = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                usuario = new UsuarioDto();
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setContrasenia(resultSet.getString("contrasenia"));
                // Rellena otros campos según lo que necesites
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return usuario;
    }
}