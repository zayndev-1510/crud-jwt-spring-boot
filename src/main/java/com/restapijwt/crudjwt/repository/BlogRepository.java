package com.restapijwt.crudjwt.repository;

import com.restapijwt.crudjwt.entity.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blogs,Integer> {
    Page<Blogs> findAll(Pageable pageable);
}
