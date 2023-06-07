package manager.tabletap.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manager.tabletap.Product.Product;
import manager.tabletap.Subcategory.Subcategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @OneToMany
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy ="category", cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<Subcategory> subcategories = new HashSet<>();
}
