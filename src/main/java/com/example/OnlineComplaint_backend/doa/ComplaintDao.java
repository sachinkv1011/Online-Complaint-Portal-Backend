package com.example.OnlineComplaint_backend.doa;

import com.example.OnlineComplaint_backend.model.Complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<Complaints,Integer> {

 @Query(value = "SELECT  u.`address`, u.`email`, u.`name`, u. `phone_no`,c.complaints FROM `user_registration` u JOIN complaints c ON c.user_id=u.id",nativeQuery = true)
    List<Map<String,String>> viewComplaints();
}
