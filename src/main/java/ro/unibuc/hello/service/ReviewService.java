package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ReviewEntity;
import ro.unibuc.hello.data.ReviewRepository;
import ro.unibuc.hello.dto.ReviewDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.data.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository) {

    }

    public List<ReviewDTO> findReviewsByName(String name) {
        List<ReviewEntity> reviewEntities = reviewRepository.findByNameContaining(name);
        if (reviewEntities == null || reviewEntities.isEmpty()) {
            throw new EntityNotFoundException("No reviews found");
        }
        List<ReviewDTO> reviews = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntities) {
            reviews.add(ReviewDTO.transformFromEntity(reviewEntity));
        }
        return reviews;
    }

    public boolean uploadReview(ReviewDTO reviewDTO) {
        try {
            ReviewEntity reviewEntity = new ReviewEntity();
            reviewEntity.setId(reviewDTO.getId());
            reviewEntity.setName(reviewDTO.getName());
            reviewEntity.setMark(reviewDTO.getMark());
            reviewEntity.setDescription(reviewDTO.getDescription());
            reviewRepository.save(reviewEntity);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }


    public List<ReviewDTO> findAllReviews() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        if (reviewEntities == null || reviewEntities.isEmpty()) {
            throw new EntityNotFoundException("No reviews found");
        }
        List<ReviewDTO> reviews = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntities) {
            reviews.add(new ReviewDTO(reviewEntity.getId(), reviewEntity.getName(), reviewEntity.getMark(), reviewEntity.getDescription()));
        }
        return reviews;
    }

    public List<ReviewDTO> getProductReviews(Long productId) {
        ProductEntity productEntity = productRepository.findBySKU(String.valueOf(productId));
        List<ReviewDTO> reviews = productEntity.getReviews();
        if (reviews != null) {
            return reviews;
        }
        return Collections.emptyList();
    }
}




