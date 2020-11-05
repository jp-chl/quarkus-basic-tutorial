package org.acme.resteasy;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spring-developer")
@RestController
public class SpringDeveloperController {
    
    @Inject
    SpringDeveloperRepository developerRepository;

    @GetMapping("/asQuarkus")
    public List<Developer> developersAsQuarkus() {
        return Developer.listAll();
    }

    @GetMapping("/asSpring")
    public List<Developer> developersAsSpring() {
        return developerRepository.findAll();
    }
}
