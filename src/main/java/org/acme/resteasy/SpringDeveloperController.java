package org.acme.resteasy;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spring-developer")
@RestController
public class SpringDeveloperController {
    
    @Inject
    SpringDeveloperRepository developerRepository;

    @GetMapping("/asPanache")
    public List<Developer> developersAsQuarkus() {
        return Developer.listAll();
    }

    @GetMapping("/asJpaRepository")
    public List<Developer> developersAsSpring(@RequestParam("chilean") boolean chilean) {
        if (chilean) {
            return developerRepository.findByName("jpv");
        }
        return developerRepository.findAll();
    }
}
