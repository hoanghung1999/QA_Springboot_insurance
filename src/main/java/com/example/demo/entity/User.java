package com.example.demo.entity;

import com.example.demo.model.dto.InsuranceDto;
import com.example.demo.model.mapper.InsuranceMapper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "typeuser")
    private String typeuser;

    @Column(name = "address")
    private String address;
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id") // thông qua khóa ngoại address_id
    private Insurance insurance;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter
    private Collection<Deal> deals;
    public InsuranceDto getInsuranceDto(){
        InsuranceDto insuranceDto= InsuranceMapper.toInsuranceDto(insurance);
        return insuranceDto;
    }
}