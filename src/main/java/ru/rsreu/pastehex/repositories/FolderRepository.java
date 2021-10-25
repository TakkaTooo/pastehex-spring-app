package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.paste.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
