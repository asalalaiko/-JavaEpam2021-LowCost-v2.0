package by.asalalaiko.domain;


import org.springframework.security.core.GrantedAuthority;

public enum UsersRole implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
