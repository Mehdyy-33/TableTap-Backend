package manager.tabletap.Subcategory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manager.tabletap.Category.Category;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @ManyToOne
    @JsonIgnoreProperties(value = {"label", "products", "subcategories"})
    private Category category;

}
