package github.nkor.services;

import github.nkor.models.Role;
import github.nkor.models.User;
import github.nkor.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userWithPermissions = userRepository.findUserWithPermissions(email);

        if (userWithPermissions == null) {
            throw new UsernameNotFoundException("User with email '" + email + "' not foud");
        }

        return new UserDetailsWithUserEntity(userWithPermissions);
    }

    public static final class UserDetailsWithUserEntity implements UserDetails, Serializable {
        private User user;
        private Collection<? extends GrantedAuthority> grantedAuthorities;

        private UserDetailsWithUserEntity(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {

            // if grantedAuthorities is cached
            // return it
            if (grantedAuthorities != null) {
                return grantedAuthorities;
            }

            Set<Role> roles = user.getRoles();

            if (roles == null) {
                grantedAuthorities = Collections.emptySet();
            } else {
                // flat permissions and map permissions to SimpleGrantedAuthority
                grantedAuthorities = roles.stream()
                        .filter(r -> r.getPermissions() != null)
                        .flatMap(r -> r.getPermissions().stream())
                        .map(p -> new SimpleGrantedAuthority(p.getName()))
                        .collect(Collectors.toSet());
            }

            return grantedAuthorities;
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return !user.isLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    } // end UserDetailsWithUserEntity class
}
