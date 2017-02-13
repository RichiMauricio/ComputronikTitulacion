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
@Table(name = "Estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class estado {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "estCodigo", unique = true, nullable = false)
    private Integer estCodigo;
    @Column(name = "estDescripcion", unique = true, nullable = false)
    private String estDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstCodigo")
    private List<orden> orden;
}
