PGDMP      9                }           shoppingCart    17.4    17.4     )           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            *           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            +           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            ,           1262    16560    shoppingCart    DATABASE     �   CREATE DATABASE "shoppingCart" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "shoppingCart";
                     postgres    false            �            1259    16571    cart    TABLE     R   CREATE TABLE public.cart (
    id bigint NOT NULL,
    user_id bigint NOT NULL
);
    DROP TABLE public.cart;
       public         heap r       postgres    false            �            1259    16570    cart_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.cart_id_seq;
       public               postgres    false    218            -           0    0    cart_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.cart_id_seq OWNED BY public.cart.id;
          public               postgres    false    217            �            1259    16578 	   cart_item    TABLE     �   CREATE TABLE public.cart_item (
    id bigint NOT NULL,
    cart_id bigint NOT NULL,
    product_id character varying(255) NOT NULL,
    price bigint NOT NULL
);
    DROP TABLE public.cart_item;
       public         heap r       postgres    false            �            1259    16577    cart_item_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cart_item_id_seq;
       public               postgres    false    220            .           0    0    cart_item_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cart_item_id_seq OWNED BY public.cart_item.id;
          public               postgres    false    219            �           2604    24752    cart id    DEFAULT     b   ALTER TABLE ONLY public.cart ALTER COLUMN id SET DEFAULT nextval('public.cart_id_seq'::regclass);
 6   ALTER TABLE public.cart ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    218    217    218            �           2604    24764    cart_item id    DEFAULT     l   ALTER TABLE ONLY public.cart_item ALTER COLUMN id SET DEFAULT nextval('public.cart_item_id_seq'::regclass);
 ;   ALTER TABLE public.cart_item ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    219    220    220            $          0    16571    cart 
   TABLE DATA           +   COPY public.cart (id, user_id) FROM stdin;
    public               postgres    false    218   �       &          0    16578 	   cart_item 
   TABLE DATA           C   COPY public.cart_item (id, cart_id, product_id, price) FROM stdin;
    public               postgres    false    220   �       /           0    0    cart_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.cart_id_seq', 3, true);
          public               postgres    false    217            0           0    0    cart_item_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.cart_item_id_seq', 3, true);
          public               postgres    false    219            �           2606    24766    cart_item cart_item_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_pkey;
       public                 postgres    false    220            �           2606    24754    cart cart_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_pkey;
       public                 postgres    false    218            �           2606    24755     cart_item cart_item_cart_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_cart_id_fkey FOREIGN KEY (cart_id) REFERENCES public.cart(id) ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_cart_id_fkey;
       public               postgres    false    4750    220    218            $      x�3�4����� m       &   F   x�����0�7��	׋/���
���b�#g�L�y�A�����'��:;���`-�ס�/�#w     