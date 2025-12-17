import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public record User2(String name, boolean active, LocalDateTime lastLogin) { // JAVA 9+

    public User2 { // 컴팩트 생성자 : ()와 모든 인수 생략, '유효성검사/데이터정제'에 적절한 위치.
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(lastLogin, "lastLogin cannot be null");

        name = name.toUpperCase();
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