package com.codegym.blogajax.repository;

import com.codegym.blogajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value="SELECT * FROM blog c WHERE c.title like concat('%',?1,'%') or c.content like concat('%',?1,'%')",
            countQuery="SELECT count(*) FROM blog c WHERE c.title like concat('%',?1,'%') or c.content like concat('%',?1,'%') ",
            nativeQuery=true)
    Iterable<Blog> search(String text);
}
