Function<String, String> helloWorld=name-> "hello "+name+"!";
var result=helloWorld.apply("Ben");
System.out.println(result);

// 1. 데이터 준비 (List)
List<String> names = Arrays.asList("Kim-voda", "Lee-java", "Kim-code", "Park-script");
// 2. Stream API + Lambda 사용
List<String> filteredNames = names.stream().
    filter(name -> name.startsWith("Kim")). // Lambda: "Kim"으로 시작하는지 검사 (Predicate 인터페이스 구현)
    map(name -> name.toUpperCase()).       // Lambda: 대문자로 변환 (Function 인터페이스 구현)
    collect(Collectors.toList());         // 결과 수집
// 3. 결과 출력 (Method Reference - 람다의 축약형)
filteredNames.forEach(System.out::println);

// #2.2.3 메서드 참조
//1. 정적 메서드
// 예시: 문자열을 숫자로 변환
Function<String, Integer> f1 = (s) -> Integer.parseInt(s);
Function<String, Integer> f2 = Integer::parseInt;
System.out.println(f2.apply("100"));

//2. 비정적 메서드(인스턴스 메서드 참조)
String str = "Hello";
// 예시: 외부 변수인 str 객체의 메서드 호출
Supplier<Integer> s1 = () -> str.length();
Supplier<Integer> s2 = str::length;
System.out.println(s2.get());

//3. 매개변수의 인스턴스 메서드 참조
// 예시: 두 문자열이 같은지 비교 (첫 번째 인자인 String의 equals 호출)
BiPredicate<String, String> p1 = (s1, s2) -> s1.equals(s2);
BiPredicate<String, String> p2 = String::equals;
System.out.println(p2.test("Java", "Java"));

//4. 생성자 참조
// 예시: 기본 생성자로 새로운 객체 생성
Supplier<List<String>> s1 = () -> new ArrayList<>(Arrays.asList("a", "b", "c"));
Supplier<List<String>> s2 = ArrayList::new;
List<String> list = s1.get();
list.forEach(System.out::println);

List<Integer> listStream=Stream.of(1,2,3).
// peek(System.out::println). // 중간 확인(로그용)
collect(Collectors.toList())
// peek(System.out::println) // 마지막에 peek을 써도 동작? ERROR
// forEach(System.out::println) // ok
;
/exit