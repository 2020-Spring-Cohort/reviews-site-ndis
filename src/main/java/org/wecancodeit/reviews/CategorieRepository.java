package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategorieRepository extends CrudRepository<Laptop, Long> {

    Optional<Categories> findByCategories(String categoriesLocation);


}
