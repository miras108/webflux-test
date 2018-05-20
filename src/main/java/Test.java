import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Test {
    public static void main(String... args)
    {
        Stream<String> stringStream = Stream.of(1, 2, 3, 4).map(a -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "number: " + a;
        });

        Flux.fromStream(stringStream)
//                .delaySubscription(Duration.ofSeconds(1))
                .subscribe(
                successValue -> System.out.println(successValue),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Flux consumed.")
        );
    }
}
