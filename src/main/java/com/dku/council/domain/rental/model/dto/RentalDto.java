package com.dku.council.domain.rental.model.dto;

import com.dku.council.domain.rental.model.RentalUserClass;
import com.dku.council.domain.rental.model.entity.Rental;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalDto {

    @Schema(description = "아이디", example = "1")
    private final Long id;

    @Schema(description = "대여 시각", example = "2022-03-01 11:31:11")
    private final LocalDateTime rentalAt;

    @Schema(description = "행사명", example = "물품 행사")
    private final String title;

    @Schema(description = "대여자 구분")
    private final RentalUserClass userClass;

    @Schema(description = "행사 내용", example = "행사입니다.")
    private final String body;

    @Schema(description = "대여자 이름", example = "이름")
    private final String lender;

    @Schema(description = "대여 시작", example = "2022-03-01 11:31:11")
    private final LocalDateTime rentalStart;

    @Schema(description = "대여 종료", example = "2022-03-03 10:00:00")
    private final LocalDateTime rentalEnd;


    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.rentalAt = rental.getCreatedAt();
        this.title = rental.getTitle();
        this.body = rental.getBody();
        this.userClass = rental.getUserClass();
        this.lender = rental.getUser().getName();
        this.rentalStart = rental.getRentalStart();
        this.rentalEnd = rental.getRentalEnd();
    }
}
