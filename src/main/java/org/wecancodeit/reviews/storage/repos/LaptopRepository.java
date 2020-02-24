package org.wecancodeit.reviews.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Laptop;

import java.util.Optional;

public interface LaptopRepository extends CrudRepository <Laptop, Long>{


    Optional<Laptop> findByName(String laptopName);
}
