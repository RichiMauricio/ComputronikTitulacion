package io.titulacion.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by Mauricio on 07/01/2017.
 */
@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliId", unique = true, nullable = false)
    private Integer cliId;
    @Column(name = "cliCedula", unique = true, nullable = false)
    private String cliCedula;
    @Column(name = "cliNombres", unique = false, nullable = false)
    private String cliNombres;
    @Column(name = "cliDireccion", unique = false, nullable = false)
    private String cliDireccion;
    @Column(name = "cliEmail", unique = false, nullable = false)
    private String cliEmail;
    @Column(name = "cliTelefono", unique = false, nullable = true)
    private String cliTelefono;
    @Column(name = "cliCelular", unique = false, nullable = true)
    private String cliCelular;
    @Column(name = "fkCliPerfil", unique = false, nullable = true)
    private Integer fkCliPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliId")
    private List<usuario> cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliId")
    private List<orden> orden;
}
