package dine.dineshotbackend.badge.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BadgeFindFilterDTO {
    private String badgeName;
    private String badgeCategory;
    private String badgeLevel;

}
