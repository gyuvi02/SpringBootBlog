package org.gyula.springbootblog.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "roles" )
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    @ManyToMany( mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    private Role(){} //

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }

}
