package com.example.leaveMemo.repository;


import com.example.leaveMemo.entity.LeaveMemo;
import com.example.leaveMemo.enums.LeaveMemoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeaveMemoRepository extends JpaRepository<LeaveMemo, Long> {

    List<LeaveMemo> findByMemoType(LeaveMemoType memoType);

}
