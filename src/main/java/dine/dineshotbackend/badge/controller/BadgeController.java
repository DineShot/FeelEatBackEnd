package dine.dineshotbackend.badge.controller;

import dine.dineshotbackend.badge.entity.Badge;
import dine.dineshotbackend.badge.service.BadgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/badge")
@Tag(name = "뱃지", description = "뱃지 관련 API입니다.")
public class BadgeController {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("/allBadge")
    @Operation(summary = "전체 뱃지 필터로 조회",description = "전체 뱃지를 조회합니다. 필요한값만 넣어서 전송해주세요." +
            "아무값도 넣지 않을시 전체뱃지를 조회합니다.")
    @ApiResponse(responseCode = "200",description = "요청 성공, BadgeEntity 의 List를  JSON 으로 반환",
            content = @Content(schema = @Schema(implementation = Badge.class)))
    public ResponseEntity<?> getAllBadge(@RequestParam(required = false)String badgeName,
                                         @RequestParam(required = false)@Parameter(description = "location / event / activity 중 1 필수X ")
                                         String category,
                                         @RequestParam(required = false)@Parameter(description = "bronze / silver / gold 중 1 필수X")
                                         String level) {
        List<Badge> badgeList = badgeService.findBadgesWithFilter(badgeName,category,level);
        return ResponseEntity.ok(badgeList);
    }
}
