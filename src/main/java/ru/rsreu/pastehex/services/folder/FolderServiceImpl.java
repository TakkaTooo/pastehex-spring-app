package ru.rsreu.pastehex.services.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.models.paste.Folder;
import ru.rsreu.pastehex.models.user.User;
import ru.rsreu.pastehex.repositories.FolderRepository;

@Service
public class FolderServiceImpl implements FolderService{
    private final FolderRepository folderRepository;

    @Autowired
    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public void saveDefaultFolder(User user) {
        folderRepository.save(Folder.builder().title("Default").user(user).build());
    }
}
