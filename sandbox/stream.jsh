// /open User3.java
// /open *.java // not works
// /list
//
// A FUNCTIONAL APPROACH TO JAVA
// Chapter 6 - Data Processing with Streams
//
// Example 6-2. Finding books with a Stream
//
// SUPPOSED TASK: First three science-fiction books before 1970 sorted by title.
//

// import java.util.stream.Collectors;
// import java.util.stream.Stream;
// import java.util.List;

// enum Genre {
//     DYSTOPIAN,
//     HORROR,
//     SCIENCE_FICTION;
// }

// record Book(String title, int year, Genre genre) {
//     // NO BODY
// }


// List<Book> books =
//     List.of(new Book("Dracula", 1897, Genre.HORROR),
//         new Book("Brave New World", 1932, Genre.DYSTOPIAN),
//         new Book("1984", 1949, Genre.DYSTOPIAN),
//         new Book("Dune", 1965, Genre.SCIENCE_FICTION),
//         new Book("Do Androids Dream of Electric Sheep", 1968, Genre.SCIENCE_FICTION),
//         new Book("The Shining", 1977, Genre.HORROR),
//         new Book("Neuromancer", 1984, Genre.SCIENCE_FICTION),
//         new Book("The Handmaid's Tale", 1985, Genre.DYSTOPIAN));

// List<String> result = books.stream().
//                         //    filter(book -> book.year() < 1970).
//                         //    filter(book -> book.genre() == Genre.SCIENCE_FICTION).
//                            map(Book::title).
//                         //    sorted().
//                         //    limit(3).
//                            collect(Collectors.toList());

// System.out.println("books = " + result);

// // 스트림 리듀스
// var strings = List.of("a", "b", "c", "d", "e");
// var reduced = strings.stream().reduce("", String::concat);
// System.out.println("reduced : "+reduced);

// // 배열 반환
// String[] fruits=Stream.of("apple", "orange", "banana", "peach").toArray(String[]::new);
// System.out.println("fruits : "+fruits[1]);

// // 단순 파이프라인 : 배치 순서에 따라 효율이 따르다.
// Stream.of("apple", "orange", "banana", "peach").
//     peek(s -> System.out.println("peek 1 : "+s)).
//     // filter(s -> s.startsWith("a")).
//     filter(s -> s.contains("e")).
//     peek(s -> System.out.println("peek 2 : "+s)).
//     // map(String::toUpperCase).
//     // sorted().
//     // peek(System.out::println).
//     count()
//     // forEach(System.out::println)
// ;

// loop stream
// // Java 8
// IntStream.iterate(0, i -> i+1).
//     limit(3).
//     forEachOrdered(System.out::println);
// // Java 9+
// IntStream.iterate(0, i->i<3, i->i+1).
//     forEachOrdered(System.out::println);
// IntStream.range(0, 3).
//     forEachOrdered(System.out::println);
// String[] arr1 = new String[] {"Banana", "Melon", "Orange"};
// String[] result1 = Arrays.stream(arr1).
//     filter(fruit -> fruit.contains("a")).
//     // peek(System.out::println).
//     toArray(String[]::new);
// System.out.println("result1.length : "+result1.length);

// List stream
// List<String> names = Arrays.asList("Kim", "Lee", "Park", "Choi", "Kang");
// // 'K'로 시작하는 이름만 추출하여 리스트로 만들기
// List<String> filteredNames = names.stream().
//     filter(name -> name.startsWith("K")).
//     map(String::toUpperCase).
//     peek(System.out::println).
//     collect(Collectors.toList());
// List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
// List<Integer> revNums = numbers.stream().   // 내림차순 정렬, 단순 오름차순은 sorted()
//     sorted(Comparator.reverseOrder()).
//     peek(System.out::println).
//     collect(Collectors.toList());
// long count = numbers.stream().filter(n -> n>=5).count();    // int count 하면 ERROR
// System.out.println("5이상 갯수: "+count);

// 디렉토리 항목 나열
// import java.util.regex.*;
// var dir = Paths.get("./");
// try (var stream=Files.list(dir)) {  // try-with-resources
//     // Pattern p=Pattern.compile("^record");
//     stream.map(Path::getFileName).
//         // filter(f -> p.matcher(f).matches()).
//         // filter(f -> f.startsWith("record")).
//         sorted().
//         forEachOrdered(System.out::println);
// } catch (IOException e) {}

// 파일(전쟁과 평화) 단어 수 세기
var location = Paths.get("./war-and-peace.txt");
var punct = Pattern.compile("\\p{Punct}");
var whitespace = Pattern.compile("\\s+");
var words = Pattern.compile("\\w+");
try (Stream<String> stream = Files.lines(location)) {
    Map<String, Integer> wordCount =stream.map(punct::matcher).
        map(matcher -> matcher.replaceAll("")).
        // 단어 분할
        map(whitespace::split).
        flatMap(Arrays::stream).
        // 추가 정리
        filter(word -> words.matcher(word).matches()).
        // 표준화
        map(String::toLowerCase).
        // 카운트
        collect(Collectors.toMap(Function.identity(), word->1, Integer::sum))
    ;
    System.out.println("전쟁과 평화 단어별 출현 횟수 : "+wordCount);
} catch(Exception e) {}

/exit
