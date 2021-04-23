package com.example.services;

import com.example.cache.RedisUtils;
import com.example.dao.entity.BookInfo;
import com.example.dao.entity.BookInfoExample;
import com.example.dao.entity.Myuser;
import com.example.dao.entity.MyuserExample;
import com.example.dao.mapper.BookInfoMapper;
import com.example.dao.mapper.MyuserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@MapperScan("com.example.dao.mapper")
public class BookInfoServiceImpl {

        @Autowired
        BookInfoMapper bookinfoMapper;

        @Resource
        RedisUtils redisUtils;

        public BookInfo SelbyId(int id){
                return bookinfoMapper.selectByPrimaryKey(id);
        }

        public List<BookInfo> selectAll(){
                BookInfoExample p=new BookInfoExample();
                return bookinfoMapper.selectByExample(null);
        }


        public int UpdateById(BookInfo model){

                int id =model.getId();
                BookInfo entity=bookinfoMapper.selectByPrimaryKey(id);
                entity.setAuthor(model.getAuthor());
                entity.setBookname(model.getBookname());
                return bookinfoMapper.updateByPrimaryKey(entity);
        }

        /**
         * 缓存处理
         * @param model
         * @return
         */
        public boolean SetToCache(BookInfo model){
                for(int i=0;i<10;i++){
                        redisUtils.setHash("Res_p", String.valueOf(i),String.valueOf(100+i));
                }
                return true;
        }
}
