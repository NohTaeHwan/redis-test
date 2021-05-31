package com.example.redistest.redis;

import org.springframework.data.repository.CrudRepository;

public interface RedisCrudRepository extends CrudRepository<RedisCrud,Long> {
}
