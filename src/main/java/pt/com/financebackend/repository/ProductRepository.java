package pt.com.financebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.com.financebackend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
