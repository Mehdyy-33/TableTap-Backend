package manager.tabletap.promoCode;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoCodeService {

    private final PromoCodeRepository repository;

    public List<PromoCode> getAll(Long id){
        return repository.findAllByUserId(id);
    }

    public PromoCode getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public PromoCode add(PromoCode promoCode){
        return repository.save(promoCode);
    }

    public PromoCode update(PromoCode promoCode, Long id){
        PromoCode found = getById(id);
        found.setLabel(promoCode.getLabel());
        found.setValue(promoCode.getValue());

        return repository.save(found);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
