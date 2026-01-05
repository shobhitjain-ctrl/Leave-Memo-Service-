package com.example.leaveMemo.service.impl;

import com.example.leaveMemo.dto.LeaveMemoDto;
import com.example.leaveMemo.entity.LeaveMemo;
import com.example.leaveMemo.enums.LeaveMemoType;
import com.example.leaveMemo.exception.ResourceNotFoundException;
import com.example.leaveMemo.repository.LeaveMemoRepository;
import com.example.leaveMemo.service.LeaveMemoService;



import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveMemoServiceImpl implements LeaveMemoService {

    private final LeaveMemoRepository leaveMemoRepository;

    public LeaveMemoServiceImpl(LeaveMemoRepository leaveMemoRepository) {
        this.leaveMemoRepository = leaveMemoRepository;
    }


    @Override
    public LeaveMemoDto createLeaveMemo(LeaveMemoDto leaveMemoDto) {
        LeaveMemo memo = mapDtoToEntity(leaveMemoDto);
        LeaveMemo saved = leaveMemoRepository.save(memo);
        return mapEntityToDto(saved);
    }

    @Override
    public List<LeaveMemoDto> getAllLeaveMemo() {
        List<LeaveMemo> memos = leaveMemoRepository.findAll();
        return memos.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveMemoDto getLeaveMemoById(Long id) {
        LeaveMemo memo = leaveMemoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave Memo not found with id: " + id));
        return mapEntityToDto(memo);
    }


    @Override
    public List<LeaveMemoDto> getLeaveMemoByType(LeaveMemoType memoType) {
        List<LeaveMemo> memos = leaveMemoRepository.findByMemoType(memoType);
        return memos.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveMemoDto updateLeaveMemo(Long id, LeaveMemoDto leaveMemoDto) {
        LeaveMemo memo = leaveMemoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave Memo not found with id: " + id));

        memo.setMemoType(leaveMemoDto.getMemoType());
        memo.setLeaveMemoTemplate(leaveMemoDto.getLeaveMemoTemplate());

        LeaveMemo updatedMemo = leaveMemoRepository.save(memo);
        return mapEntityToDto(updatedMemo);
    }

    @Override
    public void deleteLeaveMemo(Long id) {
        if(!leaveMemoRepository.existsById(id)){
            throw new ResourceNotFoundException("Leave Memo not found with id: " + id);
        }
        leaveMemoRepository.deleteById(id);
    }


    // DTO Methods

    // Converting Dto to Entity
    private LeaveMemo mapDtoToEntity(LeaveMemoDto dto){
        LeaveMemo memo = new LeaveMemo();
        memo.setMemoType(dto.getMemoType());
        memo.setLeaveMemoTemplate(dto.getLeaveMemoTemplate());
        return memo;
    }

    // Converting Entity to Dto
    private LeaveMemoDto mapEntityToDto(LeaveMemo entity){
        LeaveMemoDto dto = new LeaveMemoDto();
        dto.setId(entity.getId());
        dto.setMemoType(entity.getMemoType());
        dto.setLeaveMemoTemplate(entity.getLeaveMemoTemplate());
        return dto;
    }


}
