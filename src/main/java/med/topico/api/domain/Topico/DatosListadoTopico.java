package med.topico.api.domain.Topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String autor, String curso, status estado) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso(), topico.getEstado());
    }
}


