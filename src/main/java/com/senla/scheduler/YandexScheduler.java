package com.senla.scheduler;

import com.senla.service.WeatherService;
import io.micrometer.core.annotation.Timed;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {

    private final WeatherService weatherService;

    @Timed("gettingTempScheduler")
    @Scheduled(fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    public void updatePrice() {
        weatherService.getWeather();
    }
}
