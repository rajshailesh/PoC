package com.cdfi.group.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@Entity
@Table(name = "users_master")
@NamedQueries({
        @NamedQuery(name = "UsersMasterEntity.findAll", query = "SELECT u FROM UsersMasterEntity u ORDER BY u.login DESC"),
        @NamedQuery(name = "UsersMasterEntity.findByLoginAndPassword", query = "SELECT u FROM UsersMasterEntity u WHERE u.login = :login AND u.password = :password"),
        @NamedQuery(name = "UsersMasterEntity.countAll", query = "SELECT COUNT(u) FROM UsersMasterEntity u")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class UsersMasterEntity {
    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_ALL = "UsersMasterEntity.findAll";
    public static final String COUNT_ALL = "UsersMasterEntity.countAll";
    public static final String FIND_BY_LOGIN_PASSWORD = "UsersMasterEntity.findByLoginAndPassword";

    @Id
    private BigInteger id;
    @Column(name = "user_id")
    private String login;
    @Column(name = "passwordword")
    private byte[] password;
    @Column(name = "status")
    private String status;


// ======================================
    // =            Constructors            =
    // ======================================

    public UsersMasterEntity() {

    }

    public UsersMasterEntity(BigInteger id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.getBytes(StandardCharsets.UTF_8);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersMasterEntity user = (UsersMasterEntity) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                 '}';
    }
}
