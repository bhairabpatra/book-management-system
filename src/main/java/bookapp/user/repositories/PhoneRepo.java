package bookapp.user.repositories;

import bookapp.user.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepo extends JpaRepository<Phone, Long> {
}
