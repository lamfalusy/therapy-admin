package hu.lamsoft.therapyadmin.web.security;

import hu.lamsoft.therapyadmin.web.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * UserDetailsService implementation for defining the authentication logic.
 */
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                .map((user) -> new TherapyAdminUser(user.getName(), user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("%s is not found".formatted(username)));
    }

}
