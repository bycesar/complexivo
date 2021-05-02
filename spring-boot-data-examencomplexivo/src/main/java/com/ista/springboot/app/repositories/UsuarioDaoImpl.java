package com.ista.springboot.app.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ista.springboot.app.models.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
				
		Usuario usuarioCreado = usuarioRepository.save(usuario);
		
		return usuarioCreado;
	}

	@Override
	public Usuario recuperarPorUsername(String username) {
		
		Usuario usuario = usuarioRepository.findByUsername(username);

		return usuario;
	}

	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario iniciarSesion(String username, String contraseña) {
		
		Usuario usuario = usuarioRepository.findByUsernameAndContraseña(username,contraseña);
		
		return usuario;
	}
	
	@Override
    public Usuario actualizar(Usuario usuario, long id) {
        usuarioRepository.findByUserId(id);
        if(usuarioRepository.findByUserId(id) != null){
            usuario.setUserid(id);
            return usuarioRepository.save(usuario);
        }else{
            usuario.setNombreCompleto(usuario.getNombreCompleto());
            usuario.setUsername(usuario.getUsername());
            usuario.setContraseña(usuario.getContraseña());
            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public void eliminar(long id) {
        usuarioRepository.deleteById(id);
    }

}
