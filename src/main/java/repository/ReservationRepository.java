package repository;

import entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByName(final String Name);
}
