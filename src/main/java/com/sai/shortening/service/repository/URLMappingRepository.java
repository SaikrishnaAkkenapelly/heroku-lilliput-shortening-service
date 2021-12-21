package com.sai.shortening.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.shortening.service.model.URLMapping;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMapping, Long>
{

}
