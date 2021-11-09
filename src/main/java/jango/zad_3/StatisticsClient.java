package jango.zad_3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatisticsClient {

    @Autowired
    private RestTemplate restTemplate;

    public StatisticsResponse stringStatistics(StatisticsRequest statisticsRequest) {
        RequestEntity<StatisticsRequest> request = RequestEntity
            .post("http://localhost:8090/statistics")
            .headers(headers -> {
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .body(statisticsRequest);

        return restTemplate.exchange(request, StatisticsResponse.class).getBody();
    }

}
