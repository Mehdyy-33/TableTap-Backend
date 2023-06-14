package manager.tabletap.Salesfigure;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesFigureService {

    private final SalesFigureRepository salesFigureRepository;

    @Transactional
    public SalesFigure addSalesFigure(Integer numberTable) {
        salesFigureRepository.saveAddSalesFigure(numberTable);
        return salesFigureRepository.getLastInsertedSalesFigure();
    }


    public List<Object> getAllFromMonth(Integer year, Integer month) {
        return salesFigureRepository.getAllFromMonth(year, month);
    }

    public Double getSumOfMonth(Integer year, Integer month) {
        return salesFigureRepository.getSumOfMonth(year, month);
    }

    public List<Object> getYear() {
        return salesFigureRepository.getYear();
    }

    public List<Integer> getMonthByYear(Integer year) {
        return salesFigureRepository.getMonthByYear(year);
    }

    public Double getSumOfYear() {
        return salesFigureRepository.getSumOfYear();
    }

    public Integer getOrderNumber() {
        return salesFigureRepository.getOrderNumber();
    }

    public Double getPourcentLastMonth(Integer year, Integer month) {
        return salesFigureRepository.getPourcentLastMonth(year, month);
    }

    public Integer getOrderNumberByMonth(Integer year, Integer month) {
        return salesFigureRepository.getOrderNumberByMonth(year, month);
    }

    public Integer getDifferenceOrder(Integer year, Integer month) {
        return salesFigureRepository.getDifferenceOrder(year, month);
    }
}
