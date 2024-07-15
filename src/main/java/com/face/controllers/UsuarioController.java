package com.face.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.face.requestDtos.UsuarioRequestDto;
import com.face.services.UsuarioService;

@RestController
@RequestMapping("/authentication")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<String> signIn(@RequestBody UsuarioRequestDto user) {
		boolean saved = usuarioService.saveUser(user);

		if (saved) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al crear el usuario");
		}
	}
}
