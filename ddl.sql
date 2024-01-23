CREATE TABLE "user" (
    name VARCHAR(255),
    age INTEGER,
    email VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

CREATE USER spring_app WITH PASSWORD 'springdb123';
GRANT ALL PRIVILEGES ON DATABASE spring_db TO spring_app;
ALTER USER spring_app WITH PASSWORD 'springdbpassword';
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO spring_app;