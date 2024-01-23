use testdb;
DROP TABLE IF EXISTS tea;
CREATE TABLE tea (
    id INT(5) unsigned AUTO_INCREMENT,
    name VARCHAR(50),
    size VARCHAR(20),
    price INT,
    PRIMARY KEY (id)
);
INSERT INTO tea(name, size, price)
VALUES ('레몬밤', 'tall', '5000');
INSERT INTO tea(name, size, price)
VALUES ('허브', 'grande', '4000');
INSERT INTO tea(name, size, price)
VALUES ('페퍼민트', 'tall', '4500');