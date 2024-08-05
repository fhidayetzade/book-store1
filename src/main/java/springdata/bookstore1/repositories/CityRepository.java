package springdata.bookstore1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.bookstore1.model.City;

public interface CityRepository extends JpaRepository<City,Integer> {
}
