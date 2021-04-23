package com.example.services;

import com.example.dao.entity.Myuser;
import com.example.dao.entity.MyuserExample;
import com.example.dao.mapper.MyuserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@MapperScan("com.example.dao.mapper")
public class MyUserServiceImpl {

        @Autowired
        MyuserMapper myuserMapper;

        public Myuser SelbyId(int id){
                return myuserMapper.selectByPrimaryKey(id);
        }

        public List<Myuser> selectAll(){
                MyuserExample p=new MyuserExample();
                return myuserMapper.selectByExample(null);
        }

}
