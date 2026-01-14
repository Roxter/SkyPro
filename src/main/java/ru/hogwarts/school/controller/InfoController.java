package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class InfoController {

    @GetMapping("/sum")
    public int getSum() {
        long start = System.currentTimeMillis();

        //int sum = Stream.iterate(1, a -> a +1).limit(1_000_000).reduce(0, (a, b) -> a + b);

        int sum = IntStream.rangeClosed(1, 1_000_000)
            .parallel()
            .sum();

        long time = System.currentTimeMillis() - start;
        System.out.printf("Time: %dms\n", time);

        return sum;
    }
}