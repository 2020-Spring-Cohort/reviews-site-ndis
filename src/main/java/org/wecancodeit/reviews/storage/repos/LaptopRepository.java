package org.wecancodeit.reviews.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Laptop;

public interface LaptopRepository extends CrudRepository <Laptop, Long>{
}
