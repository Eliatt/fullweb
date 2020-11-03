package com.eli.fullweb.repository;

import com.eli.fullweb.beans.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
}
