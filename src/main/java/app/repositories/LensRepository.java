package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.entities.Lens;

import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens,Long> {

    List<Lens> findByIdIn(Iterable<Long> id);
}