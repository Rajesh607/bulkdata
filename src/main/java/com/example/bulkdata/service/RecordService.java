package com.example.bulkdata.service;

import com.example.bulkdata.model.DataRecord;

import java.util.List;

public interface RecordService {
    List<DataRecord> saveAll(List<DataRecord> records);
    List<DataRecord> getAll();
    List<DataRecord> updateAll(List<DataRecord> records);
    public DataRecord updateById(Long id, DataRecord updated);
    void deleteAllByIds(List<Long> ids);
}
