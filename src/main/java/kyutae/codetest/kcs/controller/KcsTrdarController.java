package kyutae.codetest.kcs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import kyutae.codetest.kcs.controller.dto.*;
import kyutae.codetest.kcs.service.KcsTrdarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kcs/api")
public class KcsTrdarController {
    private final KcsTrdarService kcsTrdarService;

    public KcsTrdarController(KcsTrdarService kcsTrdarService) {
        this.kcsTrdarService = kcsTrdarService;
    }

    @PostMapping("/rate")
    @Operation(summary = "개업률 및 폐업률이 가장 높은 서비스 업종 조회", description = "기준년분기와 상권코드를 입력받아 개업률이 가장 높은 서비스 업종과 폐업률이 가장 높은 서비스 업종을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "업종 조회",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TrdarRateResDto.class)))
    public ResponseEntity<TrdarRateResDto> getTrdarRate(@Valid @RequestBody TrdarRateReqDto trdarRateReqDto) {
        TrdarRateResDto response = kcsTrdarService.getTrdarRate(trdarRateReqDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/best-stor-count")
    @Operation(summary = "가장 많은 점포수를 가진 5가지 업종 조회", description = "기준년분기와 상권코드를 입력받아 가장 많은 점포수를 가진 5가지 업종을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "업종 조회",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BestStorCountResDto.class)))
    public ResponseEntity<BestStorCountResDto> getBestStorCount(@Valid @RequestBody BestStorCountReqDto bestStorCountReqDto) {
        BestStorCountResDto response = new BestStorCountResDto("3001491", "서비스업종");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/best-sales")
    @Operation(summary = "당월 매출 금액이 가장 높은 상권 조회", description = "기준년분기와 업종명을 입력받아 당월 매출 금액이 가장 높은 상권을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "상권 조회",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BestSalesResDto.class)))
    public ResponseEntity<BestSalesResDto> getBestSales(@Valid @RequestBody BestSalesReqDto bestStorCountReqDto) {
        BestSalesResDto response = new BestSalesResDto("3001491", "서비스업종");
        return ResponseEntity.ok(response);
    }
}
