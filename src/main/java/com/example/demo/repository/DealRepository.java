package com.example.demo.repository;

import com.example.demo.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal,Long> {
    @Query(value = "select d.*,i.* FROM deal d JOIN insurance i on d.insurance_id=i.id where i.nametype=?1",nativeQuery = true)
    public List<Deal> getAllDealByInSurName(String name);

    @Query(value = "SELECT * FROM deal d JOIN user u on d.insurance_id=u.id JOIN insurance ins ON d.insurance_id=ins.id where time_complete>=?1 and time_complete<=?2",nativeQuery = true)
    public List<Deal> getAllDealByDate(String startDate,String endDate);
}
