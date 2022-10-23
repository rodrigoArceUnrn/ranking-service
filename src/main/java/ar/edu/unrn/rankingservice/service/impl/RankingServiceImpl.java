package ar.edu.unrn.rankingservice.service.impl;

import ar.edu.unrn.rankingservice.dto.ProductDTO;
import ar.edu.unrn.rankingservice.model.Product;
import ar.edu.unrn.rankingservice.repository.RankingRepository;
import ar.edu.unrn.rankingservice.service.RankingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    RankingRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

//    @Override
//    public ProductDTO getProductById(Long id) throws ProductUnknownException {
//        Product product = productRepository.findProductById(id);
//        if (product == null) throw new ProductUnknownException("No existe producto");
//        return convertToDTO(product);
//    }
//
//    @Override
//    public Page<ProductDTO> getProducts(Pageable pageable) {
//        Page<Product> page = productRepository.findAll(pageable);
//        return page.map(this::convertToDTO);
//    }


    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
