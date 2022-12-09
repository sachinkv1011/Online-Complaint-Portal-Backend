package com.example.OnlineComplaint_backend.doa;

import com.example.OnlineComplaint_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone_no`, `user_name` FROM `user_registration` WHERE `user_name`=:name",nativeQuery = true)
    List<UserModel> checkUser(@Param("name") String name);

    @Query(value="SELECT `id`, `address`, `email`, `name`, `password`, `phone_no`, `user_name` FROM `user_registration` WHERE `user_name`=:userName  AND `password`=:password",nativeQuery = true)
    List<UserModel> userloginCheck(@Param("userName") String userName,@Param("password") String password);
}
