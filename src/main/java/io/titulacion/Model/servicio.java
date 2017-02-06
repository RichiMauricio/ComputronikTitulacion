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
@Table(name = "servicio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "servCodigo", unique = true, nullable = false)
    private Integer servCodigo;
    @Column(name = "servDescripcion", unique = false, nullable = false)
    private String servDescripcion;
    @Column(name = "servPrecio", unique = false, nullable = false)
    private Double servPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkServCodigo")
    private List<detalleOrden> detalleOrden;
}
