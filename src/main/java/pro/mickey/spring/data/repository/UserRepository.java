package pro.mickey.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pro.mickey.spring.data.repository.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query("update User o set o.age = :age where o.userId = :id")
	public void update(@Param("id") Long id, @Param("age") Integer age);
}
