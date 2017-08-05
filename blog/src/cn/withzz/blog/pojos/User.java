package cn.withzz.blog.pojos;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by shmily_zz on 2017/3/22.
 */
@Entity(name="user")
public class User implements Serializable{
    @Id
    private String username;
    private String password;
    private String nickname;
    private String other;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash( username );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof User ) ) {
            return false;
        }
        User user = (User) o;
        return Objects.equals( username, user.username );
    }
}
