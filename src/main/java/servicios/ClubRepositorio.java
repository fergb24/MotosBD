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
		
		String sql = "INSERT INTO \"public\".club (id, nombre, email) VALUES (?, ?, ?) ";
		ClubDto club = null;
		
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setLong(1, id);
			ps.setString(2, nombre);
			ps.setString(3, email);
			ps.executeUpdate();
			
			ResultSet rs;
			
			/*
			 * if (rs.next()) { club = new ClubDto(); club.setId(rs.getLong("id"));
			 * club.setNombre(rs.getString("nombre")); club.setEmail(rs.getString("email"));
			 */
				
			//}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club;
	}

}
