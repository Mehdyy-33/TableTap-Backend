package manager.tabletap.Product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manager.tabletap.Category.Category;
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
    private Double price;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties({"products", "subCategories"})
    private Category category;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties({"products", "category"})
    private SubCategory subCategory;

    private Long spicyLvl;
    private Boolean isVege;
    private Boolean isGlutenFree;
    private Boolean isAvailable;
}

