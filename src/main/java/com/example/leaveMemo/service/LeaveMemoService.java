package com.example.leaveMemo.service;

import com.example.leaveMemo.dto.LeaveMemoDto;
import com.example.leaveMemo.enums.LeaveMemoType;



import java.util.List;

public interface LeaveMemoService {

    LeaveMemoDto createLeaveMemo(LeaveMemoDto leaveMemoDto);

    List<LeaveMemoDto> getAllLeaveMemo();

    LeaveMemoDto getLeaveMemoById(Long id);

    List<LeaveMemoDto> getLeaveMemoByType(LeaveMemoType memoType );

    LeaveMemoDto updateLeaveMemo(Long id, LeaveMemoDto leaveMemoDto);

    void deleteLeaveMemo(Long id);

}
