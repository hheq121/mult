package com.example.controller;
import com.example.core.ResponseResult;
import com.example.dao.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("bookinfo")
public class BookInfoController {

    @Autowired
    com.example.services.BookInfoServiceImpl bookInfoServiceImpl;


    @RequestMapping("/getbyid")
    public BookInfo SelectById(@RequestBody HashMap<String, String> map ){
        String id= map.get("id");

        return  bookInfoServiceImpl.SelbyId(Integer.parseInt(id) );
    }

    @RequestMapping("/getall")
    public List<BookInfo> getAll(){
        return  bookInfoServiceImpl.selectAll();
    }

    @Transactional
    @RequestMapping("/updatebyid")
    public ResponseResult UpdateById(@RequestBody HashMap<String, String> map){
        ResponseResult result =new ResponseResult();
        result.isSuccess=true;
        result.message="process success";

        // 第一次方法
        BookInfo bookInfo=new BookInfo();
        bookInfo.setId(Integer.parseInt(map.get("id")));
        bookInfo.setAuthor(map.get("author"));
        bookInfo.setBookname(map.get("bookname"));
        bookInfoServiceImpl.UpdateById(bookInfo);


        int p=100/0;

        //第二次方法
        bookInfo.setId(Integer.parseInt(map.get("id")));
        bookInfo.setAuthor("李fg");
        bookInfo.setBookname("李一df");
        int counts= bookInfoServiceImpl.UpdateById(bookInfo);




        result.message= String.format("影响成数 {0}" ,counts);
        return  result;
    }


    @RequestMapping("/setcache")
    public  boolean setCache(@RequestBody HashMap<String, String> map){
        BookInfo model=new BookInfo();
        model.setId(Integer.parseInt(map.get("id")));
        model.setAuthor(map.get("author"));
        model.setBookname(map.get("bookname"));
        return bookInfoServiceImpl.SetToCache(model);
    }
}
