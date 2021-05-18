Create table
CREATE TABLE [IF NOT EXISTS] person (
      document_id integer not null
    , document_type smallint not null
    , name varchar(50) not null
    , birthDate timestamp notnull
    , primary key (document_id, document_type)
    , foreign key (document_type) references type(code)
    )
