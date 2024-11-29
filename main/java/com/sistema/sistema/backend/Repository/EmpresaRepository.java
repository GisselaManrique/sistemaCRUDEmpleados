package com.sistema.sistema.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.sistema.backend.Entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa,Long>{
    
}
