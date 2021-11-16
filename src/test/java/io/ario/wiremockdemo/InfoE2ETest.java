package io.ario.wiremockdemo;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.ario.wiremockdemo.repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWireMock(port = 0)
class InfoE2ETest {

    @Autowired
    InfoRepository repository;

    @Test
    void isInfoTrueTest() {

        WireMock.stubFor(WireMock.get("/info")
                .withHeader("Country", equalTo("Sweden"))
                .willReturn(aResponse().withStatus(200)));

        final Boolean response = repository.isInfoTrue().block();

        assertEquals(Boolean.TRUE, response);
    }
}
