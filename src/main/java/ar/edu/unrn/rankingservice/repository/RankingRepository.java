package ar.edu.unrn.rankingservice.repository;

import ar.edu.unrn.rankingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Product, Long> {

//    Product findProductById(Long id);
//
//    Page<Product> findAll(Pageable pageable);


}
