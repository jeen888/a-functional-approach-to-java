// Runnable: 인자가 없고 반환값 없음.
Runnable r=()->System.out.println("Hello, FP!");
r.run();

// Consumer<T>: 인자 1개, 반환값 없음. 입력을 받아 소비(출력 등)만 함.
Consumer<String> c= s ->System.out.println(s);
c.accept("Hello, Consumer!");

// Function<T,R>: 인자 1개, 반환값 있음. 입력을 받아 처리 후 결과 반환. 
Function<Integer, String> f= i -> "Number: "+i;
String result=f.apply(5);
System.out.println(result);

// BiFunction<T,U,R>: 인자 2개, 반환값 있음. 두 입력을 받아 처리 후 결과 반환.
BiFunction<Integer, Integer, Integer> add= (a,b) -> a+b;
int sum=add.apply(3,4);;
System.out.println("Sum: "+sum);

// Supplier<T>: 인자 없음, 반환값 있음. 입력 없이 처리 후 결과 반환.
Supplier<Double> randomSupplier= () -> Math.random();;
double randomValue=randomSupplier.get();
System.out.println("Random Value: "+randomValue);

// Predicate<T>: 조건 검사. 인자 1개를 받아 true/false 반환.
Predicate<Integer> isEven= n -> n % 2 == 0;
boolean check=isEven.test(4);
System.out.println("Is 4 even? "+check);

/exit