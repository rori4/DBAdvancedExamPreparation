package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.entities.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long> {
    Photographer findByFirstNameAndLastName(String firstName, String lastName);
}