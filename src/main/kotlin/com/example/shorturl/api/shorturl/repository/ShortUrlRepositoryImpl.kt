package com.example.shorturl.api.shorturl.repository

import com.example.shorturl.api.shorturl.entity.QShortUrl.shortUrl
import com.example.shorturl.api.shorturl.entity.ShortUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ShortUrlRepositoryImpl(private val queryFactory: JPAQueryFactory): ShortUrlRepositoryCustom {

    override fun findBySeq(seq: Long): ShortUrl? {
        return queryFactory.selectFrom(shortUrl)
            .where(shortUrl.seq.eq(seq)).fetchOne()
    }

    override fun findById(id: String): ShortUrl? {
        return queryFactory.selectFrom(shortUrl)
            .where(shortUrl.id.eq(id)).fetchOne()
    }

    override fun findByLongUrl(longUrl: String): ShortUrl? {
        return queryFactory.selectFrom(shortUrl)
            .where(shortUrl.longUrl.eq(longUrl)).fetchFirst()
    }

    override fun updateIdBySeq(data: ShortUrl) {
        queryFactory.update(shortUrl)
            .set(shortUrl.id, data.id)
            .where(shortUrl.seq.eq(data.seq))
            .execute()
    }
}