package com.example.joseph.springmicroservicefornecedor.repository;

import com.example.joseph.springmicroservicefornecedor.entity.InfoProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoProviderRepository extends CrudRepository<InfoProvider, Long> {

  InfoProvider findByState(String state);
}
