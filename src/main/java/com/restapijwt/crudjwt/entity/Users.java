package com.restapijwt.crudjwt.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false,length = 50)
    private String username;

    @Column(unique = true, nullable = false,length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String firstname;

    @Column(nullable = false,length = 100)
    private String lastname;

    @Column(unique = true, nullable = false,length = 100)
    private String address;

    @Column(nullable = false,length = 100)
    private String token;

    @Column(nullable = false,length = 100)
    private String refreshToken;
    @Column(nullable = false,length =255)
    private String password;

    private Role role;

    @CreationTimestamp()
    @Column(updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp()
    @Column(updatable = true)
    private LocalDateTime modified;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
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
