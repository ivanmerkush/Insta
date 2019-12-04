package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Sub;
import com.netcracker.ivanmerkush.fapi.service.SubService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubServiceImpl implements SubService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Sub saveSub(Sub bond) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subs", bond, Sub.class).getBody();
    }

    @Override
    public void deleteSub(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subs/" + id);
    }
    @Override
    public Integer countSubscribers(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/subs/host" + id, Integer.class);
        return result;
    }

    @Override
    public Integer countSubscriptions(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/subs/sub" + id, Integer.class);
        return result;
    }

    @Override
    public List<Sub> getSubscriptions(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Sub[] subs =  restTemplate.getForObject(backendServerUrl + "/api/subs/" + id, Sub[].class);
        return Arrays.asList(subs);
    }
}
