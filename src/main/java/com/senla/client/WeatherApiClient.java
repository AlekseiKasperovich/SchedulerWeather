package com.senla.client;

import com.senla.model.Weather;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "weatherApiClient", url = "${yandex.url}")
public interface WeatherApiClient {

    @Timed("gettingWeatherFromYandex")
    @GetMapping
    Weather getWeather();
}
