package com.example.leaveMemo.controller;

import com.example.leaveMemo.dto.LeaveMemoDto;
import com.example.leaveMemo.enums.LeaveMemoType;
import com.example.leaveMemo.service.LeaveMemoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-memos")
public class LeaveMemoController {

    private final LeaveMemoService leaveMemoService;

    public LeaveMemoController(LeaveMemoService leaveMemoService) {
        this.leaveMemoService = leaveMemoService;
    }

    @PostMapping
    public ResponseEntity<LeaveMemoDto> createLeaveMemo(@Valid @RequestBody LeaveMemoDto requestDto) {
        LeaveMemoDto responseDto = leaveMemoService.createLeaveMemo(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveMemoDto> getLeaveMemoById(@PathVariable("id") Long id) {
        LeaveMemoDto responseDto = leaveMemoService.getLeaveMemoById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<LeaveMemoDto>> getAllLeaveMemos(){
        List<LeaveMemoDto> memos = leaveMemoService.getAllLeaveMemo();
        return ResponseEntity.ok(memos);
    }

    @GetMapping("/type/{memoType}")
    public ResponseEntity<List<LeaveMemoDto>> getAllLeaveMemosByType(@PathVariable("memoType") LeaveMemoType memoType){
        List<LeaveMemoDto> memos = leaveMemoService.getLeaveMemoByType(memoType);
        return ResponseEntity.ok(memos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveMemoDto> updateLeaveMemo(@PathVariable Long id, @Valid @RequestBody LeaveMemoDto requestDto) {
        LeaveMemoDto responseDto = leaveMemoService.updateLeaveMemo(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LeaveMemoDto> deleteLeaveMemo(@PathVariable Long id) {
        leaveMemoService.deleteLeaveMemo(id);
        return ResponseEntity.noContent().build();
    }

}
