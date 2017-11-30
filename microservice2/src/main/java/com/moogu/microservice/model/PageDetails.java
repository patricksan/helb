package com.moogu.microservice.model;

import java.time.LocalDate;
import java.util.List;

public class PageDetails {

    private List<User> users;
    private LocalDate generated;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public LocalDate getGenerated() {
        return generated;
    }

    public void setGenerated(LocalDate generated) {
        this.generated = generated;
    }

    @Override
    public String toString() {
        return "PageDetails{" +
                "users=" + users +
                ", generated=" + generated +
                '}';
    }
}
