package manager.tabletap.auth;

import lombok.RequiredArgsConstructor;
import manager.tabletap.user.User;
import manager.tabletap.user.UserRepository;
import manager.tabletap.util.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) throws Exception {

        if (repository.findByEmail(request.getEmail()).isEmpty()) {
            var user = User.builder()
                    .passwordVerification(request.getPasswordVerification())
                    .restaurantName(request.getRestaurantName())
                    .numberSiret(request.getNumberSiret())
                    .numberTable(request.getNumberTable())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role("ROLE_USER")
                    .build();

            repository.save(user);

            return "";

        } else {
            System.out.println("Username already taken");
            throw new Exception("Username already taken");
        }

    }

    public AuthResponse authenticate(AuthRequest request) {


        /* Permet de comparer le pwd reçu de la request reçue avec le pwd haché de la BDD.
         * La méthode authenticate() permet surtout de garantir que les informations d'identification sont exactes
         * Permet de transmettre au contexte de Spring l'utilisateur qui a été trouvé.
         *  Cela permet de l'utiliser pour autoriser/refuser l'accès aux ressources protégées
         * S'il n'est pas trouvé, une erreur est levée et la méthode s'arrête.
         */
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        /* Si tout va bien et que les informations sont OK, on peut récupérer l'utilisateur */
        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        /* On extrait le rôle de l'utilisateur */
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", user.getRole());

        /* On génère le token avec le rôle */
        String jwtToken = jwtService.generateToken(new HashMap<>(extraClaims), user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }
}
