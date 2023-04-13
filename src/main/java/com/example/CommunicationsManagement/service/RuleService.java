package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.RuleEntity;
import com.example.CommunicationsManagement.repository.RuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public List<RuleEntity> findAll() {
        return ruleRepository.findAll();
    }

    public Optional<RuleEntity> findById(Long id) {
        return ruleRepository.findById(id);
    }

    public RuleEntity save(RuleEntity rule) {
        return ruleRepository.save(rule);
    }

    public int deleteById(Long id) {
        return ruleRepository.deleteByRuleId(id);
    }

}