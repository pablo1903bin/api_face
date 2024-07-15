package com.face.servicesImp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.entities.UsuarioEntity;
import com.face.repositories.UsuarioRepository;
import com.face.requestDtos.UsuarioRequestDto;

@Service
public class UsuarioService implements com.face.services.UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Boolean saveUser(UsuarioRequestDto user) {
		try {
			UsuarioEntity usuarioModel = new UsuarioEntity();
			usuarioModel.setNombreUsuario(user.getNombreUsuario());
			usuarioModel.setContraseña(user.getContraseña());
			usuarioModel.setFechaCreacion(LocalDateTime.now());

			// Guardar la entidad y recibir el resultado
			UsuarioEntity savedUser = usuarioRepository.save(usuarioModel);

			// Verificar si se guardó correctamente
			if (savedUser != null && savedUser.getId() != null) {
				return true; // Indica que se guardó correctamente
			} else {
				return false; // Indica que hubo algún problema al guardar
			}
		} catch (Exception e) {
			// Manejo de excepciones si ocurre algún error al guardar
			e.printStackTrace(); // Considera un manejo más adecuado de las excepciones
			return false;
		}
	}
}
