/open User2.java

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// var user=new User("Alice", true, LocalDateTime.now().minusDays(1));
// var user=new User("Alice", true, LocalDateTime.now().minusDays(1).withHour(14).withMinute(23).withSecond(45));

// CUBRID에서 문자열로 가져온 데이터 예시
String cubridTimeString = "2025-11-18 16:20:45"; 

// 1. 포맷터 정의 (CUBRID 형식과 일치)
DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

// 2. 파싱하여 LocalDateTime 객체 생성
LocalDateTime localDateTime = LocalDateTime.parse(cubridTimeString, formatter);
var user=new User("Alice", true, localDateTime);



System.out.println(user.name()); //Alice
System.out.println(user.active()); //true
System.out.println(user.getYmd()); //2025-11-18 16:20:45
System.out.println(user.getYmd2()); //2025-11-18 16:20:45
System.out.println(user.lastLogin()); //2025-11-18T16:20:45
System.out.println(user);
/exit