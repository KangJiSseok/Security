package example.security.dto;

import example.security.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class CustomUserDetails implements UserDetails {

    private UserEntity userEntity;

    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                //return userEntity.getRole();
                //getAuthority인증은 "ROLE_xxx" 로 시작함.
                log.info("userRole = {}", userEntity.getRole());
                return userEntity.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        log.info("userPassword = {}", userEntity.getPassword());
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("userName = {}", userEntity.getUsername());
        return userEntity.getUsername();
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
