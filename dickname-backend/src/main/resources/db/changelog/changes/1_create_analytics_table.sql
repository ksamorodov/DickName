CREATE TABLE analytics (
    id SERIAL PRIMARY KEY,
    session_id UUID,
    host text not null,
    request TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);