// var numbers=List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// // int total=numbers.stream().
// //     filter(n -> n % 2 == 0).
// //     mapToInt(n -> n * n).sum();  // .을 맨 앞에 두면 에러가 남. 문장끝에 .을 찍어 문장이 안끝났다고 알려여..(jshell 특)

// int total=numbers.stream().
//     reduce(0, Integer::sum);

// System.out.println(total); 

var strings=List.of("a", "b", "c", "d", "e");
// var reduced=strings.stream().
//     reduce("", (s1, s2) -> s1 + s2);
// var reduced=strings.stream().
//     reduce("", String::concat);
// System.out.println(reduced);
// var joiner=strings.stream().
//     collect(Collector.of(()->new StringJoiner(""),
//         StringJoiner::add,
//         StringJoiner::merge,
//         StringJoiner::toString));
// System.out.println(joiner);
// var collectWithCollectors=strings.stream().
//     collect(Collectors.joining(", ", "[", "]"));
//     // collect(Collectors.joining());
// System.out.println(collectWithCollectors);

// Stream.of("ananas", "apple", "banana", "kiwi", "mango", "abocado").
//     filter(s -> s.length() >= 5).
//     map(String::toUpperCase).
//     sorted().
//     forEach(System.out::println);

// # LOOP
// IntStream.iterate(1,i -> i+1).  // JAVA 8
//     limit(3).
//     // forEach(System.out::println);
//     forEachOrdered(System.out::println);
// System.out.println("----");
// IntStream.iterate(1,i -> i<=10, i -> i+1).  // JAVA 9+
//     // parallel().
//     forEachOrdered(System.out::println);

String[] fruits={"apple", "banana", "kiwi", "mango", "abocado"};
String[] result=Arrays.stream(fruits).
    filter(s -> s.startsWith("a")).
    toArray(String[]::new);
System.out.println(Arrays.toString(result)); //[apple, abocado]

/exit