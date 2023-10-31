# short-url 단축 URL 서비스

### 테이블 정보

```
create table short_url
(
    seq        bigint auto_increment comment 'SHORT URL 일련번호'
        primary key,
    id         varchar(10)                           null comment 'base62 키',
    long_url   varchar(1000)                         not null comment '원본 URL',
    created_at timestamp default current_timestamp() not null
);

create index short_url_id_idx_01
    on test_db.short_url (id);
```


### workflow
![](https://velog.velcdn.com/images/charles_ahn/post/d9a34638-d944-4279-a753-4a632f092a34/image.png)
