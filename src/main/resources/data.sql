DROP TABLE IF EXISTS Craft_Beer;
CREATE TABLE Craft_Beer(
   id            INTEGER      NOT NULL PRIMARY KEY 
  ,name          VARCHAR(23)  NOT NULL
  ,category_name VARCHAR(18)  DEFAULT NULL
  ,brewery_name  VARCHAR(21)  DEFAULT NULL
  ,abv           NUMERIC(3,1) DEFAULT NULL
  ,ibu           INTEGER      DEFAULT  NULL
);


INSERT INTO Craft_Beer(id,name,category_name,brewery_name,abv,ibu) VALUES (1,'Porter','Irish Ale','McMenamins Mill Creek',5.4,35);
INSERT INTO Craft_Beer(id,name,category_name,brewery_name,abv,ibu) VALUES (2,'Free Bike Amber','North American Ale','Skagit River Brewing',4.5,30);
INSERT INTO Craft_Beer(id,name,category_name,brewery_name,abv,ibu) VALUES (3,'Krug IPA','India Pale Ale','Krug Bier',10,70);
INSERT INTO Craft_Beer(id,name,category_name,brewery_name,abv,ibu) VALUES (4,'Double New England IPA','New England IPA','Roleta Russa',6,64);
INSERT INTO Craft_Beer(id,name,category_name,brewery_name,abv,ibu) VALUES (5,'Colorado Ribeirão','Lager','Colorado',4.5,20);
