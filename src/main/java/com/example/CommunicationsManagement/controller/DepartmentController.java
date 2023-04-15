package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.DepartmentEntity;
import com.example.CommunicationsManagement.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/departments")
@Api("Методы обработки департаментов компании")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка доступных департаментов компании")
    public List<DepartmentEntity> departmentsList() {
        return departmentService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка департамента компании по id")
    public DepartmentEntity getDepartment(@PathVariable Long id) {
        return departmentService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление департамента компании")
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity department) {
        return departmentService.save(department);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных департамента компании по id")
    public DepartmentEntity updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity department) {
        DepartmentEntity existingDepartment = departmentService.findById(id).orElseThrow();
        BeanUtils.copyProperties(department, existingDepartment, "departmentId", "createTime", "updateTime");
        return departmentService.save(existingDepartment);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление департамента компании по id")
    public ResponseEntity<Map<String, String>> deleteDepartment(@PathVariable Long id) {
        if (departmentService.deleteById(id) >0) {
            return new ResponseEntity<>(Map.of("description", "Департамент компании успешно удален", "id", id.toString()), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by id " + id);
        }
    }

}