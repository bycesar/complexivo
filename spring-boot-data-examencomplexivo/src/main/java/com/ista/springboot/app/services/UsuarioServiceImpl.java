package com.ista.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.springboot.app.models.Usuario;
import com.ista.springboot.app.repositories.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		if(usuarioDao.recuperarPorUsername(usuario.getUsername())==null) {
			
			return usuarioDao.createUsuario(usuario);
			
		}		
		
		return null;
		
	}

	@Override
	public List<Usuario> recuperarUsuario() {
		// TODO Auto-generated method stub
		return usuarioDao.getUsuarios();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.recuperarPorUsername(username);
	}

	@Override
	public Usuario iniciarSesion(String username, String contraseña) {
		// TODO Auto-generated method stub
		return usuarioDao.iniciarSesion(username, contraseña);
	}
	
	@Override
    public Usuario actualizar(Usuario usuario, long id) {

        return usuarioDao.actualizar(usuario, id);
    }

    @Override
    public void eliminar(long id) {

    	usuarioDao.eliminar(id);
    }
	
}
