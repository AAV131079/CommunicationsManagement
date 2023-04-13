package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.DepartmentEntity;
import com.example.CommunicationsManagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public DepartmentEntity save(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public int deleteById(Long id) {
        return departmentRepository.deleteByDepartmentId(id);
    }

}
