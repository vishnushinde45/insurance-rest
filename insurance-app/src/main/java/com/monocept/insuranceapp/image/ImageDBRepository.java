package com.monocept.insuranceapp.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDBRepository extends JpaRepository<SchemeImage, Integer> {

}
