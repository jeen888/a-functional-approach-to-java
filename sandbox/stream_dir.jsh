var dir=Paths.get("./");

try (var stream=Files.list(dir)) {
    stream.map(Path::getFileName)
        .forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}

/exit