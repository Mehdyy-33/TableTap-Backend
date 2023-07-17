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

    @GetMapping("/getAllFromMonth/{id}/{year}/{month}")
    public List<Object> getAllFromMonth(@PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
        return salesFigureService.getAllFromMonth(id, year, month);
    }

    @PostMapping("/addSalesFigure/{numberTable}/{userId}")
    public ResponseEntity<SalesFigure> addSalesFigure(@PathVariable("numberTable") Integer numberTable, @PathVariable("userId") Long userId) {
        SalesFigure salesFigure = salesFigureService.addSalesFigure(numberTable, userId);
        return ResponseEntity.ok(salesFigure);
    }

    @GetMapping("getSumOfMonth/{id}/{year}/{month}")
    public Double getSumOfMonth(@PathVariable Integer id, @PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getSumOfMonth(id, year, month);
    }

       @GetMapping("getSumOfYear/{id}")
    public Double getSumOfYear(@PathVariable Integer id) {
        return salesFigureService.getSumOfYear(id);
    }

    @GetMapping("/getYears/{id}")
    public List<Object> getYear(@PathVariable Integer id) {
        return salesFigureService.getYear(id);
    }

    @GetMapping("getMonthByYear/{id}/{year}")
    public List<Integer> getMonthByYear(@PathVariable Integer id, @PathVariable("year") Integer year) {
        return salesFigureService.getMonthByYear(id, year);
    }

    @GetMapping("getOrderNumber/{id}")
    public Integer getOrderNumber(@PathVariable Integer id) {
        return salesFigureService.getOrderNumber(id);
    }

    @GetMapping("getOrderNumberByMonth/{id}/{year}/{month}")
    public Integer getOrderNumberByMonth(@PathVariable Integer id, @PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getOrderNumberByMonth(id, year, month);
    }

    @GetMapping("pourcentLastMonth/{id}/{year}/{month}")
    public Double getPourcentLastMonth(@PathVariable Integer id, @PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getPourcentLastMonth(id, year, month);
    }

    @GetMapping("differenceOrder/{id}/{year}/{month}")
    public Integer getDifferenceOrder(@PathVariable Integer id, @PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getDifferenceOrder(id, year, month);
    }

}
