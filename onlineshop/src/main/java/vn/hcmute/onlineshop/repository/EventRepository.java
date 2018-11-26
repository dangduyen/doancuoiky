package vn.hcmute.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hcmute.onlineshop.entity.Event;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {
    Optional<Event> findEventById(long id);
}
