package com.sistema.sistema.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sistema.backend.Entity.Empleado;
import com.sistema.sistema.backend.Repository.EmpleadoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> mostrarEmpleado(){
      return empleadoRepository.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado){
      return empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Long id){
       empleadoRepository.deleteById(id);

    }

    public Optional<Empleado>obtenerEmpleado(Long id){
      return empleadoRepository.findById(id);
    }

    public Empleado actualizarEmpleado(Long id, Empleado empleadoDetalle) {
      Empleado empleado = empleadoRepository.findById(id).orElseThrow(()->
         new EntityNotFoundException("Empleado con ID " + id + " no encontrado"));

    System.out.println("Actualizando empleado: " + empleadoDetalle);

      empleado.setNomEmp(empleadoDetalle.getNomEmp());
      empleado.setApeEmp(empleadoDetalle.getApeEmp());
      empleado.setEdadEmp(empleadoDetalle.getEdadEmp());
      empleado.setProEmp(empleadoDetalle.getProEmp());
      empleado.setAreaEmp(empleadoDetalle.getAreaEmp());
      empleado.setPagoEmp(empleadoDetalle.getPagoEmp());
      return empleadoRepository.save(empleado);
  }

}
