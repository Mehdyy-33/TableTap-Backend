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


    public List<Object> getAllFromMonth() {
        return salesFigureRepository.getAllFromMonth();
    }
}
