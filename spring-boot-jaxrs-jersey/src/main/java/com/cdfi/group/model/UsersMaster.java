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
        @NamedQuery(name = "UsersMaster.findAll", query = "SELECT u FROM UsersMaster u ORDER BY u.login DESC"),
        @NamedQuery(name = "UsersMaster.findByLoginAndPassword", query = "SELECT u FROM UsersMaster u WHERE u.login = :login AND u.password = :password"),
        @NamedQuery(name = "UsersMaster.countAll", query = "SELECT COUNT(u) FROM UsersMaster u")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersMaster {
    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_ALL = "UsersMaster.findAll";
    public static final String COUNT_ALL = "UsersMaster.countAll";
    public static final String FIND_BY_LOGIN_PASSWORD = "UsersMaster.findByLoginAndPassword";

    @Id
    private BigInteger id;
    @Column(name = "user_id")
    private String login;
    @Column(name = "passwordword")
    private byte[] password;

    // ======================================
    // =            Constructors            =
    // ======================================

    public UsersMaster() {

    }

    public UsersMaster(BigInteger id, String login, String password) {
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

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersMaster user = (UsersMaster) o;
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
