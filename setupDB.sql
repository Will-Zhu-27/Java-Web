DROP TABLE IF EXISTS subjects CASCADE;

CREATE TABLE subjects(
   code   VARCHAR(20),
   name  VARCHAR(50),
   coordinator VARCHAR(50),
   PRIMARY KEY (code)
);

INSERT INTO subjects
VALUES ('SWEN90007', 'Software Design and Architecture', 'yuqiang');