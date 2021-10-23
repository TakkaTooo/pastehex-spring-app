package ru.rsreu.pastehex.models.view;

import lombok.*;
import ru.rsreu.pastehex.models.paste.Paste;
import ru.rsreu.pastehex.models.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "views")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "paste_id", nullable = false)
    private Paste paste;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @OneToOne(mappedBy = "view")
    private AbuseReport abuseReport;
}
