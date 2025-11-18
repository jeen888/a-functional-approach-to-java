import java.time.LocalDateTime;

public record User(String name, boolean active, LocalDateTime lastLogin) {
    // 바디생략
}