package com.dku.council.domain.post.entity;

import com.dku.council.domain.category.Category;
import com.dku.council.domain.post.PostStatus;
import com.dku.council.domain.user.User;
import com.dku.council.global.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

/**
 * Post BaseEntity.
 * 이 클래스를 상속받으면 회칙, 회의록 등과 같은 새로운 타입을 만들 수 있다.
 * 상속받고 필요한대로 확장해서 사용하면 된다.
 */
@Entity
@Getter
@DynamicUpdate
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor(access = PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String title;

    @Lob
    private String body;

    @Enumerated(STRING)
    private PostStatus status;

    /**
     * 조회수
     */
    private int views;


    protected Post(User user, String title, String body, Category category, int views) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.category = category;
        this.views = views;
    }
}
