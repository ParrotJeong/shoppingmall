package parrot.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parrot.shoppingmall.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
