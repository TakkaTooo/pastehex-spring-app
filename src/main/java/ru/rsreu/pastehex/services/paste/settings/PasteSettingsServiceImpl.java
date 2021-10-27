package ru.rsreu.pastehex.services.paste.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.models.paste.settings.Expiration;
import ru.rsreu.pastehex.models.paste.settings.Exposure;
import ru.rsreu.pastehex.models.paste.settings.PasteSettings;
import ru.rsreu.pastehex.models.paste.settings.ProgrammingLanguage;
import ru.rsreu.pastehex.repositories.ExpirationRepository;
import ru.rsreu.pastehex.repositories.ExposureRepository;
import ru.rsreu.pastehex.repositories.PasteSettingsRepository;
import ru.rsreu.pastehex.repositories.ProgrammingLanguageRepository;

@Service
public class PasteSettingsServiceImpl implements PasteSettingsService {

    private final PasteSettingsRepository pasteSettingsRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final ExposureRepository exposureRepository;
    private final ExpirationRepository expirationRepository;


    @Autowired
    public PasteSettingsServiceImpl(PasteSettingsRepository pasteSettingsRepository,
                                    ProgrammingLanguageRepository programmingLanguageRepository,
                                    ExposureRepository exposureRepository,
                                    ExpirationRepository expirationRepository) {
        this.pasteSettingsRepository = pasteSettingsRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.exposureRepository = exposureRepository;
        this.expirationRepository = expirationRepository;
    }

    @Override
    public PasteSettings saveDefaultPasteSettings() {
        ProgrammingLanguage defaultProgrammingLanguage = programmingLanguageRepository.getById(1L);
        Exposure defaultExposure = exposureRepository.getById(1L);
        Expiration defaultExpiration = expirationRepository.getById(1L);
        PasteSettings defaultPasteSettings = PasteSettings.builder()
                .programmingLanguage(defaultProgrammingLanguage)
                .exposure(defaultExposure)
                .expiration(defaultExpiration)
                .build();
        pasteSettingsRepository.save(defaultPasteSettings);
        return defaultPasteSettings;
    }
}
