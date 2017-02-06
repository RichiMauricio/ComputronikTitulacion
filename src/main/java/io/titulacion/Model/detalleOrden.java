package io.titulacion.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Mauricio on 02/01/2017.
 */
@Entity
@Table(name = "detalleOrden")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class detalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detNumero", unique = true, nullable = false)
    private Integer detNumero;
    @Column(name = "detPrecioTotal", unique = false, nullable = false)
    private Double detPrecioTotal;
    @Column(name = "fkOrdNumero", unique = false, nullable = false)
    private Integer fkOrdNumero;
    @Column(name = "fkServCodigo", unique = false, nullable = false)
    private Integer fkServCodigo;
}
