import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameRunnerShould {
    @Ignore
    @Test
    public void generate_golden_master() throws FileNotFoundException {
        for (int seed = 0; seed < 1000; seed++) {
            createFile(seed);

            run(seed);
        }
    }

    @Test
    public void golden_master() throws IOException {
        for (int seed = 0; seed < 1000; seed++) {
            ByteArrayOutputStream outputStream = createByteArrayOut();

            run(seed);

            assertThat(outputStream.toString()).isEqualTo(readFile(seed));
        }
    }

    private void run(int seed) {
        GameRunner runner = new GameRunner(new Random(seed));

        runner.run();
    }

    private String readFile(int fileNumber) throws IOException {
        return Files.readAllLines(Path.of("output/GoldenMasterOutput" + fileNumber + ".txt"))
                .stream()
                .collect(Collectors.joining(System.lineSeparator())) + "\n";
    }

    private void createFile(int fileNumber) throws FileNotFoundException {
        System.setOut(new PrintStream(new FileOutputStream("output/GoldenMasterOutput" + fileNumber + ".txt")));
    }

    private ByteArrayOutputStream createByteArrayOut() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteArrayOutputStream);
        System.setOut(print);

        return byteArrayOutputStream;
    }
}
