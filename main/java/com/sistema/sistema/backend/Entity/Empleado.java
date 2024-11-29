package com.sistema.sistema.backend.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempleado;
    @Column(name = "nomEmp",nullable = false,length = 30)
    private String nomEmp;
    @Column(name = "apeEmp",nullable = false,length = 30)
    private String apeEmp;
    @Column(name = "edadEmp",nullable = false,length = 2)
    private Integer edadEmp;
    @Column(name = "proEmp",nullable = false,length = 30)
    private String proEmp;
    @Column(name = "areaEmp",nullable = false,length = 45)
    private String areaEmp;
    @Column(name="pagoEmp")
    private Boolean pagoEmp;
    @Column(name = "fechacreacionEmp",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacionEmp=new Date();

    @ManyToOne
    @JoinColumn(name = "idempresa",nullable = false)
    private Empresa empresa;

}
