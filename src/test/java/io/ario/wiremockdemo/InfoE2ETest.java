package io.ario.wiremockdemo;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.ario.wiremockdemo.repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@AutoConfigureWireMock(port = 8989)
class InfoE2ETest {

    @Test
    void isInfoTrueTest() {

        WireMock.stubFor(WireMock.get("/info")
                .withHeader("Country", equalTo("Sweden"))
                .willReturn(aResponse().withStatus(200)));

        final InfoRepository repository = new InfoRepository();
        final Boolean response = repository.isInfoTrue().block();

        assertEquals(Boolean.TRUE, response);
    }
}
