package jango.zad_3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/statistics/file/{format}")
    public ResponseEntity<byte[]> createStatistics(@PathVariable("format") String format,
        @RequestBody StatisticsFileRequest request) throws IOException {

        InputStream in = fileService.stringStatisticsAsFile(format, request);

        final HttpHeaders httpHeaders = new HttpHeaders();
        switch (format) {
            case "txt": httpHeaders.setContentType(MediaType.TEXT_PLAIN);
                break;
            case "json": httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                break;
            case "xml": httpHeaders.setContentType(MediaType.TEXT_XML);
                break;
            case "csv": httpHeaders.setContentType(new MediaType("text", "csv", Charset.forName("utf-8")));
                break;
        }
        return new ResponseEntity<>(in.readAllBytes(), httpHeaders, HttpStatus.OK);
    }


}
