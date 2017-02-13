package io.titulacion.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Mauricio on 30/12/2016.
 */
@Entity
@Table(name = "Perfil")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class perfiles {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "perCodigo", unique = true, nullable = false)
    private Integer perCodigo;
    @Column(name = "perPerfil", unique = true, nullable = false)
    private String perPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliPerfil")
    private List<cliente> cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpPerfil")
    private List<empleado> empleado;
}
