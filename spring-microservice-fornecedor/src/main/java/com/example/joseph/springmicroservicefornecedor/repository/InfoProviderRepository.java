package com.example.joseph.springmicroservicefornecedor.repository;

import com.example.joseph.springmicroservicefornecedor.entity.InfoProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoProviderRepository extends JpaRepository<InfoProvider, Long> {

  InfoProvider findByState(String state);
}
