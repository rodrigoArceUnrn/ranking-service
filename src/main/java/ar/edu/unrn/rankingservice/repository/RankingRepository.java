package ar.edu.unrn.rankingservice.repository;

import ar.edu.unrn.rankingservice.model.Ranking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

    @Query("SELECT AVG(r.cantStar) as a from Ranking r where r.productId = :id")
    Float getAverageByProductId(Long id);

    Page<Ranking> findRankingsByProductId(Long id, Pageable pageable);
}
