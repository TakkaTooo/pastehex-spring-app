package ru.rsreu.pastehex.models.user;

import lombok.*;
import ru.rsreu.pastehex.models.paste.Folder;
import ru.rsreu.pastehex.models.settings.PasteSettings;
import ru.rsreu.pastehex.models.view.View;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @OneToOne
    @JoinColumn(name = "default_paste_settings", referencedColumnName = "id", nullable = false)
    private PasteSettings defaultPasteSettings;

    @OneToMany(mappedBy = "user")
    private Set<Folder> folders;

    @OneToMany(mappedBy = "user")
    private Set<View> views;
}
