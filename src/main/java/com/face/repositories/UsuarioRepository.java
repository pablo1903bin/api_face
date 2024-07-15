package com.face.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.face.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}
