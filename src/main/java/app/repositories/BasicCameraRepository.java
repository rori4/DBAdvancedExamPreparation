package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.entities.BasicCamera;

@Repository
public interface BasicCameraRepository extends JpaRepository<BasicCamera,Long> {


}