// 1. Function, 2. Consumer, 3. Supplier, 4. Predicate : 팥-씨-스-프

// 1. Function : 인수 1, 리턴 1
Function<String, Integer> stringLength=str->str !=null ? str.length() : 0;
Integer result1=stringLength.apply("Hello, Function!");     // ().apply(arg)
System.out.println(result1);

// 2. Consumer : 인수 1, 리턴 X
Consumer<String> println=str->System.out.println(str);
println.accept("Hello, Consumer!");                         // ().accept(arg)

// 3. Supplier : 인수 X, 리턴 1
Supplier<Double> random=()->Math.random();
Double result3=random.get();                                // ().get()
System.out.println(result3);

// 4. Predicate : 인수 1, 리턴 boolean
Predicate<Integer> over9000=i->i>9_000;
boolean result4=over9000.test(12_345);                      // ().test(arg)
System.out.println(result4);

///////////// # arity : 함수가 받아들이는 피연산자의 수
// 인수 1개         글루메서드               인수 2개                  글루메서드  
// Function<T, R>   : compose, andThen      : BiFunction<T, U, R>     : andThen
// Consumer<T>      : andThen               : BiConsumer<T, U>
// Predicate<T>     : and, or, negate       : BiPredicate<T, U>


///////////// # arity 중복을 위한 힌트 : 함수가 받아들이는 피연산자의 수
// 아리티   연산자(#O)           슈퍼 인터페이스(#S)
//   1      UnaryOperator<T>    Function<T, T>
//   2      BinaryOperator<T>   BiFunction<T, T, T>
// java arity 호환성 주의! : 메서드 시그니처에서 #O를 요구할 경우 #S 사용 불가하나 역은 가능.
// ※ 호환성을 높이기 위해 메소드 시그니처는 가능한한 #S 타입으로 사용할 것

// 함수 합성을 위한 Glue Methods (모든 함수형 인터페이스가 지원하는 것은 아님)
// compose : 역방향(전통적) 우->좌
// andThen : 정방향(가독성) 좌->우
UnaryOperator<String> removeLowerCaseA = str -> str.replace("a", "");
UnaryOperator<String> upperCase = String::toUpperCase;

var input = "abcd";
var result1=removeLowerCaseA.andThen(upperCase).apply(input);
System.out.println(result1);    // BCD

var result2 = upperCase.compose(removeLowerCaseA).apply(input);
System.out.println(result2);    // BCD





/exit
