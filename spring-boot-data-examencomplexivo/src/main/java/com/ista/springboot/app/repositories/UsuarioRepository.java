package com.ista.springboot.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.springboot.app.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);
	Usuario findByContraseña(String contraseña);
	Usuario findByUsernameAndContraseña(String username, String contraseña);
	Usuario findByUserId(long id);
}
