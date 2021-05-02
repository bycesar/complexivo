package com.ista.springboot.app.services;

import java.util.List;

import com.ista.springboot.app.models.Usuario;

public interface UsuarioService {

	Usuario agregarUsuario(Usuario usuario);
	
	List<Usuario> recuperarUsuario();
	
	Usuario buscarPorUsername(String username);
	
	Usuario iniciarSesion(String username, String contraseña);
	
	Usuario actualizar(Usuario usuario, long id);
	
    void eliminar(long id);
}
