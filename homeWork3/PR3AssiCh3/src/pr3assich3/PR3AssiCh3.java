package pr3assich3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PR3AssiCh3 {

    public static long count(String s, char ch) {
        return s.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\HP\\Documents\\NetBeansProjects\\PR3AssiCh3\\input.txt");

        StringBuilder sb = new StringBuilder();

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> sb.append(s).append("\n"));

        } catch (IOException ex) {
        }

        String contents = sb.toString();

        List<String> uniqueChars = Stream
                .of(contents)
                .map(c -> c.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                //                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < uniqueChars.size(); i++) {
            char c = (char) uniqueChars.get(i).charAt(0);
            System.out.println("Character (" + c + ") occurs " + count(contents, c) + " times.");
        }

    }

}

//value -> System.out.printf("%d ", value)

//String::toUpperCase 

//() -> "Welcome to lambdas!" 

//value -> value * value * value
