package com.monocept.insuranceapp.image;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<SchemeImage, Integer> {
	Optional<SchemeImage> findByName(String name);
}
