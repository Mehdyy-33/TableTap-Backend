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

    @GetMapping("/getAllFromMonth/{year}/{month}")
    public List<Object> getAllFromMonth(@PathVariable Integer year, @PathVariable Integer month) {
        return salesFigureService.getAllFromMonth(year, month);
    }

    @PostMapping("/addSalesFigure/{numberTable}")
    public ResponseEntity<SalesFigure> addSalesFigure(@PathVariable("numberTable") Integer numberTable) {
        SalesFigure salesFigure = salesFigureService.addSalesFigure(numberTable);
        return ResponseEntity.ok(salesFigure);
    }

    @GetMapping("getSumOfMonth/{year}/{month}")
    public Double getSumOfMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getSumOfMonth(year, month);
    }

       @GetMapping("getSumOfYear")
    public Double getSumOfYear() {
        return salesFigureService.getSumOfYear();
    }

    @GetMapping("/getYears")
    public List<Object> getYear() {
        return salesFigureService.getYear();
    }

    @GetMapping("getMonthByYear/{year}")
    public List<Integer> getMonthByYear(@PathVariable("year") Integer year) {
        return salesFigureService.getMonthByYear(year);
    }

    @GetMapping("getOrderNumber")
    public Integer getOrderNumber() {
        return salesFigureService.getOrderNumber();
    }

    @GetMapping("getOrderNumberByMonth/{year}/{month}")
    public Integer getOrderNumberByMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getOrderNumberByMonth(year, month);
    }

    @GetMapping("pourcentLastMonth/{year}/{month}")
    public Double getPourcentLastMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getPourcentLastMonth(year, month);
    }

    @GetMapping("differenceOrder/{year}/{month}")
    public Integer getDifferenceOrder(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return salesFigureService.getDifferenceOrder(year, month);
    }

}
