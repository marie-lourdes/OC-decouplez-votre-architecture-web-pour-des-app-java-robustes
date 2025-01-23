CREATE TABLE clients( 
id int NOT NULL AUTO_INCREMENT  PRIMARY KEY,
first_name VARCHAR(100) ,
last_name VARCHAR(100) ,
address VARCHAR(150),
telephone VARCHAR(100),
outstanding_Balance float NULL
);

INSERT INTO clients(first_name,last_name,address,telephone) VALUES ('firstname client','lastname client','address client','telephone client');

CREATE TABLE reservations( 
id int NOT NULL AUTO_INCREMENT  PRIMARY KEY,
name VARCHAR(100) ,
destination VARCHAR(150),
departure_date VARCHAR(100),
return_date VARCHAR(15) 
);

/*INSERT INTO reservations VALUES (1,'hedh','hhjg','hjjj','hbhj');*/