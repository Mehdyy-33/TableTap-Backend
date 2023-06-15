package manager.tabletap.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import manager.tabletap.Product.Product;
import manager.tabletap.Salesfigure.SalesFigure;
import manager.tabletap.productCount.ProductCount;
import manager.tabletap.promoCode.PromoCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String passwordVerification;
    private String restaurantName;
    private String numberSiret;
    private String numberTable;

    @OneToMany
    @JsonIgnore
    private Set<Product> products = new HashSet();

    @OneToMany
    @JsonIgnore
    private Set<PromoCode> promoCodes = new HashSet<>();

    @OneToMany
    @JsonIgnore
    private Set<SalesFigure> salesFigures = new HashSet<>();

    @OneToMany
    @JsonIgnore
    private Set<ProductCount> productCounts = new HashSet<>();

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));}


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}