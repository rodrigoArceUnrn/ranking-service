package ar.edu.unrn.rankingservice.service;

import ar.edu.unrn.rankingservice.dto.RankingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankingService {
    RankingDTO create(RankingDTO rankingDTO);

    Float getAverageByProductId(Long id);

    Page<RankingDTO> getRankingsByProductId(Long id, Pageable pageable);
}