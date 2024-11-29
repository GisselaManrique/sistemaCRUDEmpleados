package com.sistema.sistema.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema.backend.Entity.Empleado;
import com.sistema.sistema.backend.Service.EmpleadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    @GetMapping("/listar")
    public List<Empleado>mostrarEmpleado(){
        System.out.println("Obteniendo todos los datos desde el controlador");
        return empleadoService.mostrarEmpleado();
    }
     @PostMapping("/guardar")
        public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
            System.out.println("Guardando todos los datos desde el controlador");
            Empleado guardarEmpleado = empleadoService.guardarEmpleado(empleado);
        return new ResponseEntity<>(guardarEmpleado, HttpStatus.CREATED);
        }
        @GetMapping("/listar/{id}")
        public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
            return empleadoService.obtenerEmpleado(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Long id) {
        try {
            empleadoService.eliminarEmpleado(id);
            return new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
        }

    @PutMapping("/editar/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizarEmpleado(id, empleado);
    }


       


}
