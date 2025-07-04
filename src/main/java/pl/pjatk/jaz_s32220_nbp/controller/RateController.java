package pl.pjatk.jaz_s32220_nbp.controller;


import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jaz_s32220_nbp.service.RateService;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RateController {

    private final RateService rateService;
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

//    Ten ResponseEntity zwraca sredni kurs waluty w zadamym zakresie jakby ogolnie
//    @Param currency zwraca kod waluty zgodny z api nbp
//    @Param start to poczatek zakresu (format ISO yyyy-MM-dd)
//    @Param end to koncowa data zakresu (format ISO yyyy-MM-dd)
//    @return to odp zwracajaca obliczona srednia i dane z tego zapytania

    @GetMapping("/average")
    public ResponseEntity<Map<String, Object>> getAverageRate(
            @RequestParam String currency,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        double avg = rateService.calculateAverage(currency, start, end);
        return ResponseEntity.ok(Map.of(
                "currency", currency,
                "start", start,
                "end", end,
                "average", avg
        ));
    }

}
