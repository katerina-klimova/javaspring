package app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {

    @Id
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String FIO;
    @Column(name = "E-mail")
    private String Email;
    @Column
    private boolean activity;
}