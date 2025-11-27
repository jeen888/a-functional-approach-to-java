var start=Paths.get("../part-1");

try (var stream=Files.walk(start)) {
    stream.map(Path::toFile)
        .filter(Predicate.not(File::isFile))
        .sorted()
        .forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();        
}

/exit
