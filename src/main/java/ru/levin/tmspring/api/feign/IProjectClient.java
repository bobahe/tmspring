package ru.levin.tmspring.api.feign;

import feign.Feign;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import ru.levin.tmspring.dto.ProjectDTO;

import java.util.List;

@FeignClient(value = "projectClient", url = "http://localhost:8888/tmspring/api")
public interface IProjectClient {

    static IProjectClient client(final String baseUrl) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(IProjectClient.class, baseUrl);
    }

    @PostMapping(value = "/project/create")
    ProjectDTO createProject(@RequestParam(name = "name") final String projectName);

    @GetMapping(value = "/project/get")
    List<ProjectDTO> getProjectAll();

    @GetMapping(value = "/project/getById/{id}")
    ProjectDTO getProjectById(@PathVariable(name = "id") final String projectId);

    @DeleteMapping(value = "/project/remove/{id}")
    void removeProject(@PathVariable(name = "id") final String projectId);

    @PutMapping(value = "/project/update")
    void updateProject(@RequestBody final ProjectDTO project);

}
