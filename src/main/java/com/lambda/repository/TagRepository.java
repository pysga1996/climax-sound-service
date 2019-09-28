package com.lambda.repository;

import com.lambda.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    Tag findByName(String name);

    Page<Tag> findAll(Pageable pageable);

    Page<Tag> findAllByNameContaining(String name, Pageable pageable);
}
