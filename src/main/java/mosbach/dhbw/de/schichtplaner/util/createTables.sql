-- Create table for Users
CREATE TABLE group19users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL CHECK (role IN ('ADMIN', 'USER')),
    jwt_token VARCHAR(500)
);

-- Create table for Events
CREATE TABLE group19events (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    location VARCHAR(255),
    description TEXT,
    assigned_user_id INT REFERENCES users(id) ON DELETE SET NULL
);

-- Create table for Absences
CREATE TABLE group19absences (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    reason VARCHAR(255) NOT NULL
);

-- Create table for Weather Forecasts
CREATE TABLE group19weather_forecasts (
    id SERIAL PRIMARY KEY,
    forecast_date DATE NOT NULL,
    temperature_min DECIMAL(5, 2),
    temperature_max DECIMAL(5, 2),
    precipitation DECIMAL(5, 2),
    wind_speed DECIMAL(5, 2)
);