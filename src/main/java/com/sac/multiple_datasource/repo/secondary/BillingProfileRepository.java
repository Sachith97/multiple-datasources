package com.sac.multiple_datasource.repo.secondary;

import com.sac.multiple_datasource.model.secondary.BillingProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sachith Rathnasiri
 */
@Repository
public interface BillingProfileRepository extends JpaRepository<BillingProfile, Long> {

    List<BillingProfile> findAllByUserEmpIdAndStatus(String empId, String status);
}
