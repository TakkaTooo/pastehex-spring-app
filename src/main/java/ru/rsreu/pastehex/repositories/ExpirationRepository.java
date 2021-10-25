package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.paste.settings.Expiration;

public interface ExpirationRepository extends JpaRepository<Expiration, Long> {
}
