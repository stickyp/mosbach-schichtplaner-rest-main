package mosbach.dhbw.de.schichtplaner.data.api;

public interface User {
    void setId(int id);
    int getId();
    String getName();
    void setName(String name);
    String getPasswordHash();
    void setPasswordHash(String passwordHash);
    String getRole();
    void setRole(String role);
    String getJwtToken();
    void setJwtToken(String jwtToken);
}
