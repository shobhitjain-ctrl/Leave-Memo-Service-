package com.example.leaveMemo.dto;

import com.example.leaveMemo.enums.LeaveMemoType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LeaveMemoDto {

    private Long id;

    @NotNull(message = "Memo type is required")
    private LeaveMemoType memoType;

    @NotBlank(message = "Leave memo template cannot be empty")
    private String leaveMemoTemplate;

    public LeaveMemoDto() {}

    public LeaveMemoDto(Long id, String leaveMemoTemplate, LeaveMemoType memoType) {
        this.id = id;
        this.leaveMemoTemplate = leaveMemoTemplate;
        this.memoType = memoType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaveMemoTemplate() {
        return leaveMemoTemplate;
    }

    public void setLeaveMemoTemplate(String leaveMemoTemplate) {
        this.leaveMemoTemplate = leaveMemoTemplate;
    }

    public LeaveMemoType getMemoType() {
        return memoType;
    }

    public void setMemoType(LeaveMemoType memoType) {
        this.memoType = memoType;
    }
}
