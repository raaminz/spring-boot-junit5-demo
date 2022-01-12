create table ADDRESSES (   address_id        NUMERIC(15) not null,   address1          VARCHAR(40) not null,   address2          VARCHAR(40),   city              VARCHAR(40) not null,   postal_code       VARCHAR(12),   state_province    VARCHAR(40) not null,   country_id        CHAR(2) not null,   longitude         NUMERIC,   latitude          NUMERIC,created_by        VARCHAR(60) not null,   creation_date     DATE not null,   last_updated_by   VARCHAR(60) not null,   last_update_date  DATE not null,   object_version_id NUMERIC(15) not null );

alter table ADDRESSES   add constraint ADDRESSES_PK primary key (ADDRESS_ID);

create table WAREHOUSES (   warehouse_id      NUMERIC(15) not null,   address_id        NUMERIC(15) not null,   warehouse_name    VARCHAR(35) not null,created_by        VARCHAR(60) not null,   creation_date     DATE not null,   last_updated_by   VARCHAR(60) not null,   last_update_date  DATE not null,   object_version_id NUMERIC(15) not null ) ;

alter table WAREHOUSES  add constraint WAREHOUSES_PK primary key (WAREHOUSE_ID);
alter table WAREHOUSES  add constraint ADDRESS_ID_FK foreign key (ADDRESS_ID) REFERENCES ADDRESSES(ADDRESS_ID);
