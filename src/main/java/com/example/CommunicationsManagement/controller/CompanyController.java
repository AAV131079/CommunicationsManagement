package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.CompanyEntity;
import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.service.CompanyService;
import com.example.CommunicationsManagement.service.SendChannelTypeService;
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
@RequestMapping("/companies")
@Api("Методы обработки компаний")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка доступных компаний")
    public List<CompanyEntity> CompanysList() {
        return companyService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка компании по id")
    public CompanyEntity getCompany(@PathVariable Long id) {
        return companyService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление компании")
    public CompanyEntity createCompany(@RequestBody CompanyEntity company) {
        return companyService.save(company);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных компании по id")
    public CompanyEntity updateCompany(@PathVariable Long id, @RequestBody CompanyEntity company) {
        CompanyEntity existingCompany = companyService.findById(id).orElseThrow();
        BeanUtils.copyProperties(company, existingCompany, "companyId", "createTime", "updateTime");
        return companyService.save(existingCompany);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление компании по id")
    public ResponseEntity<Map<String, String>> deleteCompany(@PathVariable Long id) {
        if (companyService.deleteById(id) >0) {
            return new ResponseEntity<>(Map.of("description", "Компания успешно удалена", "id", id.toString()), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by id " + id);
        }
    }

}