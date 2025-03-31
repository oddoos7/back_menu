package kr.ac.kumoh.s20200081.menu01.repository;

import kr.ac.kumoh.s20200081.menu01.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
