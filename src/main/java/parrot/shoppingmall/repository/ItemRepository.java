package parrot.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parrot.shoppingmall.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
