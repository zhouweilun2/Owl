package com.web.web_spingboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private Integer id;
    private String user_name;
    private String user_number;
    private String passwords;
    private String user_type;
    private Integer energy;

    public Integer getId() {
        return id;
    }

    public Integer getEnergy() {
        return energy;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPasswords() {
        return passwords;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    public String getUser_number() {
        return user_number;
    }
    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }
}
