package lab.api.carros.repository;

import lab.api.carros.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {
}
