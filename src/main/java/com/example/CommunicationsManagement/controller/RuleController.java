package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.RuleEntity;
import com.example.CommunicationsManagement.service.RuleService;
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
@RequestMapping("/rules")
@Api("Методы обработки правил коммуникации для подразделений")
public class RuleController {

    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка доступных правил коммуникации")
    public List<RuleEntity> rulesList() {
        return ruleService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка правила коммуникации по id")
    public RuleEntity getRule(@PathVariable Long id) {
        return ruleService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление правила коммуникации")
    public RuleEntity createRule(@RequestBody RuleEntity rule) {
        return ruleService.save(rule);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных правила коммуникации по id")
    public RuleEntity updateRule(@PathVariable Long id, @RequestBody RuleEntity rule) {
        RuleEntity existingRule = ruleService.findById(id).orElseThrow();
        BeanUtils.copyProperties(rule, existingRule, "ruleId", "createTime", "updateTime");
        return ruleService.save(existingRule);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление правила коммуникации по id")
    public ResponseEntity<Map<String, String>> deleteRule(@PathVariable Long id) {
        if (ruleService.deleteById(id) >0) {
            return new ResponseEntity<>(Map.of("description", "Правило коммуникации успешно удалено", "id", id.toString()), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by id " + id);
        }
    }

}