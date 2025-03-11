CREATE TABLE IF NOT EXISTS
    users (
              id BIGINT AUTO_INCREMENT PRIMARY KEY,
              name VARCHAR(100) NOT NULL,
              email VARCHAR(100) UNIQUE NOT NULL
    );
