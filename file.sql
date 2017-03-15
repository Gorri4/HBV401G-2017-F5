BEGIN TRANSACTION;

DROP TABLE if exists Flights;

CREATE TABLE Flights(
  flightNum int,
  departureTime varchar(30),
  arrivalTime varchar(30),
  departureCity varchar(30),
  arrivalCity varchar(30),
  price float
);

INSERT INTO Flights(flightNum, departureTime, arrivalTime, departureCity, arrivalCity, price) VALUES(100,'13:00','16:00','Reykjavik','London','30000');


COMMIT;