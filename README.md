# spring-boot-docker
- Docker上でDBコンテナ（MySQL）を起動し、アプリケーションはホストOSで起動する
- clone後に`docker-compose up`でDBを起動し、`./gradlew bootRun`でアプリを起動する

## 実行環境
```
・Java 21
・Spring Boot:4.0.1
・MySQL5.7（Docker上）
・mybatis-spring-boot-starter:3.0.4
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

### 起動（DBのみ）
```
$ docker-compose up
```

## アプリケーション起動
```
$ ./gradlew bootRun
```
