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
    public SalesFigure addSalesFigure(Integer numberTable, Long userId) {
        salesFigureRepository.saveAddSalesFigure(numberTable, userId);
        return salesFigureRepository.getLastInsertedSalesFigure();
    }


    public List<Object> getAllFromMonth(Integer id,Integer year, Integer month) {
        return salesFigureRepository.getAllFromMonth(id, year, month);
    }

    public Double getSumOfMonth(Integer id, Integer year, Integer month) {
        return salesFigureRepository.getSumOfMonth(id, year, month);
    }

    public List<Object> getYear(Integer id) {
        return salesFigureRepository.getYear(id);
    }

    public List<Integer> getMonthByYear(Integer id, Integer year) {
        return salesFigureRepository.getMonthByYear(id, year);
    }

    public Double getSumOfYear(Integer id) {
        return salesFigureRepository.getSumOfYear(id);
    }

    public Integer getOrderNumber(Integer id) {
        return salesFigureRepository.getOrderNumber(id);
    }

    public Double getPourcentLastMonth(Integer id, Integer year, Integer month) {
        return salesFigureRepository.getPourcentLastMonth(id, year, month);
    }

    public Integer getOrderNumberByMonth(Integer id, Integer year, Integer month) {
        return salesFigureRepository.getOrderNumberByMonth(id, year, month);
    }

    public Integer getDifferenceOrder(Integer id, Integer year, Integer month) {
        return salesFigureRepository.getDifferenceOrder(id, year, month);
    }
}
