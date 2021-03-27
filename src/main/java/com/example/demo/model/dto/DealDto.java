package com.example.demo.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
public class DealDto implements Serializable {
    private long id;
    private Date timeComplete;
    private Float totalBill;
    private String status;
    private Date durantion;
}
