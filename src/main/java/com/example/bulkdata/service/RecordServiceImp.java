package com.example.bulkdata.service;

import com.example.bulkdata.model.DataRecord;
import com.example.bulkdata.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImp implements RecordService {
    @Autowired
    private RecordRepository repository;

    public List<DataRecord> saveAll(List<DataRecord> records) {
        return repository.saveAll(records);
    }

    public List<DataRecord> getAll() {
        return repository.findAll();
    }

    public List<DataRecord> updateAll(List<DataRecord> records) {
        return repository.saveAll(records); // saveAll updates if ID is present
    }
    public DataRecord updateById(Long id, DataRecord updated) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(updated.getName());
                    record.setEmail(updated.getEmail());
                    record.setCity(updated.getCity());
                    return repository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("Record not found with ID " + id));
    }


    public void deleteAllByIds(List<Long> ids) {
        repository.deleteAllById(ids);
    }



}

