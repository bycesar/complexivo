package com.ista.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.app.auth.GenerarToken;
import com.ista.springboot.app.models.Usuario;
import com.ista.springboot.app.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listarUsuarios")
	public List<Usuario> getUsuarios(){
		return usuarioService.recuperarUsuario();
		
	}
	
	@GetMapping("/crearUsuario")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.agregarUsuario(usuario);
	}
	
	@GetMapping("/login")
	public Usuario login(@RequestParam("username") String username,@RequestParam("contraseña") String constraseña){
		
		Usuario usuario= usuarioService.iniciarSesion(username, constraseña);
		if(usuario!=null) {
			
			usuario.setToken(GenerarToken.getJwtToken(username));
			return usuario;
		}
		
		return new Usuario();
		
	}
	
	@GetMapping("/login/{username}/{contrasena}")
    public Usuario IniciarSesion(@PathVariable String username,@PathVariable String contrasena){

        Usuario usuario = usuarioService.iniciarSesion(username, contrasena);

        if(usuario != null){

            usuario.setToken(GenerarToken.getJwtToken(username));
            return usuario;
        }

    return new Usuario();
    }
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.agregarUsuario(usuario);
    }

    @PutMapping("/usuario/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        // usuario.setToken(GenerarToken.getJwtToken(usuario.getUsername()));
        return usuarioService.actualizar(usuario, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable long id){
        usuarioService.eliminar(id);
    }
}
