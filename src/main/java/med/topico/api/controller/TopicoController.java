package med.topico.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.topico.api.domain.Topico.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository TopicoRepository;

     @PostMapping
     public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                 UriComponentsBuilder uriComponentsBuilder) {
         Topico topico = TopicoRepository.save(new Topico(datosRegistroTopico));
         DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), 
         topico.getAutor(), topico.getCurso(), topico.getEstado());

        URI url = uriComponentsBuilder.path("/Topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

     }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return  ResponseEntity.ok(TopicoRepository.findByEstado(status.ACTIVO, paginacion).map(DatosListadoTopico::new));
      
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico Topico = TopicoRepository.getReferenceById(datosActualizarTopico.id());
        Topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(Topico.getId(), Topico.getTitulo(), Topico.getMensaje(), Topico.getAutor(), Topico.getCurso(), Topico.getEstado()));
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico Topico = TopicoRepository.getReferenceById(id);
        Topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico Topico = TopicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(Topico.getId(), Topico.getTitulo(), Topico.getMensaje(), Topico.getAutor(), Topico.getCurso(), Topico.getEstado());
        return ResponseEntity.ok(datosTopico);
    }

}
