 package servicios;

import dto.ClubDto;

public interface ClubInterfaz {
	
	public boolean altaClub(long id, String nombre, String email);
	
	public void compararClub(ClubDto clubDto, String email);

}
