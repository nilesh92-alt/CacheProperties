package scheduler;

import com.example.test.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class TestScheduler {

//    @Scheduled(fixedRate = 1000)
//    public void testScheduler() {
//        System.out.println("Into test scheduler method");
//        IntStream.rangeClosed(1, 10)
//                .forEach(x -> System.out.println("value " + x));
//
//    }

}
