package com.example.leaveMemo.entity;

import com.example.leaveMemo.enums.LeaveMemoType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leave_memos")
public class LeaveMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "memo_type", nullable = false)
    private LeaveMemoType memoType;

    @Column(columnDefinition = "TEXT")
    private String leaveMemoTemplate;


    public LeaveMemo() {}

    public LeaveMemo(String leaveMemoTemplate, LeaveMemoType memoType) {
        this.leaveMemoTemplate = leaveMemoTemplate;
        this.memoType = memoType;
    }


    public Long getId() {
        return id;
    }

    public LeaveMemoType getMemoType() {
        return memoType;
    }

    public void setMemoType(LeaveMemoType memoType) {
        this.memoType = memoType;
    }

    public String getLeaveMemoTemplate() {
        return leaveMemoTemplate;
    }

    public void setLeaveMemoTemplate(String leaveMemoTemplate) {
        this.leaveMemoTemplate = leaveMemoTemplate;
    }
}
