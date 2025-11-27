var start=Paths.get("../part-1");

// BiPredicate<Path, java.nio.file.attribute.BasicFileAttributes> matcher= (path, attr) -> attr.isDirectory();
try (var stream=Files.find(start, Integer.MAX_VALUE, (p, a) -> a.isDirectory())) {
    stream.sorted()
        .forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}

/exit
