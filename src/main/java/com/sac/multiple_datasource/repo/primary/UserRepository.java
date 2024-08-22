package com.sac.multiple_datasource.repo.primary;

import com.sac.multiple_datasource.model.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sachith Rathnasiri
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
