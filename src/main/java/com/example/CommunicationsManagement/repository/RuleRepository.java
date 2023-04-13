package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RuleRepository extends JpaRepository<RuleEntity, Long> {
    @Modifying
    @Transactional
    int deleteByRuleId(Long id);
}
