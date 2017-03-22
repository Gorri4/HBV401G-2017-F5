BEGIN TRANSACTION;

DROP TABLE if exists Flights;

CREATE TABLE Flights(
  flightNum int PRIMARY KEY,
  departureTime DATETIME,
  arrivalTime DATETIME,
  departureCity varchar(30),
  arrivalCity varchar(30),
  airline varchar(30),
  price float,
  CHECK (departureTime < arrivalTime)
);

INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(100,DATETIME('2017-06-01 06:00:00.000'),DATETIME('2017-06-01 08:30:00.000'),'Reykjavik','London','Icelandair','30000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(200,DATETIME('2017-06-01 06:30:00.000'),DATETIME('2017-06-01 08:30:00.000'),'Reykjavik','Copenhagen','Icelandair','25000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(300,DATETIME('2017-06-01 07:30:00.000'),DATETIME('2017-06-01 11:00:00.000'),'Reykjavik','Stockholm','Icelandair','35000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(400,DATETIME('2017-06-01 07:00:00.000'),DATETIME('2017-06-01 10:30:00.000'),'Reykjavik','Oslo','Icelandair','32000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(101,DATETIME('2017-06-01 16:30:00.000'),DATETIME('2017-06-01 19:00:00.000'),'Reykjavik','London','Icelandair','20000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(201,DATETIME('2017-06-01 15:30:00.000'),DATETIME('2017-06-01 17:30:00.000'),'Reykjavik','Copenhagen','Icelandair','20000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(301,DATETIME('2017-06-01 13:30:00.000'),DATETIME('2017-06-01 17:00:00.000'),'Reykjavik','Stockholm','Icelandair','40000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(401,DATETIME('2017-06-01 14:00:00.000'),DATETIME('2017-06-01 17:30:00.000'),'Reykjavik','Oslo','Icelandair','40000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(102,DATETIME('2017-06-01 21:30:00.000'),DATETIME('2017-06-02 00:00:00.000'),'Reykjavik','London','Wowair','25000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(202,DATETIME('2017-06-01 20:30:00.000'),DATETIME('2017-06-01 22:30:00.000'),'Reykjavik','Copenhagen','Wowair','15000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(302,DATETIME('2017-06-01 20:00:00.000'),DATETIME('2017-06-01 23:30:00.000'),'Reykjavik','Stockholm','Wowair','35000');
INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, airline, price) VALUES(402,DATETIME('2017-06-01 21:30:00.000'),DATETIME('2017-06-02 01:00:00.000'),'Reykjavik','Oslo','Wowair','30000');


COMMIT;
