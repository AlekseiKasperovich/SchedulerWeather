package com.senla.service;

import com.senla.client.WeatherApiClient;
import com.senla.model.MomentFact;
import com.senla.model.Weather;
import com.senla.repository.TempRepository;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    private final TempRepository tempRepository;
    private AtomicInteger temp;

    public WeatherService(
            WeatherApiClient weatherApiClient,
            TempRepository tempRepository,
            MeterRegistry registry) {
        this.weatherApiClient = weatherApiClient;
        this.tempRepository = tempRepository;
        temp = new AtomicInteger();
        registry.gauge("temp", temp);
    }

    public void getWeather() {
        Weather currentWeather = weatherApiClient.getWeather();
        if (currentWeather.getFact() == null) {
            throw new RuntimeException("Something went wrong");
        }
        int currentTemp = currentWeather.getFact().getTemp();
        temp.set(currentTemp);
        MomentFact momentFact = MomentFact.builder().temp(currentTemp).build();
        tempRepository.save(momentFact);
    }

    public List<MomentFact> getAllTemp() {
        return tempRepository.findAll();
    }
}
