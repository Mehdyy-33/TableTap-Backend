package manager.tabletap.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manager.tabletap.CategoryWithoutSubCategory.CategoryWithoutSubCategory;
import manager.tabletap.SubCategory.SubCategory;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String img;
    private Float price;
    private CategoryWithoutSubCategory category;
    private SubCategory subCategory;
    private Long spicyLvl;
    private Boolean isVege;
    private Boolean isGlutenFree;
    private Boolean isAvailable;
}

