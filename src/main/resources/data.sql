CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255),
    option_a VARCHAR(255),
    option_b VARCHAR(255),
    option_c VARCHAR(255),
    option_d VARCHAR(255),
    correct_option VARCHAR(1)
);

-- Insert sample user
INSERT INTO users (id, name) VALUES (1, 'Test User');

-- Insert sample questions
INSERT INTO question (id, question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES
(1, 'What is the capital of France?', 'Paris', 'Berlin', 'Madrid', 'Rome', 'A'),
(2, 'What is 2 + 2?', '3', '4', '5', '6', 'B'),
(3, 'Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Venus', 'B');
