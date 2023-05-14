# 환율 계산기

## ApiKey 설정

- application-local-apikey.properties 추가하고 profile 을 local로 지정후 실행
```properties
spring.config.activate.on-profile=local
apiKey=사이트에서 발급받은 key 입력

```


## API

- 수취국가를 선택할때마다 환율을 가져오는 API
- 송금액 입력하고 submit 을 누르면 수취금액을 계산하는 API

