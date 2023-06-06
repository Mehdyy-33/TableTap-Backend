package manager.tabletap.Subcategory;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String img;

    @ManyToOne
    @JsonIgnore
    private Category category;

}
