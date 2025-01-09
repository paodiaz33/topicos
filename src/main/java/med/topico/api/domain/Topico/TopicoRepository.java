package med.topico.api.domain.Topico;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico>  findByEstado(status estado, Pageable paginacion);

}
