package com.example.OnlineComplaint_backend.controller;

import com.example.OnlineComplaint_backend.doa.ComplaintDao;
import com.example.OnlineComplaint_backend.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ComplaintsController {
    @Autowired
    private ComplaintDao doa;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addCompliant",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addComplaint(@RequestBody Complaints c){
    HashMap<String,String> map=new HashMap<>();
    doa.save(c);
    map.put("status","success");
    return map;
}

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllComplaints")
    public List<Map<String,String>> viewAllComplaints(){
        return (List<Map<String,String>>) doa.viewComplaints();

    }
}
