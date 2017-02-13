package io.titulacion.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by Mauricio on 07/01/2017.
 */
@Entity
@Table(name = "Orden")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordNumero", unique = true, nullable = false)
    private Integer ordNumero;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ordFechaEmision", unique = false, nullable = false)
    private Date ordFechaEmision;
    @Column(name = "ordProblema", unique = false, nullable = false)
    private String ordProblema;
    @Column(name = "ordDiagnostico", unique = false, nullable = false)
    private String ordDiagnostico;
    @Column(name = "fkCliId", unique = false, nullable = false)
    private Integer fkCliId;
    @Column(name = "fkEmpId", unique = false, nullable = false)
    private Integer fkEmpId;
    @Column(name = "fkEstCodigo", unique = false, nullable = false)
    private Integer fkEstCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkOrdNumero")
    private List<detalleOrden> detalleorden;
}
