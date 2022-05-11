package music.data;

import org.springframework.data.repository.CrudRepository;
import music.business.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
}