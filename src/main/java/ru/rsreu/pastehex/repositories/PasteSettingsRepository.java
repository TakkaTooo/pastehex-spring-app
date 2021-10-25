package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.paste.settings.PasteSettings;

public interface PasteSettingsRepository extends JpaRepository<PasteSettings, Long> {
}
