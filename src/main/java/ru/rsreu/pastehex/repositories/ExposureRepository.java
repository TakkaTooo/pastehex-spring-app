package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.paste.settings.Exposure;

public interface ExposureRepository extends JpaRepository<Exposure, Long> {
}
