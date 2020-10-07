DROP TABLE IF EXISTS Craft_Beer;
CREATE TABLE Craft_Beer(
   id            INTEGER      auto_increment PRIMARY KEY 
  ,name          VARCHAR(23)  NOT NULL
  ,category_name VARCHAR(18)  DEFAULT NULL
  ,brewery_name  VARCHAR(21)  DEFAULT NULL
  ,abv           NUMERIC(3,1) DEFAULT NULL
  ,ibu           INTEGER      DEFAULT  NULL
);


INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Porter','Irish Ale','McMenamins Mill Creek',5.4,35);
INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Free Bike Amber','North American Ale','Skagit River Brewing',4.5,30);
INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Krug IPA','India Pale Ale','Krug Bier',10,70);
INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Double New England IPA','New England IPA','Roleta Russa',6,64);
INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Colorado Ribeirão','Lager','Colorado',4.5,20);
INSERT INTO Craft_Beer(name,category_name,brewery_name,abv,ibu) VALUES ('Porter','London Porter','Hebling',5,25);
