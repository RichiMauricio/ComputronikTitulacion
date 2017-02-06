package io.titulacion.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Mauricio on 07/01/2017.
 */
@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usrId", unique = true, nullable = false)
    private Integer usrId;
    @Column(name = "usrEmail", unique = false, nullable = false)
    private String usrEmail;
    @Column(name = "fkEmpId", unique = false, nullable = true)
    private Integer fkEmpId;
    @Column(name = "fkCliId", unique = false, nullable = true)
    private Integer fkCliId;
}
