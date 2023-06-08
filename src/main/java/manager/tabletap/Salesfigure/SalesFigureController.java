package manager.tabletap.Salesfigure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salesFigures")
@RequiredArgsConstructor
public class SalesFigureController {

    private final SalesFigureService salesFigureService;

    @GetMapping("/getAllFromMonth")
    public List<Object> getAllFromMonth() {
        return salesFigureService.getAllFromMonth();
    }

    @PostMapping("/addSalesFigure/{numberTable}")
    public ResponseEntity<SalesFigure> addSalesFigure(@PathVariable("numberTable") Integer numberTable) {
        SalesFigure salesFigure = salesFigureService.addSalesFigure(numberTable);
        return ResponseEntity.ok(salesFigure);
    }
}
