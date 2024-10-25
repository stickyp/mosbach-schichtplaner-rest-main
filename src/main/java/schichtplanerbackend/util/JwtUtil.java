package schichtplanerbackend.util;


import java.util.Base64;

public class JwtUtil {

    private static final String SECRET_KEY = "mySecretKey";

    public static String generateToken(String username) {
        // Generate a simple token using Base64 encoding with username and expiration time
        long expirationTime = System.currentTimeMillis() + 1000 * 60 * 60 * 10; // 10 hours
        String token = username + ":" + expirationTime + ":" + SECRET_KEY;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    public static String extractUsername(String token) {
        String decodedToken = new String(Base64.getDecoder().decode(token));
        String[] parts = decodedToken.split(":");
        return parts[0];
    }

    public static boolean isTokenValid(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] parts = decodedToken.split(":");
            long expirationTime = Long.parseLong(parts[1]);
            String secretKey = parts[2];

            // Check if token has expired or secret key is incorrect
            return expirationTime > System.currentTimeMillis() && SECRET_KEY.equals(secretKey);
        } catch (Exception e) {
            return false;
        }
    }
}
