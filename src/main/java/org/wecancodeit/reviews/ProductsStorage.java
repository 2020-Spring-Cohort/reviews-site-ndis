package org.wecancodeit.reviews;

import java.util.Collection;

public interface ProductsStorage {
    Collection<ProductsStorage> findAllProducts();

    void store(ProductsStorage productsStorage);
}