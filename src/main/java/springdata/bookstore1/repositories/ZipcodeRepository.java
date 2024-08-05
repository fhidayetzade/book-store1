package springdata.bookstore1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import springdata.bookstore1.model.Zipcode;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Integer> {
   /* @Modifying
    @Transactional
    @Query(value = "update zipcode z set z.city_id = :city_id, z.name = :name where z.id =:id", nativeQuery = true)
    Boolean updateZipcodeCityById(@Param("city_id") Integer city_id, @Param("name") String name,@Param("id") Integer id);*/
}
