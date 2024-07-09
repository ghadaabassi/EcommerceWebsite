CREATE TABLE IF NOT EXISTS file (
                                    id integer PRIMARY KEY,
                                    file_name VARCHAR(255) NOT NULL,
                                    data BYTEA
);



CREATE TABLE IF NOT EXISTS product (
                                       id integer not null PRIMARY KEY,
                                       name VARCHAR(255),
                                       description VARCHAR(255),
                                       qt double precision not null,
                                       price numeric(38, 2) ,
                                       category VARCHAR(255),
                                       file_id integer
                                            constraint  FileForeignKey  REFERENCES file
);

create sequence if not exists file_seq increment by 50;
create sequence if not exists product_seq increment by 50;

