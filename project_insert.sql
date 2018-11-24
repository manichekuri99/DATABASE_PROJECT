insert into hospital(hos_id,name,address,type) VALUES
(1,'Apollo','731 Fondren, Houston, TX','Center Cancer '),
(2,'Narayana Hdrudhayalaya','638 Fondren, Houston, TX','Eye Care'),
(3,'Kims','3321 Fondren, Houston, TX','Children Hospital');

insert into staff(sta_id,type,name,age,salary,mobile,gender,hos_id) VALUES
  (1,'Doctor','Smith',35,80000,9876543210,'M',3),
  (2,'Doctor','Franklin',42,90000,9998887770,'M',2),
  (3,'Doctor','Alicia',32,60000,9988776655,'F',1),
  (4,'Receptionist','Wong',27,15000,8765432109,'F',1),
  (5,'Receptionist','Zelaya',23,12000,9848282878,'F',2),
  (6,'Receptionist','Ramesh',22,12000,9987879987,'M',3),
  (7,'Nurse','Jennifer',21,9000,9987879980,'F',3),
  (8,'Nurse','Wallace',27,17000,8979695949,'F',2),
  (9,'Nurse','English',24,14000,8979695940,'F',1);

insert into patient(pat_id,name,age,gender,address) VALUES
  (1,'Harsha', 19 ,'M','IIIT-B Bengalore'),
  (2,'Jon Snow', 29 ,'M','Winterfell'),
  (3,'Jaime Lannister', 40 ,'M','Kings Landing'),
  (4,'Cersei Lannister', 38 ,'F','Kings Landing'),
  (5,'Denarys Targerian', 25 ,'F','Dragon Stone'),
  (6,'Arya Stark', 19 ,'F','Winterfell');

insert into hos_pat(hos_id,pat_id) VALUES
  (1,1),
  (1,4),
  (2,2),
  (2,5),
  (3,3),
  (3,6);

insert into in_patient(in_pat_id) VALUES
  (1),
  (2),
  (3);

insert into out_patient(out_pat_id) VALUES
  (4),
  (5),
  (6);
