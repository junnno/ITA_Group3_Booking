--------------------------------------------------------
--  File created - Sunday-September-03-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table GS_BOOKING
--------------------------------------------------------

  CREATE TABLE "ITA"."GS_BOOKING" 
   (	"BKG_NUM" VARCHAR2(10 CHAR), 
	"STATUS" NUMBER(1,0) DEFAULT 0, 
	"IS_VALID_WEIGHT" NUMBER(1,0) DEFAULT 0, 
	"IS_APPROVED" NUMBER(1,0) DEFAULT 0, 
	"IS_GOOD_CUSTOMER" NUMBER(1,0) DEFAULT 0, 
	"CONSIGNEE" VARCHAR2(40 CHAR), 
	"SHIPPER" VARCHAR2(40 CHAR), 
	"FROM_CITY" VARCHAR2(3 CHAR), 
	"TO_CITY" VARCHAR2(3 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GS_CONTAINER
--------------------------------------------------------

  CREATE TABLE "ITA"."GS_CONTAINER" 
   (	"CONTAINER_ID" NUMBER(10,0), 
	"BKG_NUM" VARCHAR2(10 CHAR), 
	"GROSS_WEIGHT" NUMBER(10,2), 
	"NET_WEIGHT" NUMBER(10,2), 
	"UNIT" NUMBER(1,0) DEFAULT 0, 
	"CONTAINER_NUM" VARCHAR2(10 CHAR), 
	"CARGO_NATURE" VARCHAR2(2 CHAR), 
	"CONTAINER_TYPE" VARCHAR2(4 CHAR), 
	"CARGO_DESC" VARCHAR2(100 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GS_USERS
--------------------------------------------------------

  CREATE TABLE "ITA"."GS_USERS" 
   (	"ID" NUMBER(10,0), 
	"USERNAME" VARCHAR2(20 CHAR), 
	"PASSWORD" VARCHAR2(20 CHAR), 
	"ROLE" NUMBER(1,0), 
	"EMAIL" VARCHAR2(30 CHAR), 
	"FIRST_NAME" VARCHAR2(30 CHAR), 
	"LAST_NAME" VARCHAR2(30 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into ITA.GS_BOOKING
SET DEFINE OFF;
REM INSERTING into ITA.GS_CONTAINER
SET DEFINE OFF;
REM INSERTING into ITA.GS_USERS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index GS_BOOKING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_BOOKING_PK" ON "ITA"."GS_BOOKING" ("BKG_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GS_CONTAINER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_CONTAINER_PK" ON "ITA"."GS_CONTAINER" ("CONTAINER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GS_CONTAINER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_CONTAINER_UK1" ON "ITA"."GS_CONTAINER" ("CONTAINER_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GS_USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_USERS_PK" ON "ITA"."GS_USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GS_USERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_USERS_UK1" ON "ITA"."GS_USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GS_USERS_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITA"."GS_USERS_UK2" ON "ITA"."GS_USERS" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table GS_BOOKING
--------------------------------------------------------

  ALTER TABLE "ITA"."GS_BOOKING" ADD CONSTRAINT "GS_BOOKING_PK" PRIMARY KEY ("BKG_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("TO_CITY" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("FROM_CITY" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("SHIPPER" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("CONSIGNEE" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("IS_GOOD_CUSTOMER" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("IS_APPROVED" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("IS_VALID_WEIGHT" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_BOOKING" MODIFY ("BKG_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GS_CONTAINER
--------------------------------------------------------

  ALTER TABLE "ITA"."GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_UK1" UNIQUE ("CONTAINER_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_PK" PRIMARY KEY ("CONTAINER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_CONTAINER" MODIFY ("CARGO_NATURE" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_CONTAINER" MODIFY ("CONTAINER_NUM" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_CONTAINER" MODIFY ("UNIT" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_CONTAINER" MODIFY ("BKG_NUM" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_CONTAINER" MODIFY ("CONTAINER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GS_USERS
--------------------------------------------------------

  ALTER TABLE "ITA"."GS_USERS" ADD CONSTRAINT "GS_USERS_UK2" UNIQUE ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_USERS" ADD CONSTRAINT "GS_USERS_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_USERS" ADD CONSTRAINT "GS_USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ITA"."GS_USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table GS_CONTAINER
--------------------------------------------------------

  ALTER TABLE "ITA"."GS_CONTAINER" ADD CONSTRAINT "GS_CONTAINER_GS_BOOKING_FK1" FOREIGN KEY ("BKG_NUM")
	  REFERENCES "ITA"."GS_BOOKING" ("BKG_NUM") ENABLE;
