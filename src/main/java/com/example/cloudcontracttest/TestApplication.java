package com.example.cloudcontracttest;

import static java.lang.invoke.MethodHandles.lookup;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @RestController
    static class Controller {

        private static final Logger LOG = LoggerFactory.getLogger(lookup().lookupClass());

        @PostMapping(value = "/attachments", consumes = MULTIPART_FORM_DATA_VALUE)
        void attachments(@RequestParam("file") MultipartFile file) {
            LOG.info("File is received!");
        }
    }

}
