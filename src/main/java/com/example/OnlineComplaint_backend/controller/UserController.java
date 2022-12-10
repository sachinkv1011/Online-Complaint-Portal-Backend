package com.example.OnlineComplaint_backend.controller;

import com.example.OnlineComplaint_backend.doa.UserDao;
import com.example.OnlineComplaint_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao udao;

    @CrossOrigin(origins="*")
    @GetMapping(path = "/")
    public String homeScreen(){
        return "Welcome Complaint portal";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userRegistration(@RequestBody UserModel um){
        HashMap<String,String> map=new HashMap<>();
        List<UserModel> value= (List<UserModel>) udao.checkUser(um.getUserName());
        if (value.size()==0){
            udao.save(um);
            map.put("status","success");
        }
        else {
            map.put("status","failed to add");
        }

        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userLogin(@RequestBody UserModel um) {
        HashMap<String, String> map = new HashMap<>();
        List<UserModel> result = (List<UserModel>) udao.userloginCheck(um.getUserName(), um.getPassword());
        if (result.size() != 0) {
            map.put("status", "login success");
            String id = String.valueOf(result.get(0).getId());
            map.put("userid",id);
        } else {
            map.put("status", "Unauthorized access");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userProfile",consumes = "application/json",produces = "application/json")
    List<UserModel> userProfile(@RequestBody UserModel um){
        List<UserModel> result=(List<UserModel>) udao.userProfile(um.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","userinfo retrieved");
        return result;


    }


}
