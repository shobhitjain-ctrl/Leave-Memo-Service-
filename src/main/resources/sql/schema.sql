CREATE TABLE leave_memos (
    id BIGSERIAL PRIMARY KEY,
    memo_type VARCHAR(255) NOT NULL CHECK (memo_type IN ('LEAVE_REQUEST', 'ENCASHMENT')),
    leave_memo_template TEXT NOT NULL
);
