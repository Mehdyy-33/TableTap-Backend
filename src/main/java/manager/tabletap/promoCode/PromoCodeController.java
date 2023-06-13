package manager.tabletap.promoCode;

import lombok.RequiredArgsConstructor;
import manager.tabletap.Subcategory.Subcategory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/promocodes")
public class PromoCodeController {

    private final PromoCodeService service;

    @GetMapping
    public List<PromoCode> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PromoCode getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public PromoCode add(@RequestBody PromoCode promoCode) {
        return service.add(promoCode);
    }

    @PutMapping("/update/{id}")
    public PromoCode update(@RequestBody PromoCode promoCode, @PathVariable Long id) {
        return service.update(promoCode, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}