package com.description.model;

import com.description.defined.Column;
import com.description.defined.Table;

/**
 * Created by 10113513 on 2016/06/03.
 */
@Table("user")
public class User {

    @Column("user_id")
    private int userId;
    @Column("user_name")
    private String userName;
    @Column("user_email")
    private String email;
    @Column("user_state")
    private String userState;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
}
