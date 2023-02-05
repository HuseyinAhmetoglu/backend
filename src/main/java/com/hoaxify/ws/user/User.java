package com.hoaxify.ws.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.ws.shared.Views;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Entity
@Table(name="userss")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private long id;
    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min = 5, max = 255)
    @UniqeUsername(message = "{hoaxify.constraint.username.UniqeUsername.message}")
    //@Column(unique = true)
    @JsonView(Views.Base.class) //gösterilecek alanaları işaretledik
    private String username;
    @NotNull(message = "{hoaxify.constraint.displayname.NotNull.message}")
    @Size(min = 5, max = 255)
    @JsonView(Views.Base.class)
    private String displayname;
    @NotNull(message = "{hoaxify.constraint.password.NotNull.message}")
    @Size(min = 8, max = 255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hoaxify.constraint.password.Pattern.message}")
    @JsonView(Views.Sensetive.class)
    private String password;
    @JsonView(Views.Base.class)
    private String image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_user");
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
