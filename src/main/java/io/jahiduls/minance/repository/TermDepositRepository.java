package io.jahiduls.minance.repository;

import io.jahiduls.minance.model.TermDepositView;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermDepositRepository extends JpaRepository<TermDepositView, UUID> {
}
