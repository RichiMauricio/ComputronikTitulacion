package io.titulacion.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Mauricio on 02/01/2017.
 */
@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId", unique = true, nullable = false)
    private Integer empId;
    @Column(name = "empCedula", unique = true, nullable = false)
    private String empCedula;
    @Column(name = "empNombres", unique = false, nullable = false)
    private String empNombres;
    @Column(name = "empDireccion", unique = false, nullable = false)
    private String empDireccion;
    @Column(name = "empEmail", unique = true, nullable = false)
    private String empEmail;
    @Column(name = "empTelefono", unique = false, nullable = true)
    private String empTelefono;
    @Column(name = "empCelular", unique = false, nullable = true)
    private String empCelular;
    @Column(name = "fkEmpPerfil", unique = false, nullable = true)
    private Integer fkEmpPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpId")
    private List<usuario> cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpId")
    private List<orden> orden;
}
