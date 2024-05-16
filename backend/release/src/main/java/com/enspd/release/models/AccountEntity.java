package com.enspd.release.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "AccountTable")
public class AccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Integer id;

   
    @Column(name="password_account",nullable = false)
    private String password;

    @Column(name="name_of_account_user",nullable = false)
    private  String name;

    
    @Column(name="username_account",nullable = false)
    private  String username;

    @Column(name="surname_of_account_user")
    private String surname;

    @Column(name="date_of_account_creation")
    private Date createdOn;


    @OneToMany(mappedBy ="accountEntity")
    Set<CommentairesEntity> commentaires;
}
