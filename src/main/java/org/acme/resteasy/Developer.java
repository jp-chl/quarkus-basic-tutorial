package org.acme.resteasy;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Developer extends PanacheEntity {
    
    // It will run as a private (optional)
    //
    // It will be private at building time,
    // and setters/getters are automatic
    public String name;
}
