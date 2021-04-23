package com.example.controller;
import com.example.dao.entity.Myuser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("my")
public class MyuserController {

    @Resource
    com.example.services.MyUserServiceImpl myUserServiceImpl;


    @RequestMapping("/getbyid")
    public Myuser SelectById(@RequestBody HashMap<String, String> map ){
        String id= map.get("id");

        return  myUserServiceImpl.SelbyId(Integer.parseInt(id) );
    }

    @RequestMapping("/getall")
    public List<Myuser> getAll(){
        return  myUserServiceImpl.selectAll();
    }

}
