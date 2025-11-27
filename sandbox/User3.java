import java.time.LocalDateTime;
import java.util.Optional;

public record User3(String username,
        boolean active,
        Optional<String> group,
        LocalDateTime lastLogin) {

    public User3 {
        // Objects.requireNonNull(username, "username cannot be null");
        Objects.requireNonNull(group, "Optional<String> group cannot be null");
        // Objects.requireNonNull(lastLogin, "lastLogin cannot be null");
    }
}