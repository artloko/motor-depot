package model.entity;

import javax.persistence.*;
import java.io.Serializable;

import static model.entity.User.tableName;

@Entity
@Table(name = tableName)
public class User implements Serializable {


    public static final String tableName = "user";
    private static final long serialVersionUID = 1;
    /**
     * login of user
     */
    @Id
    private String login;
    /**
     * password of user
     */
    @Basic(fetch = FetchType.LAZY)
    private String password;
    /**
     * type of user
     */
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        switch (type) {
            case "admin":
                return UserType.ADMIN;
            case "client":
                return UserType.CLIENT;
            case "guest":
                return UserType.GUEST;
            default:
                return UserType.GUEST;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return type;
    }

    public enum UserType {
        GUEST,
        CLIENT,
        ADMIN
    }
}
