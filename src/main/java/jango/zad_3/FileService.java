package jango.zad_3;

import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private StatisticsClient statisticsClient;

    @Autowired
    private FileFactory fileFactory;

    public InputStream stringStatisticsAsFile(String format, StatisticsRequest request) {
        StatisticsResponse response = statisticsClient.stringStatistics(request);
        return fileFactory.createFile(format, response);
    }
}
