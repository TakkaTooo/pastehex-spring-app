package ru.rsreu.pastehex.models.settings;

import lombok.*;
import ru.rsreu.pastehex.models.paste.Paste;
import ru.rsreu.pastehex.models.user.User;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "paste_settings")
public class PasteSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programming_language_id", nullable = false)
    private ProgrammingLanguage programmingLanguage;

    @ManyToOne
    @JoinColumn(name = "expiration_id", nullable = false)
    private Expiration expiration;

    @ManyToOne
    @JoinColumn(name = "exposure_id", nullable = false)
    private Exposure exposure;

    @OneToOne(mappedBy = "pasteSettings")
    private Paste paste;

    @OneToOne(mappedBy = "defaultPasteSettings")
    private User user;
}
