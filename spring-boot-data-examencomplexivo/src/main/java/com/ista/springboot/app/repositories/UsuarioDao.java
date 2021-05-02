package com.ista.springboot.app.repositories;

import java.util.List;

import com.ista.springboot.app.models.Usuario;

public interface UsuarioDao {
	Usuario createUsuario(Usuario usuario);
	
	Usuario recuperarPorUsername(String username);
	
	List<Usuario> getUsuarios();
	
	Usuario iniciarSesion(String username, String contraseña);
	
	Usuario actualizar(Usuario usuario, long id);

    void eliminar(long id);
	
}
