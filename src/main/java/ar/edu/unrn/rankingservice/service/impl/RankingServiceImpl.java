package ar.edu.unrn.rankingservice.service.impl;

import ar.edu.unrn.rankingservice.dto.RankingDTO;
import ar.edu.unrn.rankingservice.model.Ranking;
import ar.edu.unrn.rankingservice.repository.RankingRepository;
import ar.edu.unrn.rankingservice.service.RankingService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RankingServiceImpl implements RankingService {

    final
    RankingRepository rankingRepository;
    private final ModelMapper modelMapper;

    public RankingServiceImpl(RankingRepository rankingRepository, ModelMapper modelMapper) {
        this.rankingRepository = rankingRepository;
        this.modelMapper = modelMapper;
    }


    private RankingDTO convertToDTO(Ranking ranking) {
        return modelMapper.map(ranking, RankingDTO.class);
    }

    private Ranking convertToEntity(RankingDTO rankingDTO) {
        return modelMapper.map(rankingDTO, Ranking.class);
    }

    @Override
    public RankingDTO create(RankingDTO rankingDTO) {
        rankingDTO.setDate(LocalDateTime.now());
        Ranking ranking = convertToEntity(rankingDTO);
        return convertToDTO(rankingRepository.save(ranking));
    }

    @Override
    public Float getAverageByProductId(Long id) {
        return rankingRepository.getAverageByProductId(id);
    }

    @Override
    public Page<RankingDTO> getRankingsByProductId(Long id, Pageable pageable) {
        Page<Ranking> page = rankingRepository.findRankingsByProductId(id, pageable);
        return page.map(this::convertToDTO);
    }
}
