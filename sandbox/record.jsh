/open User2.java
// /open *.java // not works
// /list

// body field(추가 멤버변수) X, 메서드는 추가 가능, class 상속불가, interface 구현 가능(default 메서드 이용 목적)

var user = new User2("ben", true, LocalDateTime.now());
System.out.println(user.name());
System.out.println(user.active());
System.out.println(user.lastLogin());
System.out.println(user.toString());    // 아무 것도 안해도 record.toString()은 문자열로 보기 좋게 출력해준다.

// 제네릭 지원 : but 과도사용 자체
public record Container<T, V>(T content, V msg) {}
Container<Integer, String> intCon = new Container<>(123, "hi");
System.out.println(intCon.content());
System.out.println(intCon.msg());

// 컴팩트 생성자 활용례
public record Time(int m, int s) {
    private void check(int i, String gubun) {
        if ((i < 0) || (i > 59)) {
            throw new IllegalArgumentException("0~59"+gubun+" 사이에 지정해야 함.");
        }
    }
    public Time {
        check(m, "분");
        check(s, "초");
    }
}
var time = new Time(59, 59);
System.out.println(time.toString());

/exit