import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public record User(String name, boolean active, LocalDateTime lastLogin) {

    public User {
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(lastLogin, "lastLogin cannot be null");
    }

    public String getYmd() {
        // DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss.SSSSSSSSS");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return lastLogin.format(formatter);
    }

    public String getYmd2() {
        return lastLogin.toString().replace('T', ' ');
    }
}