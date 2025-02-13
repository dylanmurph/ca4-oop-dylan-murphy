DROP
DATABASE IF EXISTS `accounts_tracker`;

CREATE
DATABASE `accounts_tracker`;

USE
`accounts_tracker`;

DROP TABLE IF EXISTS `income`, `expenses`;

CREATE TABLE `income`
(
    `incomeID`   INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`      VARCHAR(40),
    `note`       VARCHAR(100),
    `amount` DOUBLE,
    `dateEarned` DATE
);

CREATE TABLE `expenses`
(
    `expenseID`    INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`        VARCHAR(40),
    `note`         VARCHAR(100),
    `amount` DOUBLE,
    `dateIncurred` DATE
);

INSERT INTO `income` (`title`, `note`, `amount`, `dateEarned`)
VALUES ('ATS', 'Weekly income', 600, '2025-01-03'),
       ('Car Detailing', 'Monthly car clean 2 cars', 150, '2025-01-04'),
       ('ATS', 'Weekly income', 600, '2025-01-10'),
       ('ATS', 'Weekly income', 600, '2025-01-17'),
       ('ATS', 'Weekly income', 600, '2025-01-24');

INSERT INTO `expenses` (`title`, `note`, `amount`, `dateIncurred`)
VALUES ('Rent', 'Food/rent/utilities to girlfriend', 150, '2025-01-05'),
       ('Car', 'Diesel fillup', 65, '2025-01-05'),
       ('Revolut', 'Revolut savings account', 150, '2025-01-05'),
       ('Revolut', 'Weekly living', 150, '2025-01-05'),

       ('Rent', 'Food/rent/utilities to girlfriend', 150, '2025-01-12'),
       ('Car', 'Diesel fillup', 65, '2025-01-12'),
       ('Revolut', 'Revolut savings account', 150, '2025-01-12'),
       ('Revolut', 'Weekly living', 150, '2025-01-12'),

       ('Rent', 'Food/rent/utilities to girlfriend', 150, '2025-01-19'),
       ('Car', 'Diesel fillup', 65, '2025-01-19'),
       ('Revolut', 'Revolut savings account', 150, '2025-01-19'),
       ('Revolut', 'Weekly living', 150, '2025-01-19'),

       ('Rent', 'Food/rent/utilities to girlfriend', 150, '2025-01-26'),
       ('Car', 'Diesel fillup', 65, '2025-01-26'),
       ('Revolut', 'Revolut savings account', 150, '2025-01-26'),
       ('Revolut', 'Weekly living', 150, '2025-01-26'),
       ('Vodafone', 'Monthly broadband bill', 40, '2025-01-26'),
       ('Three', 'Monthly phone bill', 30, '2025-01-26'),
       ('Spotify', 'Monthly spotify bill', 10, '2025-01-26'),
       ('Revolut', 'Monthly car insurance/tax savings', 110, '2025-01-26');

