package com.dku.council.domain.post.repository.post;

import com.dku.council.domain.comment.model.entity.Comment;
import com.dku.council.domain.post.model.entity.Post;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * ACTIVE상태인 post만 가져옵니다.
     */
    @Query("select p from Post p where p.id = :id and p.status = 'ACTIVE'")
    Optional<Post> findById(Long id);

    /**
     * ACTIVE상태인 post만 가져옵니다.
     */
    @Query("select p from Post p where p.user.id=:userId and p.status='ACTIVE'")
    Page<Post> findAllByUserId(@Param("userId")Long userId, Pageable pageable);

    /**
     * 관리자만 사용 가능합니다.
     */
    @Query("select p from Post p where p.user.id=:userId order by p.createdAt desc")
    List<Post> findAllByUserId(Long userId);
    /**
     * 관리자만 사용 가능합니다.
     */
    List<Post> findAllByOrderByCreatedAtDesc();
}