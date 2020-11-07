package org.acme.resteasy;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DeveloperRepository implements PanacheRepository<Developer> {
    
    public List<Developer> findByName(String name) {
        return find("name = ?1", name).list();
    }
}
