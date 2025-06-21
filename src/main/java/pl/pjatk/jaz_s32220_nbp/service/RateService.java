package pl.pjatk.jaz_s32220_nbp.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jaz_s32220_nbp.entity.RateRequest;
import pl.pjatk.jaz_s32220_nbp.repository.RateRequestRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.StreamSupport;

@Service
public class RateService {
    private final RateRequestRepository repository;
    public final RestTemplate restTemplate = new RestTemplate();

    public RateService(RateRequestRepository repository) {
        this.repository = repository;
    }

    public double calculateAverage (String currency, LocalDate startDate, LocalDate endDate) {
        String url = String.format("https://api.nbp.pl/api/exchangerates/rates/A/%s/%s/%s?format=json",
                currency, startDate, endDate);

        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);
        JsonNode rates = jsonNode.get("rates");

        double average = StreamSupport.stream(rates.spliterator(), false)
                .mapToDouble(rate -> rate.get("mid").asDouble())
                .average()
                .orElseThrow(() -> new RuntimeException("Brak danych do obliczeń"));
        repository.save(new RateRequest(currency, startDate, endDate, average, LocalDateTime.now()));
        return average;

    }
}
