package com.example.redistest.redis;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@ToString
@Getter
@RedisHash("redisCrud")
public class RedisCrud {

    @Id
    private Long id;
    private String description;
    private LocalDateTime updateAt;

    @Builder
    public RedisCrud(Long id,String description,LocalDateTime updateAt){
        this.id = id;
        this.description = description;
        this.updateAt = updateAt;
    }

    public void update(String description,LocalDateTime updateAt){
        if(updateAt.isAfter(this.updateAt)){
            this.description = description;
            this.updateAt = updateAt;
        }
    }


}
