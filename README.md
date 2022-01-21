# docoTsubu
URL：https://docotsubu-app.herokuapp.com/  
パスワード：1234

## 参考資料
https://sukkiri.jp/books/sukkiri_servlet2  
この書籍に掲載されているアプリケーションを参考にしました。

## 開発環境
利用言語：Java、Java Servlet、JSP  
ミドルウェア：Apache、Tomcat  
プラットフォーム：Heroku  
データベース：PostgreSQL  
IDE：eclipse

# アプリ名：どこつぶ
どこでも短い文字情報（つぶやき）を投稿できる、チャットアプリです。  

## 開発目的
・言語の学習  
・DBの学習と実践  
・デプロイの実践  

## デプロイ方法
参考書にはApache Tomcatを利用して、ローカル上で動かすまでの解説しかありませんでした。  
そこで、Herokuのサービスを使い、デプロイする事を試みました。  
デプロイの方法は以下のHeroku公式サイトを参考にしました。  
https://devcenter.heroku.com/ja/articles/war-deployment  
eclipseで作成した動的Webプロジェクトを、warファイルにエクスポートし、Heroku CLIを利用して、デプロイしました。  

## DBの設定
参考書では、H2 Databaseを利用していましたが、  
デプロイするにあたり、Herokuサーバーに合わせ、PostgreSQLに変更することにしました。  
アドオン方法や接続は、下記のサイトを参考にしました。  
https://devcenter.heroku.com/ja/articles/heroku-postgresql#connecting-in-java  
DAOクラスでは、下記のようにして、JDBCのURL、ユーザーとパスワードを取得しています。  
```Java
private final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");  
private final String DB_USER = System.getenv("JDBC_DATABASE_USERNAME​");  
private final String DB_PASS = System.getenv("JDBC_DATABASE_PASSWORD");
```
DBでは、以下のようなカラム情報を持った、MUTTERテーブルを作成しました。     
```
docotsubu-app::DATABASE=> \d MUTTER
                                    Table "public.mutter"
 Column |          Type          | Collation | Nullable |              Default               
--------+------------------------+-----------+----------+------------------------------------
 id     | integer                |           | not null | nextval('mutter_id_seq'::regclass)
 name   | character varying(100) |           | not null |
 text   | character varying(255) |           | not null |
Indexes:
    "mutter_pkey" PRIMARY KEY, btree (id)
```
MUTTERテーブルの作成は以下のSQLで行いました。
```SQL
CREATE TABLE MUTTER(
  ID SERIAL,
  NAME VARCHAR(100) NOT NULL,
  TEXT VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
);
```
つぶやきのデータベースはありますが、ユーザーを管理しているデータベースは無いです。  
現状、ログイン機能は形だけのモノになっています。  

## 改善点
・ユーザーのデータベースの作成とログイン機能の完成  
・つぶやいた時間の表示  
・ユーザーのログインアウト時間の表示  
