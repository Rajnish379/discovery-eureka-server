package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SchoolServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getSchoolDetails/{schoolname}")
    public String getStudents(@PathVariable String schoolname)
    {
        String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}"
                , HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},schoolname).getBody();
        return "School Name: " + schoolname + " Student Details : " + response;
    }
}
