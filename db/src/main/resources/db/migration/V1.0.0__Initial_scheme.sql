CREATE TABLE business
(
  BusinessId   INT          NOT NULL,
  BusinessName VARCHAR(100) NOT NULL,
  VatNo        VARCHAR(12),
  CompanyRegNo VARCHAR(40),
  PRIMARY KEY (BusinessId)
);

CREATE TABLE business_user (
  BusinessUserId INT,
  Username       VARCHAR(100) NOT NULL,
  Name           VARCHAR(100),
  Surname        VARCHAR(100),
  PRIMARY KEY (BusinessUserId)
);