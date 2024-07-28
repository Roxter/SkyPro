package pro.sky.java.course2.weblibrary.service;

import org.springframework.stereotype.Service;

@Service    // Объект является держателем бизнес-логики
public class CounterServiceImpl implements CounterService {
    private int counter;

    @Override
    public int requestCount() {
        return counter++;
    }
}
