package ru.rsreu.pastehex.models.paste;


import lombok.*;
import ru.rsreu.pastehex.models.settings.PasteSettings;
import ru.rsreu.pastehex.models.view.View;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pastes")
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "paste_settings_id", referencedColumnName = "id", nullable = false)
    private PasteSettings pasteSettings;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @OneToMany(mappedBy = "paste")
    private Set<View> views;
}
