package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Insurance")
@Data
public class Insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nametype")
    private String nametype;
    @Column(name ="price" )
    private long price;

    @OneToMany(mappedBy = "insurance",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<User> users;

    @OneToMany(mappedBy = "insurance",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Deal> deal;
}
