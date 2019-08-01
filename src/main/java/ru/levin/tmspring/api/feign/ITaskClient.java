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
import ru.levin.tmspring.dto.TaskDTO;

import java.util.List;

@FeignClient(value = "taskClient", url = "http://localhost:8888/tmspring/api")
public interface ITaskClient {

    static ITaskClient client(final String baseUrl) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(ITaskClient.class, baseUrl);
    }

    @PostMapping(value = "/task/create")
    TaskDTO createTask(
            @RequestParam(value = "name") final String taskName,
            @RequestParam(value = "projectId") final String projectId
    );

    @GetMapping(value = "/task/get")
    List<TaskDTO> getTaskAll();

    @DeleteMapping(value = "/task/remove/{id}")
    void removeTask(@PathVariable(name = "id") final String taskId);

    @PutMapping(value = "/task/update")
    void updateTask(@RequestBody final TaskDTO task);

}
