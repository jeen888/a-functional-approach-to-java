var numbers = List.of(10, 2, 5, 9, 2, 5, 3, 5, 7, 32, 30, 66, 5, 21, 8, 4, 3, 5, 7, 9);
numbers.stream().distinct().map(n->n*3).sorted().skip(2).limit(5).forEach(System.out::println);


/exit