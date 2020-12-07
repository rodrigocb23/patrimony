##DIA 05/12
- Criar projeto no spring initializr 
- Criar estrutura do projeto com classes e pacotes e métodos
- Criar entidades e relacionamento entre patrimônio e marca

##DIA 06/12
- Conectar com o banco de dados
- Criar Scripts para criar tabelas 
- criar script das sequence
- Criar validaçoes dos serviços da marca e patrimônio
- Criar serviço de Upload de arquivos
- Configurações do Banco de dados no application.properties 
- Criar variáveis ambiente no application.properties para indicar a pasta onde será salva os arquivos
- Testei todos endpoints no INSOMNIA


## SCRIPTS das tabelas
-CREATE TABLE public.patrimonio(
-    tombo_id integer NOT NULL DEFAULT nextval('patrimonio_tombo_id_seq'::regclass),
-    marca_id integer NOT NULL,
-    nome character varying COLLATE pg_catalog."default",
-    descricao character varying COLLATE pg_catalog."default",
-    CONSTRAINT patrimonio_pkey PRIMARY KEY (tombo_id),
-    CONSTRAINT patrimonio_marca_id_fkey FOREIGN KEY (marca_id)
-        REFERENCES public.marca (marca_id) MATCH SIMPLE
-        ON UPDATE NO ACTION
-        ON DELETE NO ACTION
-);


-CREATE TABLE public.marca(
-    marca_id integer NOT NULL DEFAULT nextval('marca_marca_id_seq'::regclass),
-    nome character varying COLLATE pg_catalog."default" NOT NULL,
-    CONSTRAINT marca_pkey PRIMARY KEY (marca_id)
-);

-CREATE TABLE public.patrimomio_marca(
-    patrimonio_id integer NOT NULL,
-    marca_id integer NOT NULL,
-    CONSTRAINT patrimomio_marca_marca_id_fkey FOREIGN KEY (marca_id)
-        REFERENCES public.marca (marca_id) MATCH SIMPLE
-        ON UPDATE NO ACTION
-        ON DELETE NO ACTION,
-    CONSTRAINT patrimomio_marca_patrimonio_id_fkey FOREIGN KEY (patrimonio_id)
-        REFERENCES public.patrimonio (tombo_id) MATCH SIMPLE
-        ON UPDATE NO ACTION
-        ON DELETE NO ACTION
-);


##SEQUENCES
-CREATE SEQUENCE public.seq_id_marca
-    INCREMENT 1
-    START 1
-    MINVALUE 1
-    MAXVALUE 9999999
-    CACHE 1;

-ALTER SEQUENCE public.seq_id_marca
-    OWNER TO postgres;



-CREATE SEQUENCE public.seq_id_patrimonio
-    INCREMENT 1
-    START 1
-    MINVALUE 1
-    MAXVALUE 9999999
-    CACHE 1;

-ALTER SEQUENCE public.seq_id_patrimonio
-    OWNER TO postgres;