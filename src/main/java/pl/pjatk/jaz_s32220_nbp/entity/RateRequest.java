package pl.pjatk.jaz_s32220_nbp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

//      Encja z informacjami o wykonywanym zapytaniu sredniej kursu
//      Zwraca kod waluty, daty start/end, obliczona srednia, data wpisu
//

@Entity
public class RateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private double averageRate;
    private LocalDateTime createdAt;

    public RateRequest() {}

    public RateRequest(String currency, LocalDate startDate, LocalDate endDate, double averageRate, LocalDateTime createdAt) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.averageRate = averageRate;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public double getAverageRate() {
        return averageRate;
    }
    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
