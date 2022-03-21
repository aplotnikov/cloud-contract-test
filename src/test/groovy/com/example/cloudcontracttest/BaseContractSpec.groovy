package com.example.cloudcontracttest

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

import io.restassured.RestAssured
import spock.lang.Specification

@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract class BaseContractSpec extends Specification {

    @LocalServerPort
    int port

    void setup() {
        RestAssured.port = port
    }
}
