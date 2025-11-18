/open User.java

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

var user=new User("Alice", true, LocalDateTime.now().minusDays(1));

// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String ymdhms=user.lastLogin().format(formatter);

System.out.println(user.name()); //Alice
System.out.println(user.active()); //true
System.out.println(ymdhms); //2024-06-10 14:23:45

/exit