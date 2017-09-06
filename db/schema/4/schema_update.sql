ALTER TABLE GS_BOOKING
ADD BKG_ID NUMBER(10,0);

ALTER TABLE GS_CONTAINER
DROP CONSTRAINT gs_container_gs_booking_fk1;

ALTER TABLE gs_booking
DROP CONSTRAINT gs_booking_pk;

ALTER TABLE gs_booking
ADD CONSTRAINT gs_booking_pk PRIMARY KEY (bkg_id);

ALTER TABLE gs_booking
ADD CONSTRAINT gs_booking_uk1 UNIQUE (bkg_num);

ALTER TABLE gs_container
ADD CONSTRAINT gs_container_gs_booking_fk1 FOREIGN KEY (bkg_num)
REFERENCES gs_booking(bkg_num) enable;
