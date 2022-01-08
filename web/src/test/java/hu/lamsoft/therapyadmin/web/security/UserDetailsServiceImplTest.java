package hu.lamsoft.therapyadmin.web.security;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import hu.lamsoft.therapyadmin.web.persistence.UserRepository;
import hu.lamsoft.therapyadmin.web.persistence.entity.User;

public class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl underTest;
    
    private UserRepository userRepository;
    
    @BeforeEach
    public void init() {
        userRepository = Mockito.mock(UserRepository.class);
        underTest = new UserDetailsServiceImpl(userRepository);
    }
    
    @Test
    public void testLoadUserByUsernameShouldReturnUserWhenTheUsernameExists() {
        // Given
        String username = "username";
        String password = "password";
        TherapyAdminUser expected = new TherapyAdminUser(username, password);
        User user = Mockito.mock(User.class);
        Mockito.when(user.getName()).thenReturn(username);
        Mockito.when(user.getPassword()).thenReturn(password);
        Mockito.when(userRepository.findByName(username)).thenReturn(Optional.of(user));
        
        // When
        UserDetails actual = underTest.loadUserByUsername(username);
        
        // Then
        Assertions.assertEquals(expected, actual);
        Mockito.verify(user).getName();
        Mockito.verify(user).getPassword();
        Mockito.verify(userRepository).findByName(username);
        Mockito.verifyNoMoreInteractions(userRepository, user);
    }
    
    @Test
    public void testLoadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenTheUsernameDoesNotExist() {
        // Given
        String username = "username";
        Mockito.when(userRepository.findByName(username)).thenReturn(Optional.empty());
        
        // When
        Assertions.assertThrows(UsernameNotFoundException.class, () -> underTest.loadUserByUsername(username));
        
        // Then
        Mockito.verify(userRepository).findByName(username);
        Mockito.verifyNoMoreInteractions(userRepository);
    }
    
}
