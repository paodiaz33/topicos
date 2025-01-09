package med.topico.api.domain.Topico;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private String autor;

    private String curso;
    @Enumerated(EnumType.STRING)
    private status estado;


    public Topico(DatosRegistroTopico datosRegistroMedico) {
        this.titulo = datosRegistroMedico.titulo();
        this.mensaje = datosRegistroMedico.mensaje();
        this.fechaCreacion = Date.valueOf(datosRegistroMedico.fecha_creacion());
        this.autor = datosRegistroMedico.autor();
        this.curso = datosRegistroMedico.curso();
        this.estado = datosRegistroMedico.estado();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.autor = datosActualizarTopico.autor();
    }

    public void desactivarTopico() {
        this.estado = status.INACTIVO;
    }
}
