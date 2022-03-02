package com.api.cadastroveiculos.util;


import com.api.cadastroveiculos.dto.ViaCepDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepUtil {

    RestTemplate restTemplate = new RestTemplate();

    public ViaCepDto getData(String cep) {
        return restTemplate.getForEntity("https://viacep.com.br/ws/"+cep+"/json/",ViaCepDto.class).getBody();
    }

}
