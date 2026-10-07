package com.SpringBackend.spring_back.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity //этот класс сущность привязання к таблике
@Table(name = "users") // имя таблицы
public class Users {
    @Id //помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) //значение генерируется бд
    private long id;

    // настройка колонки в бд на то что у нас все неймы уникальны и не пустые
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public long getId() {return id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
