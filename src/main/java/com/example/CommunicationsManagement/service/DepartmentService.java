package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.DepartmentEntity;
import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.repository.DepartmentRepository;
import com.example.CommunicationsManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;

    public DepartmentService(DepartmentRepository departmentRepository, UserRepository userRepository) {
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
    }

    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<UserEntity> findAllUsersById(Long id) {
        return userRepository.findAllUsersInDepartment(id);
    }

    public DepartmentEntity save(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public int deleteById(Long id) {
        return departmentRepository.deleteByDepartmentId(id);
    }

}
