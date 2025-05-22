package com.example.bulkdata.controller;

import com.example.bulkdata.model.DataRecord;
import com.example.bulkdata.service.RecordServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {
    @Autowired
    private RecordServiceImp service;

    @PostMapping("/bulk")
    public ResponseEntity<List<DataRecord>> saveBulk(@RequestBody List<DataRecord> records) {
        return new ResponseEntity<>(service.saveAll(records), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DataRecord>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/bulk")
    public ResponseEntity<List<DataRecord>> updateBulk(@RequestBody List<DataRecord> records) {
        return new ResponseEntity<>(service.updateAll(records), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DataRecord> updateById(
            @PathVariable Long id,
            @RequestBody DataRecord updatedRecord) {

        DataRecord result = service.updateById(id, updatedRecord);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteBulk(@RequestBody List<Long> ids) {
        service.deleteAllByIds(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
