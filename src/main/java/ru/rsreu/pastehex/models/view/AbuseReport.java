package ru.rsreu.pastehex.models.view;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "active_abuse_reports")
public class AbuseReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "view_id", nullable = false)
    private View view;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "full_name")
    private String fullName;
}
