package mosbach.dhbw.de.schichtplaner.util;

import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final long EXPIRATION_TIME = 864_000_00; // 1 day in milliseconds
    private static final Map<String, String> tokenStore = new HashMap<>();

    public String generateToken(String username) {
        // Generate a simple token by combining username and current timestamp
        String token = username + "_" + System.currentTimeMillis() + "_" + UserManagerImpl.getInstance().getUserByName(username);
        tokenStore.put(token, username);
        return token;
    }

    public long getExpiryTime() {
        return EXPIRATION_TIME;
    }

    public boolean validateToken(String token, String username) {
        // Check if the token exists in the store and matches the given username
        String storedUsername = tokenStore.get(token);
        return storedUsername != null && storedUsername.equals(username) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        // Extract username from the token based on the separator
        return token.split("_")[0];
    }

    public boolean isTokenExpired(String token) {
        // Extract the timestamp from the token and compare with the current time
        try {
            long tokenTimestamp = Long.parseLong(token.split("_")[1]);
            return (System.currentTimeMillis() - tokenTimestamp) > EXPIRATION_TIME;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }
}



/*package mosbach.dhbw.de.schichtplaner.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    private static final String SECRET_KEY = "my_secret_key";
    private static final long EXPIRATION_TIME = 864_000_00; // 1 day in milliseconds

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public long getExpiryTime() {
        return EXPIRATION_TIME; // Return expiration time in milliseconds
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
*/