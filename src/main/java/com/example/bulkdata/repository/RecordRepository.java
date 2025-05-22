package com.example.bulkdata.repository;

import com.example.bulkdata.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<DataRecord, Long> {
}

