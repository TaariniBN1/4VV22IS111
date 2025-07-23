package com.demo.urlshortner.dao;
import com.demo.urlshortner.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, String>{
	boolean existsByShortCode(String shortCode);
}
