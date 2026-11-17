package com.miningbot.repository;

import com.miningbot.model.TrackedProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrackedProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrackedProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TrackedProduct save(
            String name,
            String url,
            String store,
            Double targetPrice) {

        jdbcTemplate.update("""
            INSERT INTO tracked_products (name, url, store, target_price)
            VALUES (?, ?, ?, ?)
            ON CONFLICT(url) DO NOTHING
            """,
                name,
                url,
                store,
                targetPrice
        );

        return findByUrl(url)
                .orElseThrow(() ->
                        new IllegalStateException("Product could not be saved"));
    }

    public Optional<TrackedProduct> findByUrl(String url) {
        return jdbcTemplate.query("""
            SELECT id, name, url, store, target_price, active, created_at
            FROM tracked_products
            WHERE url = ?
            """,
                (rs, rowNum) -> new TrackedProduct(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("url"),
                        rs.getString("store"),
                        (Double) rs.getObject("target_price"),
                        rs.getInt("active") == 1,
                        rs.getTimestamp("created_at").toLocalDateTime()
                ),
                url
        ).stream().findFirst();
    }

    public List<TrackedProduct> findAllActive() {
        return jdbcTemplate.query("""
            SELECT id, name, url, store, target_price, active, created_at
            FROM tracked_products
            WHERE active = 1
            ORDER BY created_at DESC
            """,
                (rs, rowNum) -> new TrackedProduct(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("url"),
                        rs.getString("store"),
                        (Double) rs.getObject("target_price"),
                        rs.getInt("active") == 1,
                        rs.getTimestamp("created_at").toLocalDateTime()
                )
        );
    }

}
