package app;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HeloRepository {

    @GetMapping(value = "/hello", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getAllCustomers() {
        return Flux.fromStream(Stream.of("name1", "name2", "name3")).delayElements(Duration.ofSeconds(2));
    }
}
