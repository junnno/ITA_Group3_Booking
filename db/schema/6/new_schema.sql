--DROP TABLESPACEdrop table gs_container;
drop table gs_container;
drop table gs_booking;
drop table gs_users;

--------------------------------------------------------
--  File created - Saturday-September-09-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table GS_USERS
--------------------------------------------------------

  CREATE TABLE "GS_USERS" 
   (	"ID" NUMBER(10,0), 
	"USERNAME" VARCHAR2(20 CHAR), 
	"PASSWORD" VARCHAR2(20 CHAR), 
	"ROLE" NUMBER(1,0), 
	"EMAIL" VARCHAR2(30 CHAR), 
	"FIRST_NAME" VARCHAR2(30 CHAR), 
	"LAST_NAME" VARCHAR2(30 CHAR)
   );
--------------------------------------------------------
--  DDL for Table GS_CONTAINER
--------------------------------------------------------

  CREATE TABLE "GS_CONTAINER" 
   ("CONTAINER_ID" NUMBER(10,0), 
	"BKG_NUM" VARCHAR2(10 CHAR), 
	"GROSS_WEIGHT" NUMBER(10,2), 
	"NET_WEIGHT" NUMBER(10,2), 
	"UNIT" NUMBER(1,0) DEFAULT 0, 
	"CONTAINER_NUM" VARCHAR2(10 CHAR), 
	"CARGO_NATURE" VARCHAR2(2 CHAR), 
	"CONTAINER_TYPE" VARCHAR2(4 CHAR), 
	"CARGO_DESC" VARCHAR2(100 CHAR)
   );
--------------------------------------------------------
--  DDL for Table GS_BOOKING
--------------------------------------------------------

  CREATE TABLE "GS_BOOKING" 
   (	"BKG_NUM" VARCHAR2(10 CHAR), 
	"STATUS" NUMBER(1,0) DEFAULT 0, 
	"IS_VALID_WEIGHT" NUMBER(1,0) DEFAULT 0, 
	"IS_APPROVED_DOC" NUMBER(1,0) DEFAULT 0, 
	"IS_GOOD_CUSTOMER" NUMBER(1,0) DEFAULT 0, 
	"CONSIGNEE" VARCHAR2(40 CHAR), 
	"SHIPPER" VARCHAR2(40 CHAR), 
	"FROM_CITY" VARCHAR2(3 CHAR), 
	"TO_CITY" VARCHAR2(3 CHAR), 
	"BKG_ID" NUMBER(10,0), 
	"IS_DELETED" NUMBER(1,0) DEFAULT 1
   ) ;
--------------------------------------------------------
--  DDL for Index GS_USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_USERS_PK" ON "GS_USERS" ("ID");
  
--------------------------------------------------------
--  DDL for Index GS_USERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_USERS_UK1" ON "GS_USERS" ("USERNAME");

--------------------------------------------------------
--  DDL for Index GS_USERS_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_USERS_UK2" ON "GS_USERS" ("EMAIL");
--------------------------------------------------------
--  DDL for Index GS_CONTAINER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_CONTAINER_PK" ON "GS_CONTAINER" ("CONTAINER_ID");
--------------------------------------------------------
--  DDL for Index GS_CONTAINER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_CONTAINER_UK1" ON "GS_CONTAINER" ("CONTAINER_NUM");
--------------------------------------------------------
--  DDL for Index GS_BOOKING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_BOOKING_PK" ON "GS_BOOKING" ("BKG_ID");
--------------------------------------------------------
--  DDL for Index GS_BOOKING_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "GS_BOOKING_UK1" ON "GS_BOOKING" ("BKG_NUM");
--------------------------------------------------------
--  Constraints for Table GS_USERS
--------------------------------------------------------

  ALTER TABLE "GS_USERS" ADD CONSTRAINT "GS_USERS_UK2" UNIQUE ("EMAIL");
  ALTER TABLE "GS_USERS" ADD CONSTRAINT "GS_USERS_UK1" UNIQUE ("USERNAME");
  ALTER TABLE "GS_USERS" ADD CONSTRAINT "GS_USERS_PK" PRIMARY KEY ("ID");
  ALTER TABLE "GS_USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "GS_USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GS_CONTAINER
--------------------------------------------------------

  ALTER TABLE "GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_UK1" UNIQUE ("CONTAINER_NUM");
  ALTER TABLE "GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_PK" PRIMARY KEY ("CONTAINER_ID");
  ALTER TABLE "GS_CONTAINER" MODIFY ("CARGO_NATURE" NOT NULL ENABLE);
  ALTER TABLE "GS_CONTAINER" MODIFY ("CONTAINER_NUM" NOT NULL ENABLE);
  ALTER TABLE "GS_CONTAINER" MODIFY ("UNIT" NOT NULL ENABLE);
  ALTER TABLE "GS_CONTAINER" MODIFY ("BKG_NUM" NOT NULL ENABLE);
  ALTER TABLE "GS_CONTAINER" MODIFY ("CONTAINER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GS_BOOKING
--------------------------------------------------------

  ALTER TABLE "GS_BOOKING" ADD CONSTRAINT "GS_BOOKING_UK1" UNIQUE ("BKG_NUM");
  ALTER TABLE "GS_BOOKING" ADD CONSTRAINT "GS_BOOKING_PK" PRIMARY KEY ("BKG_ID");
  ALTER TABLE "GS_BOOKING" MODIFY ("TO_CITY" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("FROM_CITY" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("SHIPPER" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("CONSIGNEE" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("IS_GOOD_CUSTOMER" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("IS_APPROVED_DOC" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("IS_VALID_WEIGHT" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "GS_BOOKING" MODIFY ("BKG_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table GS_CONTAINER
--------------------------------------------------------

  ALTER TABLE "GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_GS_BOOKING_FK1" FOREIGN KEY ("BKG_NUM")
	  REFERENCES "GS_BOOKING" ("BKG_NUM") ENABLE;
