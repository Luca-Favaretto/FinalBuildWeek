package team3.FinalBuildWeek.auth.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import team3.FinalBuildWeek.enums.Role;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@JsonIgnoreProperties({"password", "credentialsNonExpired", "accountNonExpired", "authorities",  "accountNonLocked", "enabled"})
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    @Enumerated (EnumType.STRING)
    private Set<Role> roles=new HashSet<>();

    public User(String name, String surname, String username,String password, String email, String avatar) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;

        this.roles.add(Role.USER);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(el->new SimpleGrantedAuthority(el.name())).toList();
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
