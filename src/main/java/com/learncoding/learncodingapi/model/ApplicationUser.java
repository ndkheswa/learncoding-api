package com.learncoding.learncodingapi.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "users_table")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 6044598961665546255L;

    public ApplicationUser() { }

    @Id
    @SequenceGenerator(name = "seq-gen", sequenceName = "api_seq", initialValue = 20583748, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq-gen")
    private Long id;

    @NotNull
    private String fullName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean isAccountNotExpired;

    @NotNull
    private boolean isAccountNonLocked;

    @NotNull
    private boolean isCredentialsNonExpired;

    @NotNull
    private  boolean isEnabled;
}
