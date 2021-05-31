package com.example.redistest.dto;

import com.example.redistest.redis.RedisCrud;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RedisCrudSaveRequestDto {

    private Long id;
    private String description;
    private LocalDateTime updateAt;

    @Builder
    public RedisCrudSaveRequestDto(Long id,String description,LocalDateTime updateAt){
        this.id = id;
        this.description = description;
        this.updateAt = updateAt;
    }

    public RedisCrud toRedisHash(){
        return RedisCrud.builder()
                .id(id)
                .description(description)
                .updateAt(LocalDateTime.now())
                .build();
    }

}
