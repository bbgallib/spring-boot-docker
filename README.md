# spring-boot-docker
- Docker上でAppコンテナ（Java、Spring Boot）とDBコンテナ（MySQL、MyBatis）を起動させて実行する
- clone後`docker-compose up`のみでApplicationとDBが立ち上がる

## 実行環境
```
・Windows10 pro
・IntelliJ Community 2020.02
・Docker Desktop for Windows v19.03.12
・docker-compose version 1.26.2
・OpenJDK11（Docker上）
・Spring Boot:2.3.2.RELEASE
・MySQL5.7（Docker上）
・mybatis-spring-boot-starter:2.1.3
```

## Dockerコマンド
### 初期データ入れ直し
```
・コンテナ削除
$ docker system prune
・ボリューム一覧確認
$ docker volume ls
・ボリューム削除
$ docker volume rm ボリューム名
```

### 起動
```
$ docker-compose up
```

## デバッグを取りたい場合
- IntelliJ上で実行構成「REMOTE-DEBUG」をデバッグ起動（5005番ポートでリモートデバッグが起動する）
 https://blogenist.jp/2018/12/04/6786/
