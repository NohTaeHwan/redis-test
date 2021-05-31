package com.example.redistest.redis;

import com.example.redistest.dto.RedisCrudResponseDto;
import com.example.redistest.dto.RedisCrudSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisCrudRepository redisCrudRepository;

    @Transactional
    public Long save(RedisCrudSaveRequestDto requestDto){
        return redisCrudRepository.save(requestDto.toRedisHash()).getId();
    }

    public RedisCrudResponseDto get(Long id){
        RedisCrud redisCrud = redisCrudRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Noting saved. id=" + id));
        return new RedisCrudResponseDto(redisCrud);
    }
}
