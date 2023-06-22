package manager.tabletap.promoCode;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
    List<PromoCode> findAllByUserId(Long user_id);
}
