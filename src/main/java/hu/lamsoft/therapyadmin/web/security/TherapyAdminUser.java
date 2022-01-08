package hu.lamsoft.therapyadmin.web.security;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserDetails implementation for Spring Security implementation.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TherapyAdminUser implements UserDetails {

    public static final GrantedAuthority THERAPIST_AUTHORITY = new Therapist();
    private static final long serialVersionUID = -1086336440286754321L;

    private String username;
    private String password;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(THERAPIST_AUTHORITY);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    /**
     * GrantedAuthority implementation for Therapist Authority.
     */
    public static class Therapist implements GrantedAuthority {

        private static final long serialVersionUID = -4518147886496887773L;

        @Override
        public String getAuthority() {
            return "THERAPIST";
        }
        
    }
    
}
