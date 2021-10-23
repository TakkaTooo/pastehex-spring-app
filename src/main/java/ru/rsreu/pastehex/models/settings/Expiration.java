package ru.rsreu.pastehex.models.settings;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "expirations")
public class Expiration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "removal_time")
    private Long secondsRemovalTime;

    @OneToMany(mappedBy = "expiration")
    private Set<PasteSettings> pasteSettingsSet;
}
