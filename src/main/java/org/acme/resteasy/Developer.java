package org.acme.resteasy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Developer extends PanacheEntity {
    
    // It could run as a private (optional)
    //
    // It will be private at building time,
    // and setters/getters are automatic
    @Min(3)
    public String name;

    @Column(columnDefinition = "varchar(255) default 'Quarkus'")
    public String favouriteFramework;

    public String getName() {
        return name.toUpperCase();
    }
}
