package mosbach.dhbw.de.schichtplaner.data.impl;

import mosbach.dhbw.de.schichtplaner.data.api.User;

public class UserImpl implements User {

    private int id;
    private String name;
    private String passwordHash;
    private String role;
    private String jwtToken;

    public UserImpl(int id, String name, String passwordHash, String role, String jwtToken) {
        this.id = id;
        this.name = name;
        this.passwordHash = passwordHash;
        this.role = role;
        this.jwtToken = jwtToken;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPasswordHash() {
        return passwordHash;
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getJwtToken() {
        return jwtToken;
    }

    @Override
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
