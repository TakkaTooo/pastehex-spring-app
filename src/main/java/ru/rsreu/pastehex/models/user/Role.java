package ru.rsreu.pastehex.models.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    String title;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return this.title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        return this.id.equals(((Role) obj).id);
    }
}
