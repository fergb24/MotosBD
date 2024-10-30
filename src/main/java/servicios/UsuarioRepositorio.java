package servicios;

import dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioDto, Long> {
    UsuarioDto findByCorreo(String correo);
}
