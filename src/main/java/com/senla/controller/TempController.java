package com.senla.controller;

import com.senla.model.MomentFact;
import com.senla.service.WeatherService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TempController {

    private final WeatherService weatherService;

    @GetMapping("/temp")
    public List<MomentFact> getAllTemp() {
        return weatherService.getAllTemp();
    }
}
