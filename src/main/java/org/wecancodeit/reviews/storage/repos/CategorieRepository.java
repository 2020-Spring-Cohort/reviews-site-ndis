package org.wecancodeit.reviews.storage.repos;

        import org.springframework.data.repository.CrudRepository;
        import org.wecancodeit.reviews.models.Categories;

        import java.util.Optional;

public interface CategorieRepository extends CrudRepository<Categories, Long> {

    Optional<Categories> findByBrand(String categoriesLocation);


}
